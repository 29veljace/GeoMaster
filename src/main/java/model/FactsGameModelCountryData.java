package model;

import app.Launcher;
import javafx.scene.image.Image;

import java.io.*;
import java.sql.*;
import java.util.Random;

public class FactsGameModelCountryData {
    private Connection connection;

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
                    throw new FileNotFoundException("Die originale countrydata.db wurde nicht in src/main/resources gefunden!");
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public ResultSet getData () {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Random random = new Random();
            int i = random.nextInt(192);
            ResultSet resultSet;
            try {
                resultSet = statement.executeQuery("Select * from country where id = " + i + ";");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return resultSet;
        }
        public Country getCountry () {
            ResultSet resultSet = getData();
            Country country;
            int id;
            String name, code, capital;
            long population, area, bip;
            double avgHeight, avgTemperature;
            Image image;
            Image outline;
            try {
                resultSet.next();
                id = resultSet.getInt("id");

                name = resultSet.getString("name");

                code = resultSet.getString("code");

                capital = resultSet.getString("capital");

                population = resultSet.getLong("population");

                area = resultSet.getLong("area");

                avgHeight = resultSet.getInt("avgHeight");

                bip = resultSet.getLong("bip");

                avgTemperature = resultSet.getInt("avgTemperature");
                String path1 = resultSet.getString("path1");
                image = new Image(getClass().getResourceAsStream("/" + path1));
                String path2 = resultSet.getString("path2");
                outline = new Image(getClass().getResourceAsStream("/" + path2));

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            country = new Country(id, name, code, capital, population, area, avgHeight, bip, avgTemperature, image, outline);
            return country;
        }

        public Connection getConnection () {
            return connection;
        }
    }
