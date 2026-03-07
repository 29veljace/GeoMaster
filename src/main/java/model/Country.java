package model;

public class Country {
    private String name;
    private String code;
    private String capital;
    private int population;
    private int area;
    // facts werde ich wrs string[] machen aber noch nicht sicher


    public Country(String name, String code, String capital, int population, int area) {
        this.name = name;
        this.code = code;
        this.capital = capital;
        this.population = population;
        this.area = area;
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
