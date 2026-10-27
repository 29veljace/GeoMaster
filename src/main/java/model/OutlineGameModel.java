package model;

import javafx.scene.image.Image;
import util.DatabaseManager;

import java.io.*;
import java.sql.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class OutlineGameModel {
    private static final int COUNTRY_COUNT = 189;
    private final Random random = new Random();
    private final List<Integer> deck = new ArrayList<>();


    public Country getCountry(int countryId) {
        String sql = "SELECT * FROM country WHERE id = ?";
        try (PreparedStatement ps = DatabaseManager.getConnection().prepareStatement(sql)) {
            ps.setInt(1, countryId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    throw new IllegalStateException("Country not found: id=" + countryId);
                }
                int id = rs.getInt("id");
                return new Country(
                        id,
                        rs.getString("name_EN"),
                        rs.getString("name_DE"),
                        rs.getString("code"),
                        rs.getString("capital_EN"),
                        rs.getString("capital_DE"),
                        rs.getLong("population"),
                        rs.getLong("area"),
                        rs.getInt("avgHeight"),
                        rs.getLong("gdp"),
                        rs.getInt("avgTemperature"),
                        rs.getInt("gdpc"),
                        rs.getInt("passportStrength"),
                        loadImage(rs.getString("path1"), id),
                        loadImage(rs.getString("path2"), id)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Image loadImage(String path, int id) {
        InputStream is = (path == null) ? null : getClass().getResourceAsStream("/" + path);
        if (is == null) {
            throw new IllegalStateException("Image missing: id=" + id + ", path=" + path);
        }
        return new Image(is);
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


    public Country getCountry(){
        return getCountry(random.nextInt(COUNTRY_COUNT));
    }

    public Country getNextQuestionCountry(){
        return getCountry(nextQuestionId());
    }
}
