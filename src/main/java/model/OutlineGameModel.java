package model;


import app.Launcher;
import javafx.scene.image.Image;

import java.io.*;
import java.sql.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class OutlineGameModel {
    private Connection connection;
    private static final int COUNTRY_COUNT = 189;
    private final Random random = new Random();
    private final List<Integer> deck = new ArrayList<>();

    public void connect() {
        String userHome = System.getProperty("user.home");
        File dbFolder = new File(userHome + File.separator + ".geomaster");
        File dbFile = new File(dbFolder, "countrydata.db");
        if (!dbFolder.exists()) {
            dbFolder.mkdirs();
        }

        if (!dbFile.exists()) {
            try (InputStream is = Launcher.class.getResourceAsStream("/countrydata.db");
                 OutputStream os = new FileOutputStream(dbFile)) {

                if (is == null) {
                    throw new FileNotFoundException("Original countrydata.db file not found in src/main/resources!");
                }

                byte[] buffer = new byte[4096];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String url = "jdbc:sqlite:" + dbFile.getAbsolutePath();
        try {
            this.connection = DriverManager.getConnection(url);
            System.out.println(connection.getMetaData().getURL());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    public ResultSet getData() {
        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Random random = new Random();
        int i = random.nextInt(189);
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery("SELECT * FROM country WHERE id = " + i + ";");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
     */

    public Country getCountry(int countryId) {
        ResultSet resultSet = getData(countryId);
        Country country;
        int id, passportStrength, gdpc;
        String name_EN, code, capital_EN, capital_DE, name_DE;
        long population, area, gdp;
        double avgHeight, avgTemperature;
        Image image;
        Image outline;
        try {
            resultSet.next();
            id = resultSet.getInt("id");

            name_EN = resultSet.getString("name_EN");

            name_DE = resultSet.getString("name_DE");

            code = resultSet.getString("code");

            capital_EN = resultSet.getString("capital_EN");

            capital_DE = resultSet.getString("capital_DE");

            population = resultSet.getLong("population");

            area = resultSet.getLong("area");

            avgHeight = resultSet.getInt("avgHeight");

            gdp = resultSet.getLong("gdp");

            avgTemperature = resultSet.getInt("avgTemperature");

            passportStrength = resultSet.getInt("passportStrength");

            gdpc = resultSet.getInt("gdpc");

            String path1 = resultSet.getString("path1");
            image = new Image(getClass().getResourceAsStream("/" + path1));
            String path2 = resultSet.getString("path2");
            outline = new Image(getClass().getResourceAsStream("/" + path2));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        country = new Country(id, name_EN, name_DE, code, capital_EN, capital_DE, population, area, avgHeight, gdp, avgTemperature, gdpc, passportStrength, image, outline);
        return country;
    }

    private int nextQuestionId(){
        if (deck.isEmpty()) {
            for (int i = 0; i < COUNTRY_COUNT; i++){
                deck.add(i);
            }
            Collections.shuffle(deck, random);
        }
        return deck.remove(deck.size() - 1);
    }


    public ResultSet getData(int id){
        try{
            Statement statement = connection.createStatement();
            return statement.executeQuery("SELECT * FROM country where id = " + id + ";");
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Country getCountry(){
        return getCountry(random.nextInt(COUNTRY_COUNT));
    }

    public Country getNextQuestionCountry(){
        return getCountry(nextQuestionId());
    }

    public Connection getConnection() {
        return connection;
    }
}
