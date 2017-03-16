package ee.helmes.database;

import ee.helmes.mapping.Action;
import ee.helmes.utilities.IOConfigFileUtility;

import java.sql.*;
import java.util.Properties;


/**
 * Created by anton.mazur on 3/10/2017.
 */
public class Connectiond implements Action {


    public Connectiond() {
    }


    private Connection getConnection(){

        Properties properties = IOConfigFileUtility.getProperties();

         String JDBC_DRIVER = properties.getProperty("db.driver");
         String HOST = properties.getProperty("db.host");
         String USER_NAME = properties.getProperty("db.login");
         String PASSWORD = properties.getProperty("db.password");

        Connection con = null;

        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(HOST, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    @Override
    public String resolveFunctionality() {

        StringBuilder sb = null;
        Connection con = getConnection();
        PreparedStatement ps = null;
        try {
            sb = new StringBuilder();

            ps = con.prepareStatement("select * from peopledata where peopledata_name=?");
            ps.setString(1, "slava");

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            sb.append(rsmd.getColumnCount());
            sb.append("works");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
