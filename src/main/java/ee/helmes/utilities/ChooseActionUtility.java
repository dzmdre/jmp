package ee.helmes.utilities;

import ee.helmes.database.Connectiond;
import ee.helmes.log4j.DD;
import ee.helmes.mapping.MappingFunctionalty;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by anton.mazur on 3/10/2017.
 */
public final class ChooseActionUtility {

    final static Logger logger = Logger.getLogger(DD.class);

    public static void findAndExecuteAction(HttpServletRequest request, MappingFunctionalty doSomeAction) {

        String[] componentsURI = request.getRequestURI().split("/");
        String requestMethod = request.getMethod().toString();
logger.debug("I'm");
        if (componentsURI.length > 3) {
            if (requestMethod.equals("GET")) {
                logger.debug("here");
                ChooseActionUtility.chooseActionForGET(componentsURI, doSomeAction);
            } else if (requestMethod.equals("POST")) {
                ChooseActionUtility.chooseActionForPOST(componentsURI, doSomeAction);
            }
        }
        execute(doSomeAction);
    }

    public static void chooseActionForGET(String[] componentsURI, MappingFunctionalty someAction) {

        if (componentsURI[3].startsWith("catca")) {
            logger.debug("and");
            someAction.setAction(new Connectiond());
        }
    }

    private static void chooseActionForPOST(String[] componentsURI, MappingFunctionalty someAction) {

        if (componentsURI[3].startsWith("catca")) {
            someAction.setAction(new Connectiond());
        }

    }

    private static void execute(MappingFunctionalty doSomeAction) {
        if (doSomeAction.getAction() != null) {
            logger.debug("here");

            doSomeAction.resolveFunctionality();
        }
    }

}
