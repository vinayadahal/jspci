package application.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import system.models.SelectModel;
import system.service.Helper;

public class SelectData extends SelectModel {

    public int dataPerPage = 5;

    public List<Map> getData(String col, String table, String[] whereId, String[] whereVal, String orderByCol, String order, String limit) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        select(col);
        from(table);
        if (whereId != null && whereVal != null) {
            where(whereId, whereVal);
        }
        if (orderByCol != null && order != null) {
            orderBy(orderByCol, order);
        }
        if (limit != null) {
            limit(limit);
        }
        List<Map> data = runQuery();
        return data;
    }

    public List<Map> getAbout() throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        select("*");
        from("content");
        String[] id = {"keyword"};
        String[] val = {"about"};
        where(id, val);
        List<Map> area = runQuery();
        return area;
    }

    public List<Map> getArea() throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        SelectModel objSelect = new SelectModel();
        objSelect.select("DISTINCT area");
        objSelect.from("trip");
        List<Map> area = objSelect.runQuery();
        return area;
    }

    public List<Map> getActivity() throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        SelectModel objSelect = new SelectModel();
        objSelect.select("DISTINCT category");
        objSelect.from("trip");
        List<Map> activity = objSelect.runQuery();
        return activity;
    }

    public List<Map> getDuration() throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        SelectModel objSelect = new SelectModel();
        objSelect.select("DISTINCT duration");
        objSelect.from("trip");
        List<Map> duration = objSelect.runQuery();
        return duration;
    }

    public List<Map> getDeparture() throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        SelectModel objSelect = new SelectModel();
        objSelect.select("DISTINCT departure");
        objSelect.from("trip");
        List<Map> departure = objSelect.runQuery();
        return departure;
    }

    public List<Map> getPopularTrips() throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        SelectModel objSelect = new SelectModel();
        objSelect.select("tripId");
        objSelect.from("visited");
        objSelect.orderBy("visited", "DESC");
        objSelect.limit("3");
        List<Map> popTripId = objSelect.runQuery();
        List<Map> popTrips = new ArrayList<>();
        for (Map popTripId1 : popTripId) {
            objSelect.select("*");
            objSelect.from("trip");
            String[] id = {"id"};
            String[] val = {popTripId1.get("tripId").toString()};
            objSelect.where(id, val);
            popTrips.add(objSelect.runQuery().get(0));
        }
        return popTrips;
    }

    public List<Map> getFeaturedTrips() throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        SelectModel objSelect = new SelectModel();
        objSelect.select("*");
        objSelect.from("trip");
        String[] id = {"featured"};
        String[] val = {"yes"};
        objSelect.where(id, val);
        objSelect.orderBy("added", "DESC");
        objSelect.limit("3");
        List<Map> featuredTrip = objSelect.runQuery();
        return featuredTrip;
    }

    public List<Map> getLatestTrips() throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        SelectModel objSelect = new SelectModel();
        objSelect.select("*");
        objSelect.from("trip");
        objSelect.orderBy("added", "DESC");
        objSelect.limit("3");
        List<Map> latestTrip = objSelect.runQuery();
        return latestTrip;
    }

    public int getPageNumber() throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        SelectModel objSelectModels = new SelectModel();
        int totalData = objSelectModels.countRows("trip");
        Helper objHelp = new Helper();
        return objHelp.getPagination(totalData, dataPerPage);
    }

    public List<Map> pageWiseData(String page) throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        SelectModel objSelect = new SelectModel();
        int dPP = 5;
        int start = (dPP * Integer.parseInt(page));
        objSelect.select("*");
        objSelect.from("trip");
        if (Integer.parseInt(page) > 1) {
            objSelect.limit(Integer.toString(start), Integer.toString(dPP));
        } else {
            objSelect.limit("0", Integer.toString(dPP));
            System.out.println("zero");
        }
        List<Map> latestTrip = objSelect.runQuery();
        return latestTrip;
    }

}
