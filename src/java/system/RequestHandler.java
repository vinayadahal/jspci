package system;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import system.actions.RequestActions;
import system.actions.RequestError;

public class RequestHandler extends HttpServlet {

    RequestActions action = new RequestActions();
    RequestError error = new RequestError();

    protected void processGet(HttpServletRequest request, HttpServletResponse response, Object data)
            throws ServletException, IOException {
        Map dataMap = ((List<Map>) data).get(0);
        Set dataSet = dataMap.keySet();
        Iterator itr = dataSet.iterator();
        while (itr.hasNext()) {
            String key = itr.next().toString();
            request.setAttribute(key, dataMap.get(key));
        }
        if (dataMap.get("viewName") == null) {
            error.showError("<b>viewName</b> is not set in controller class: <b>" + action.controllerClass + "</b>", response);
        } else {
            request.getRequestDispatcher("/" + dataMap.get("viewName").toString() + ".jsp").forward(request, response);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String url = request.getRequestURI();
            String[] urlKey = url.split("/RequestHandler/");
            Object mappedUrl = action.loopUrl(urlKey);
            Object data = action.checkError(mappedUrl, response);//checks for error and shows error msg. return type:- Object<List<Map>>
            if (data != null) {
                processGet(request, response, data);
            }
        } catch (IllegalArgumentException | ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
