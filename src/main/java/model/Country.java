package model;

public class Country {
    private final String name;
    private final String code;
    private final String capital;
    private final int population;
    private final int area;
    private final double avgHight;
    private final double bip;
    private final double highestPoint;
    private final double avgTemperature;

    public Country(String name, String code, String capital, int population, int area, double avgHight, double bip, double highestPoint, double avgTemperature) {
        this.name = name;
        this.code = code;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.avgHight = avgHight;
        this.bip = bip;
        this.highestPoint = highestPoint;
        this.avgTemperature = avgTemperature;
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
