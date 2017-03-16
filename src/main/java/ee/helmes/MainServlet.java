package ee.helmes;

import ee.helmes.mapping.MappingFunctionalty;
import ee.helmes.utilities.ChooseActionUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by anton.mazur on 3/4/2017.
 */
@WebServlet("/home/*")
public class MainServlet extends HttpServlet {

    private MappingFunctionalty doSomeAction = new MappingFunctionalty();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ChooseActionUtility.findAndExecuteAction(request, doSomeAction);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //response.setContentType("text/html");
        //PrintWriter out = response.getWriter();

        ChooseActionUtility.findAndExecuteAction(request, doSomeAction);
    }

}
