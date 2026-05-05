package model;



import java.sql.*;
import java.util.Random;

public class FlagGameModel {
    // /database/migrations/002_add_orders.sql !!!

    public Connection connect() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=GeoMaster&password=hihi_haha_Weihnachtsstunde");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public ResultSet getData(){
        Statement statement;
        try {
            statement = connect().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Random random = new Random();
        random.nextInt(190);
        ResultSet resultSet;
        try {
             resultSet = statement.executeQuery("Select * from country where id = " + random);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
    public Country getCountry(){
        Country country;
        int id;
        String name, code, capital;
        int population, area;
        double avgHight, bip, highestPoint, avgTemperature;
        try {
           id = getData().getInt("id");
           name = getData().getString("name");
           code = getData().getString("code");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
