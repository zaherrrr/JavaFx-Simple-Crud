package Utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataSource {
    private Connection cnx;
    private DataSource(){
        try {
            String USERNAME = "root";
            String db_name = "CRUDDEMO";
            String url = "jdbc:mysql://localhost:3306/" + db_name + "?characterEncoding=latin1&useConfigs=maxPerformance";
            String MY_PASS = "not today";
            cnx = DriverManager.getConnection(url, USERNAME, MY_PASS);
            System.out.println("JDBC CONNECTED TO "+db_name.toUpperCase());
        }catch (Exception ex ) {
            System.out.println("JDBC CONNECTION FAILED INVALID Check DataSource.java class Settings.");
//            System.out.println(ex.getMessage());
        }
    }
    public static DataSource getInstance() {
        return new DataSource();
    }

    public Connection getCnx() {
        return cnx;
    }

}
