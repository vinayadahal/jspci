package application.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import system.RequestHandler;
import application.model.SelectData;

public class HomeController extends RequestHandler {

    public List<Map> loadData() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        SelectData objSelect = new SelectData();
        Map map = new HashMap();
        map.put("title", "home");
        map.put("category", objSelect.getData("*", "category", null, null, null, null, null));
        map.put("popTrip", objSelect.getPopularTrips());
        map.put("featuredTrip", objSelect.getFeaturedTrips());
        map.put("slider", objSelect.getData("*", "slider", null, null, null, null, null));
        map.put("area", objSelect.getArea());
        map.put("activity", objSelect.getActivity());
        map.put("duration", objSelect.getDuration());
        map.put("departure", objSelect.getDeparture());
        map.put("allTrip", objSelect.getData("*", "trip", null, null, null, null, "5"));
        map.put("latestTrip", objSelect.getLatestTrips());
        map.put("viewName", "home");
        List<Map> data = new ArrayList<>();
        data.add(map);
        return data;
    }

}
