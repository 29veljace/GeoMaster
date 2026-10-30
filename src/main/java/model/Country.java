package model;

import javafx.scene.image.Image;

public class Country {
    private final int id;
    private final String name_EN;
    private final String name_DE;
    private final String code;
    private final String capital_EN;
    private final String capital_DE;
    private final long population;
    private final long area;
    private final double avgHeight;
    private final long gdp;
    private final double avgTemperature;
    private final int gdpc;
    private final int passportStrength;
    private final Image flag;
    private final Image outline;
    private final int populationDensity;

    public Country(int id, String name_EN, String name_DE, String code, String capital_EN,
                   String capital_DE, long population, long area, double avgHeight, long gdp,
                   double avgTemperature, int gdpc, int passportStrength, Image flag,
                   Image outline, int populationDensity) {
        this.id = id;
        this.name_EN = name_EN;
        this.name_DE = name_DE;
        this.code = code;
        this.capital_EN = capital_EN;
        this.capital_DE = capital_DE;
        this.population = population;
        this.area = area;
        this.avgHeight = avgHeight;
        this.gdp = gdp;
        this.avgTemperature = avgTemperature;
        this.gdpc = gdpc;
        this.passportStrength = passportStrength;
        this.flag = flag;
        this.outline = outline;
        this.populationDensity = populationDensity;
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

    public String getName_DE() {
        return name_DE;
    }

    public long getArea() {
        return area;
    }

    public long getGdpc() {
        return gdpc;
    }

    public long getPopulation() {
        return population;
    }

    public String getCapital_EN() {
        return capital_EN;
    }

    public String getCapital_DE() {
        return capital_DE;
    }

    public String getCode() {
        return code;
    }

    public int getPassportStrength() {
        return passportStrength;
    }

    public Image getFlag() {
        return flag;
    }

    public Image getOutline() {
        return outline;
    }

    public int getPopulationDensity() {
        return populationDensity;
    }
}
