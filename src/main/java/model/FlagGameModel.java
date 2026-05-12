package model;



import javafx.scene.image.Image;

import java.sql.*;
import java.util.Random;

public class FlagGameModel {
    // /database/migrations/002_add_orders.sql !!!
    private Connection connection;

    public Connection connect() {

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
        random.nextInt(192);
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
        double avgHeight, bip, avgTemperature;
        Image image;
        Image outline;
        try {
           id = getData().getInt("id");
           name = getData().getString("name");
           code = getData().getString("code");
           capital = getData().getString("capital");
           population = getData().getInt("population");
           area = getData().getInt("area");
           avgHeight = getData().getInt("avgHeight");
           bip = getData().getInt("bip");
           avgTemperature = getData().getInt("avgTemperature");
           image = new Image(getData().getString("path1"));
           outline = new Image(getData().getString("path2"));
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        country = new Country(id,name,code,capital,population,area,avgHeight,bip,avgTemperature,image,outline);
        return country;
    }


}
