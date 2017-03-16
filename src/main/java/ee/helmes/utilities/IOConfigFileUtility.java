package ee.helmes.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by anton.mazur on 3/14/2017.
 */
public final class IOConfigFileUtility {

    private static final String CONFIG_FILE_NAME = "config.properties";

    public static Properties getProperties() {

        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try {
            InputStream resourceStream = loader.getResourceAsStream(CONFIG_FILE_NAME);
            if (resourceStream != null) {
                properties.load(resourceStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
