package system.database;

import java.sql.*;
import application.configuration.Config;

public class Connection {

    public java.sql.Connection conn;

    public String connect() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Config configVal = new Config();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(
                    "jdbc:mysql://" + configVal.hostname + "/" + configVal.database + "?user=" + configVal.username + "&password=" + configVal.password);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
