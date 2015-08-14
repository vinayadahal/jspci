package application.controller;

import application.model.SelectData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import system.RequestHandler;

public class AboutController extends RequestHandler {

    public List<Map> loadData() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        SelectData objSelect = new SelectData();
        Map map = new HashMap();
        map.put("title", "about");
        map.put("category", objSelect.getData("*", "category", null, null, null, null, null));
        map.put("popTrip", objSelect.getPopularTrips());
        map.put("featuredTrip", objSelect.getFeaturedTrips());
        map.put("about", objSelect.getAbout());
        map.put("area", objSelect.getArea());
        map.put("activity", objSelect.getActivity());
        map.put("duration", objSelect.getDuration());
        map.put("departure", objSelect.getDeparture());
        map.put("allTrip", objSelect.getData("*", "trip", null, null, null, null, "5"));
        map.put("latestTrip", objSelect.getLatestTrips());
        map.put("viewName", "about");
        List<Map> data = new ArrayList<>();
        System.out.println(objSelect.getAbout());
        data.add(map);
        return data;
    }

}
