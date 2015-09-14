package application.controller;

import java.util.ArrayList;
import system.RequestHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminController extends RequestHandler {

    public List<Map> login() {
        Map map = new HashMap();
        map.put("title", "login");
        map.put("subtitle", "A Panel Login");
        map.put("viewName", "apanel/login");
        List<Map> data = new ArrayList<>();
        data.add(map);
        return data;
    }

    public void checkLogin() {

    }

}