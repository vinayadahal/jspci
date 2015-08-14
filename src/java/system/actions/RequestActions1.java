package system.actions;

import application.configuration.Path;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import javax.servlet.http.HttpServletResponse;

public class RequestActions1 {

    RequestError error = new RequestError();

    public String controllerClass;
    public String method;
    public String args;

    public Object loopUrl(String[] urlKey) {
        
        System.out.println(urlKey.length);
        System.out.println("initial: " + Arrays.toString(urlKey));
        String StartSlash = null;
        String EndSlash = null;
        String ContextPath = null;
        for (String urls : urlKey) {
            if (urls.startsWith("/")) {
                StartSlash = urls.substring(1);
            }
            if (urls.endsWith("/")) {
                EndSlash = urls.substring(0, urls.length() - 1);
            }
            if (urls.contains("/")) {
                String contextPath = urls.substring(0, urls.indexOf("/"));
                System.out.println("if contains " + urls);
                ContextPath = contextPath;
            }
        }
        System.out.println(StartSlash + " | " + EndSlash);
        if (StartSlash != null && EndSlash != null) {
            if (StartSlash.equals(EndSlash)) {
                System.out.println("common detected");
            }
        }

        Path maps = new Path();
        maps.setRoutes();
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
                if (urlKey1.equals("/" + StartSlash)) {
                    System.out.println("/" + StartSlash + "|" + urlKey1);
                    System.out.println("trying to escape: start slash");
                    continue;
                }
                if (urlKey1.equals(EndSlash + "/")) {
                    System.out.println((EndSlash + "/ | " + urlKey1));
                    System.out.println("trying to escape: end slash");
                    Object keyName = maps.getRoutes("welcome");
                    return keyName;
                }
                System.out.println("Context Path: " + ContextPath);
                System.out.println("Start Slash: " + StartSlash);
                if (StartSlash == null ? ContextPath == null : StartSlash.equals(ContextPath)) {
                    String[] uri = urlKey1.split(StartSlash + "/");
                    System.out.println("check: " + Arrays.toString(uri));
                    Object keyName = maps.getRoutes(uri[1]);
                    return keyName;
                }

                Object keyName = maps.getRoutes(urlKey1);
                System.out.println("Final key:" + urlKey1);
                if (keyName != null) {
                    return keyName;
                }
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
