package application.configuration;

import system.service.Mapper;

public class Path extends Mapper {

    public void setRoutes() {
        map.put("welcome", "HomeController/loadData");// params: url-name, controllerClassName/methodName/args
        map.put("home", "HomeController/loadData");
        map.put("about", "AboutController/loadData");
    }

}
