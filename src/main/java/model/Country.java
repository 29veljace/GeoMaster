package model;

import javafx.scene.image.Image;

public class Country {
    private int id;
    private String name_EN;
    private String name_DE;
    private String code;
    private String capital;
    private long population;
    private long area;
    private double avgHeight;
    private long gdp;
    private double avgTemperature;
    private long gdpc;
    private Image flag;
    private Image outline;

    public Country(int id, String name_EN, String name_DE, String code, String capital, long population, long area, double avgHeight, long gdp, double avgTemperature, long gdpc, Image flag, Image outline) {
        this.id = id;
        this.name_EN = name_EN;
        this.name_DE = name_DE;
        this.code = code;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.avgHeight = avgHeight;
        this.gdp = gdp;
        this.avgTemperature = avgTemperature;
        this.gdpc = gdpc;
        this.flag = flag;
        this.outline = outline;
    }

    public int getId() {
        return id;
    }

    public double getAvgHeight() {
        return avgHeight;
    }

    public double getGdp() {
        return gdp;
    }

    public double getAvgTemperature() {
        return avgTemperature;
    }

    public String getName_EN() {
        return name_EN;
    }

    public String getName_DE() {return name_DE;}

    public long getArea() {
        return area;
    }

    public long getGdpc() {return gdpc;}

    public long getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public String getCode() {
        return code;
    }

    public Image getFlag() {
        return flag;
    }

    public Image getOutline() {
        return outline;
    }
}
