package system.actions;

import application.configuration.Path;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletResponse;

public class RequestActionsO {

    RequestError error = new RequestError();

    public String controllerClass;
    public String method;
    public String args;

    public Object loopUrl(String[] urlKey) {
        Path maps = new Path();
        maps.setRoutes();
        
        System.out.println(urlKey.length);
        if (urlKey.length == 0) {
            Object keyName = maps.getRoutes("welcome"); // searches for 'welcome' index in Path.java
            if (keyName != null) {
                return keyName;
            } else {
                return "no-welcome";
            }
        } else {
            for (String urlKey1 : urlKey) {
                if (urlKey1.isEmpty()) {
                    continue;
                }
                Object keyName = maps.getRoutes(urlKey1);
                if (keyName != null) {
                    return keyName;
                }
                System.out.println(keyName);

            }
        }
        return "404";
    }

    public Object findClass(Object mappedUrl) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        String className = mappedUrl.toString();
        String[] ctrl = className.split("/");
        if (ctrl.length == 2) {
            controllerClass = ctrl[0];
            method = ctrl[1];
        } else if (ctrl.length == 3) {
            controllerClass = ctrl[0];
            method = ctrl[1];
            args = ctrl[2];
        } else {
            System.out.println("Path is not configured properly in path.java");
        }

        String path = "application.controller." + controllerClass;
        Class cls = Class.forName(path);
        Object objCom = cls.newInstance();
        Method classMethod = cls.getMethod(method);
        Object data = classMethod.invoke(objCom);
        return data;
    }

    public Object checkError(Object mappedUrl, HttpServletResponse response) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        Object data = null;
        if (mappedUrl == "404") {
            error.showError("Requested file cannot be found in this server. Please check the url and try again.", response);
        } else if (mappedUrl == "no-welcome") {
            error.showError("Welcome page is not set. Please set welcome page in path file. <br> <b>Example:</b> map.put(\"welcome\",\"controller-class/method-name\")", response);
        } else {
            data = findClass(mappedUrl);
        }
        return data;
    }
}
