package system.models;

import java.sql.PreparedStatement;
import system.database.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import system.service.Helper;

public class SelectModel {

    public String query;
    public List<String> value = new ArrayList<>();

    public void select(String col) {
        query = "SELECT " + col;
    }

    public void from(String table) {
        query += " FROM " + table;
    }

    public void where(String[] id, String[] val) {
        query += " WHERE ";
        if (id.length == val.length) {
            for (int i = 0; i < val.length; i++) {
                if (val.length > i + 1) {
                    query += "`" + id[i] + "`" + " = ? AND ";
                    value.add(val[i]);
                } else {
                    query += "`" + id[i] + "`" + " = ?";
                    value.add(val[i]);
                    break;
                }
            }
        } else {
            System.out.println("Number of element in args doesn't match in query.");
        }
    }

    public void limit(String limit) {
        query += " LIMIT " + limit;
    }

    public void limit(String start, String dataPerPage) {
        query += " LIMIT " + start + ", " + dataPerPage;
    }

    public void orderBy(String columnName, String order) {
        query += " ORDER BY `" + columnName + "` " + order;

    }

    public List<Map> runQuery() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection objConnect = new Connection();
        Helper objHelper = new Helper();
        objConnect.connect();
        PreparedStatement prepStmt = objConnect.conn.prepareStatement(query);
        for (int i = 0; i < value.size(); i++) {
            prepStmt.setString(i + 1, value.get(i));
        }
        value.clear();
        ResultSet rs = prepStmt.executeQuery(); // executes query
        ResultSetMetaData rsMeta = prepStmt.getMetaData(); // gets Metadata
        List<Map> Rows = objHelper.getMetaInfo(rsMeta, rs);
        return Rows;
    }

    public int countRows(String tableName) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection objConnect = new Connection();
        objConnect.connect();
        select("COUNT(*) AS total");
        from(tableName);
        Statement stmt = objConnect.conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            return (rs.getInt("total"));
        }
        return 0;
    }

}
