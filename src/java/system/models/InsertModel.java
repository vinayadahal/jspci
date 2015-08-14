package system.models;

import system.database.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertModel {

    public String queryInsert;
    public List<String> columns = new ArrayList<>();
    public List<String> values = new ArrayList<>();

    public void insert(String table) {
        queryInsert = "INSERT INTO " + table;
    }

    public void values(String[] cols, String[] vals) {
        queryInsert += " (";
        if (cols.length == vals.length) {
            for (int i = 0; i < vals.length; i++) {
                if (vals.length > i + 1) {
                    queryInsert += "`" + cols[i] + "`" + ", ";
                    columns.add(cols[i]);
                    values.add(vals[i]);
                } else {
                    queryInsert += "`" + cols[i] + "`" + ")";
                    columns.add(cols[i]);
                    values.add(vals[i]);
                    break;
                }
            }
            queryInsert += "VALUES(";
            for (int i = 0; i < vals.length; i++) {
                if (vals.length > i + 1) {
                    queryInsert += "?,";
                } else {
                    queryInsert += "?);";
                    break;
                }
            }
        } else {
            System.out.println("Number of columns don't match with values.");
        }
    }

    public int runUpdate() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        System.out.println(queryInsert);
        Connection objConnect = new Connection();
        objConnect.connect();
        PreparedStatement prepStmt = objConnect.conn.prepareStatement(queryInsert);
        for (int i = 0; i < values.size(); i++) {
            prepStmt.setString(i + 1, values.get(i));
        }
        int rs = prepStmt.executeUpdate(); // executes query
        return rs;
    }
}
