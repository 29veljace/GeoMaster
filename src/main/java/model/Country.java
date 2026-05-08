package model;

import javafx.scene.image.Image;

public class Country {
    private int id;
    private String name;
    private String code;
    private String capital;
    private int population;
    private int area;
    private double avgHeight;
    private double bip;
    private double avgTemperature;
    private Image flag;

    public int getId() {
        return id;
    }

    public double getAvgHeight() {
        return avgHeight;
    }

    public double getBip() {
        return bip;
    }

    public double getAvgTemperature() {
        return avgTemperature;
    }

    public Image getFlag() {
        if (flag == null) {
            flag = new Image(
                    getClass().getResourceAsStream("/flags/" + code + ".png")
            );
        }
        return flag;
    }

    public Country(int id, String name, String code, String capital, int population, int area, double avgHeight, double bip, double avgTemperature, Image flag) {
        setId(id);
        setName(name);
        setCode(code);
        setCapital(capital);
        setPopulation(population);
        setArea(area);
        setAvgHeight(avgHeight);
        setBip(bip);
        setAvgTemperature(avgTemperature);
        setFlag(flag);
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

    public void setFlag(Image flag) {
        this.flag = flag;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setAvgHeight(double avgHeight) {
        this.avgHeight = avgHeight;
    }

    public void setBip(double bip) {
        this.bip = bip;
    }

    public void setAvgTemperature(double avgTemperature) {
        this.avgTemperature = avgTemperature;
    }
}
