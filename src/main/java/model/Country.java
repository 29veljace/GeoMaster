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
    private Image outline;

    public Country(int id, String name, String code, String capital, int population, int area, double avgHeight, double bip, double avgTemperature, Image flag, Image outline) {
        this.outline = outline;
        this.id = id;
        this.name = name;
        this.code = code;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.avgHeight = avgHeight;
        this.bip = bip;
        this.avgTemperature = avgTemperature;
        this.flag = flag;
    }

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

    public Image getOutline() {
        if (outline == null) {
            outline = new Image(
                    getClass().getResourceAsStream("/outlines/" + code + ".png"))
        }
        return outline;
    }
}
