package application.model;

import java.sql.SQLException;
import system.models.CoreModels;

public class Insert {

    public void insertData(String table, String[] cols, String[] vals) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        CoreModels objModels = new CoreModels();
        objModels.insert(table);
        objModels.values(cols, vals);
        if (objModels.runUpdate() == 1) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }
    }

}
