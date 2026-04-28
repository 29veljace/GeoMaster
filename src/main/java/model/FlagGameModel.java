package model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FlagGameModel {
    // /database/migrations/002_add_orders.sql !!!
    public void connect() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=GeoMaster&password=hihi_haha_Weihnachtsstunde");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
