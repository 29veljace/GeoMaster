package model;

import javafx.scene.image.Image;

public class Country {
    private final int id;
    private final String name;
    private final String code;
    private final String capital;
    private final int population;
    private final int area;
    private final double avgHeight;
    private final double bip;
    private final double highestPoint;
    private final double avgTemperature;
    private final Image flag;

    public int getId() {
        return id;
    }

    public double getAvgHeight() {
        return avgHeight;
    }

    public double getBip() {
        return bip;
    }

    public double getHighestPoint() {
        return highestPoint;
    }

    public double getAvgTemperature() {
        return avgTemperature;
    }

    public Image getFlag() {
        return flag;
    }

    public Country(int id, String name, String code, String capital, int population, int area, double avgHeight, double bip, double highestPoint, double avgTemperature, Image flag) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.avgHeight = avgHeight;
        this.bip = bip;
        this.highestPoint = highestPoint;
        this.avgTemperature = avgTemperature;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public int getArea() {
        return area;
    }

    public int getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public String getCode() {
        return code;
    }
}
