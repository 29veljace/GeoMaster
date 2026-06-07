package model;


import javafx.scene.image.ImageView;
import view.FactsGameView;

import java.sql.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FactsGameModel {

    FactsGameView view = new FactsGameView();
    FactsGameModelCountryData factsGameModelCountryData = new FactsGameModelCountryData();
    Country c1;
    Country c2;
    Country c3;
    Country c4;
    public void setCountries(){
        factsGameModelCountryData.connect();
        c1 = factsGameModelCountryData.getCountry();
        do{
            c2 = factsGameModelCountryData.getCountry();
        }while(c1.getId() == c2.getId());
        do{
            c3 = factsGameModelCountryData.getCountry();
        }while(c1.getId() == c3.getId() || c2.getId() == c3.getId());
        do{
            c4 = factsGameModelCountryData.getCountry();
        }while(c1.getId() == c4.getId() || c2.getId() == c4.getId() || c3.getId() == c4.getId());
    }


    private final Set<Object> richtigeAntwortenfürC1 = new HashSet<>();
    private final Set<Object> richtigeAntwortenfürC2 = new HashSet<>();
    private final Set<Object> richtigeAntwortenfürC3 = new HashSet<>();
    private final Set<Object> richtigeAntwortenfürC4 = new HashSet<>();
    private final Set<Object> ausgewählt = new HashSet<>();

    public FactsGameModel(){
        setRichtigeAntworten();
    }

    public void setRichtigeAntworten(){
        setCountries();
        final int n = 4;
        Random random = new Random();

        boolean name = false, code = false, capital = false, population = false,
                area = false, avgHeight = false, bip = false, avgTemperature = false,
                flag = false, outline = false;

        for (int i = 0; i < n; i++){
           // int a = random.nextInt(10);
           // int b = random.nextInt(16);
                int a = 0;
                int b = 0;
            switch (b){
                case 0:
                    boolean text = true;
                    if(view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null) {
                        switch (a) {
                            case 0:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !name) {
                                    view.getBtn1().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !code) {
                                    view.getBtn1().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !capital) {
                                    view.getBtn1().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !population) {
                                    view.getBtn1().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !area) {
                                    view.getBtn1().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !avgHeight) {
                                    view.getBtn1().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !bip) {
                                    view.getBtn1().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !avgTemperature) {
                                    view.getBtn1().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !flag) {
                                    view.getBtn1().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !outline) {
                                    view.getBtn1().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn1().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn1().getGraphic());
                        }
                        break;
                    }
                case 1:
                    if(view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !name) {
                                    view.getBtn1().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !code) {
                                    view.getBtn2().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !capital) {
                                    view.getBtn2().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !population) {
                                    view.getBtn2().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !area) {
                                    view.getBtn2().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !avgHeight) {
                                    view.getBtn2().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !bip) {
                                    view.getBtn2().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !avgTemperature) {
                                    view.getBtn2().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !flag) {
                                    view.getBtn2().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !outline) {
                                    view.getBtn2().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn2().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn2().getGraphic());
                        }
                        break;
                    }
                case 2:
                    if(view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !name) {
                                    view.getBtn3().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !code) {
                                    view.getBtn3().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !capital) {
                                    view.getBtn3().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !population) {
                                    view.getBtn3().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !area) {
                                    view.getBtn3().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !avgHeight) {
                                    view.getBtn3().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !bip) {
                                    view.getBtn3().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !avgTemperature) {
                                    view.getBtn3().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && flag) {
                                    view.getBtn3().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && outline) {
                                    view.getBtn3().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = false;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn3().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn3().getGraphic());
                        }
                        break;
                    }
                case 3:
                    if(view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !name) {
                                    view.getBtn4().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !code) {
                                    view.getBtn4().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !capital) {
                                    view.getBtn4().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !population) {
                                    view.getBtn4().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !area) {
                                    view.getBtn4().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !avgHeight) {
                                    view.getBtn4().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !bip) {
                                    view.getBtn4().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !avgTemperature) {
                                    view.getBtn4().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !flag) {
                                    view.getBtn4().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !outline) {
                                    view.getBtn4().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn4().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn4().getGraphic());
                        }
                        break;
                    }
                case 4:
                    if(view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !name) {
                                    view.getBtn5().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !code) {
                                    view.getBtn5().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !capital) {
                                    view.getBtn5().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !population) {
                                    view.getBtn5().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !area) {
                                    view.getBtn5().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !avgHeight) {
                                    view.getBtn5().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !bip) {
                                    view.getBtn5().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !avgTemperature) {
                                    view.getBtn5().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !flag) {
                                    view.getBtn5().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !outline) {
                                    view.getBtn5().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn5().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn5().getGraphic());
                        }
                        break;
                    }
                case 5:
                    if(view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !name) {
                                    view.getBtn6().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !code) {
                                    view.getBtn6().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !capital) {
                                    view.getBtn6().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !population) {
                                    view.getBtn6().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !area) {
                                    view.getBtn6().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !avgHeight) {
                                    view.getBtn6().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !bip) {
                                    view.getBtn6().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !avgTemperature) {
                                    view.getBtn6().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !flag) {
                                    view.getBtn6().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !outline) {
                                    view.getBtn6().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn6().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn6().getGraphic());
                        }
                        break;
                    }
                case 6:
                    if(view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !name) {
                                    view.getBtn7().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !code) {
                                    view.getBtn7().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !capital) {
                                    view.getBtn7().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !population) {
                                    view.getBtn7().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !area) {
                                    view.getBtn7().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !avgHeight) {
                                    view.getBtn7().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !bip) {
                                    view.getBtn7().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !avgTemperature) {
                                    view.getBtn7().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !flag) {
                                    view.getBtn7().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !outline) {
                                    view.getBtn7().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn7().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn7().getGraphic());
                        }
                        break;
                    }
                case 7:
                    if(view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !name) {
                                    view.getBtn8().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !code) {
                                    view.getBtn8().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !capital) {
                                    view.getBtn8().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !population) {
                                    view.getBtn8().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !area) {
                                    view.getBtn8().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !avgHeight) {
                                    view.getBtn8().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !bip) {
                                    view.getBtn8().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !avgTemperature) {
                                    view.getBtn8().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !flag) {
                                    view.getBtn8().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !outline) {
                                    view.getBtn8().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn8().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn8().getGraphic());
                        }
                        break;
                    }
                case 8:
                    if(view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !name) {
                                    view.getBtn9().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !code) {
                                    view.getBtn9().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !capital) {
                                    view.getBtn9().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !population) {
                                    view.getBtn9().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !area) {
                                    view.getBtn9().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !avgHeight) {
                                    view.getBtn9().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !bip) {
                                    view.getBtn9().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !avgTemperature) {
                                    view.getBtn9().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !flag) {
                                    view.getBtn9().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !outline) {
                                    view.getBtn9().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn9().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn9().getGraphic());
                        }
                        break;
                    }
                case 9:
                    if(view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !name) {
                                    view.getBtn10().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !code) {
                                    view.getBtn10().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !capital) {
                                    view.getBtn10().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !population) {
                                    view.getBtn10().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !area) {
                                    view.getBtn10().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !avgHeight) {
                                    view.getBtn10().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !bip) {
                                    view.getBtn10().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !avgTemperature) {
                                    view.getBtn10().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !flag) {
                                    view.getBtn10().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !outline) {
                                    view.getBtn10().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn10().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn10().getGraphic());
                        }
                        break;
                    }
                case 10:
                    if(view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !name) {
                                    view.getBtn11().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !code) {
                                    view.getBtn11().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !capital) {
                                    view.getBtn11().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !population) {
                                    view.getBtn11().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !area) {
                                    view.getBtn11().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !avgHeight) {
                                    view.getBtn11().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !bip) {
                                    view.getBtn11().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !avgTemperature) {
                                    view.getBtn11().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !flag) {
                                    view.getBtn11().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !outline) {
                                    view.getBtn11().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn11().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn11().getGraphic());
                        }
                        break;
                    }
                case 11:
                    if(view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !name) {
                                    view.getBtn12().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !code) {
                                    view.getBtn12().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !capital) {
                                    view.getBtn12().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !population) {
                                    view.getBtn12().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !area) {
                                    view.getBtn12().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !avgHeight) {
                                    view.getBtn12().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !bip) {
                                    view.getBtn12().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !avgTemperature) {
                                    view.getBtn12().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !flag) {
                                    view.getBtn12().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !outline) {
                                    view.getBtn12().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn12().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn12().getGraphic());
                        }
                        break;
                    }
                case 12:
                    if(view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !name) {
                                    view.getBtn13().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !code) {
                                    view.getBtn13().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !capital) {
                                    view.getBtn13().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !population) {
                                    view.getBtn13().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !area) {
                                    view.getBtn13().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !avgHeight) {
                                    view.getBtn13().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !bip) {
                                    view.getBtn13().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !avgTemperature) {
                                    view.getBtn13().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !flag) {
                                    view.getBtn13().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !outline) {
                                    view.getBtn13().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn13().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn13().getGraphic());
                        }
                        break;
                    }
                case 13:
                    if(view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !name) {
                                    view.getBtn14().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !code) {
                                    view.getBtn14().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !capital) {
                                    view.getBtn14().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !population) {
                                    view.getBtn14().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !area) {
                                    view.getBtn14().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !avgHeight) {
                                    view.getBtn14().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !bip) {
                                    view.getBtn14().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !avgTemperature) {
                                    view.getBtn14().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !flag) {
                                    view.getBtn14().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !outline) {
                                    view.getBtn14().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn14().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn14().getGraphic());
                        }
                        break;
                    }
                case 14:
                    if(view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !name) {
                                    view.getBtn15().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !code) {
                                    view.getBtn15().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !capital) {
                                    view.getBtn15().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !population) {
                                    view.getBtn15().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !area) {
                                    view.getBtn15().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !avgHeight) {
                                    view.getBtn15().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !bip) {
                                    view.getBtn15().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !avgTemperature) {
                                    view.getBtn15().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !flag) {
                                    view.getBtn15().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !outline) {
                                    view.getBtn15().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn15().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn15().getGraphic());
                        }
                        break;
                    }
                case 15:
                    if(view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !name) {
                                    view.getBtn16().setText(c1.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !code) {
                                    view.getBtn16().setText(c1.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !capital) {
                                    view.getBtn16().setText(c1.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !population) {
                                    view.getBtn16().setText(String.valueOf(c1.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !area) {
                                    view.getBtn16().setText(String.valueOf(c1.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !avgHeight) {
                                    view.getBtn16().setText(String.valueOf(c1.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !bip) {
                                    view.getBtn16().setText(String.valueOf(c1.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !avgTemperature) {
                                    view.getBtn16().setText(String.valueOf(c1.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !flag) {
                                    view.getBtn16().setGraphic(new ImageView(c1.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !outline) {
                                    view.getBtn16().setGraphic(new ImageView(c1.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC1.add(view.getBtn16().getText());
                        } else {
                            richtigeAntwortenfürC1.add(view.getBtn16().getGraphic());
                        }
                        break;
                    }
            }
        }
        name = false; code = false; capital = false; population = false;
                area = false; avgHeight = false; bip = false; avgTemperature = false;
                flag = false; outline = false;
        for (int i = 0; i < n; i++){
            int a = random.nextInt(10);
            int b = random.nextInt(16);

            switch (b){
                case 0:
                    boolean text = true;
                    if(view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null) {
                        switch (a) {
                            case 0:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !name) {
                                    view.getBtn1().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !code) {
                                    view.getBtn1().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !capital) {
                                    view.getBtn1().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !population) {
                                    view.getBtn1().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !area) {
                                    view.getBtn1().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !avgHeight) {
                                    view.getBtn1().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !bip) {
                                    view.getBtn1().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !avgTemperature) {
                                    view.getBtn1().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !flag) {
                                    view.getBtn1().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn1().getText().isBlank() && view.getBtn1().getGraphic() == null && !outline) {
                                    view.getBtn1().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn1().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn1().getGraphic());
                        }
                        break;
                    }
                case 1:
                    if(view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !name) {
                                    view.getBtn1().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !code) {
                                    view.getBtn2().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !capital) {
                                    view.getBtn2().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !population) {
                                    view.getBtn2().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !area) {
                                    view.getBtn2().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !avgHeight) {
                                    view.getBtn2().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !bip) {
                                    view.getBtn2().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !avgTemperature) {
                                    view.getBtn2().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !flag) {
                                    view.getBtn2().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn2().getText().isBlank() && view.getBtn2().getGraphic() == null && !outline) {
                                    view.getBtn2().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn2().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn2().getGraphic());
                        }
                        break;
                    }
                case 2:
                    if(view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !name) {
                                    view.getBtn3().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !code) {
                                    view.getBtn3().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !capital) {
                                    view.getBtn3().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !population) {
                                    view.getBtn3().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !area) {
                                    view.getBtn3().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !avgHeight) {
                                    view.getBtn3().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !bip) {
                                    view.getBtn3().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && !avgTemperature) {
                                    view.getBtn3().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && flag) {
                                    view.getBtn3().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn3().getText().isBlank() && view.getBtn3().getGraphic() == null && outline) {
                                    view.getBtn3().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = false;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn3().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn3().getGraphic());
                        }
                        break;
                    }
                case 3:
                    if(view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !name) {
                                    view.getBtn4().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !code) {
                                    view.getBtn4().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !capital) {
                                    view.getBtn4().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !population) {
                                    view.getBtn4().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !area) {
                                    view.getBtn4().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !avgHeight) {
                                    view.getBtn4().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !bip) {
                                    view.getBtn4().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !avgTemperature) {
                                    view.getBtn4().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !flag) {
                                    view.getBtn4().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn4().getText().isBlank() && view.getBtn4().getGraphic() == null && !outline) {
                                    view.getBtn4().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn4().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn4().getGraphic());
                        }
                        break;
                    }
                case 4:
                    if(view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !name) {
                                    view.getBtn5().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !code) {
                                    view.getBtn5().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !capital) {
                                    view.getBtn5().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !population) {
                                    view.getBtn5().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !area) {
                                    view.getBtn5().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !avgHeight) {
                                    view.getBtn5().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !bip) {
                                    view.getBtn5().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !avgTemperature) {
                                    view.getBtn5().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !flag) {
                                    view.getBtn5().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn5().getText().isBlank() && view.getBtn5().getGraphic() == null && !outline) {
                                    view.getBtn5().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn5().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn5().getGraphic());
                        }
                        break;
                    }
                case 5:
                    if(view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !name) {
                                    view.getBtn6().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !code) {
                                    view.getBtn6().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !capital) {
                                    view.getBtn6().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !population) {
                                    view.getBtn6().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !area) {
                                    view.getBtn6().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !avgHeight) {
                                    view.getBtn6().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !bip) {
                                    view.getBtn6().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !avgTemperature) {
                                    view.getBtn6().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !flag) {
                                    view.getBtn6().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn6().getText().isBlank() && view.getBtn6().getGraphic() == null && !outline) {
                                    view.getBtn6().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn6().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn6().getGraphic());
                        }
                        break;
                    }
                case 6:
                    if(view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !name) {
                                    view.getBtn7().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !code) {
                                    view.getBtn7().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !capital) {
                                    view.getBtn7().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !population) {
                                    view.getBtn7().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !area) {
                                    view.getBtn7().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !avgHeight) {
                                    view.getBtn7().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !bip) {
                                    view.getBtn7().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !avgTemperature) {
                                    view.getBtn7().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !flag) {
                                    view.getBtn7().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn7().getText().isBlank() && view.getBtn7().getGraphic() == null && !outline) {
                                    view.getBtn7().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn7().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn7().getGraphic());
                        }
                        break;
                    }
                case 7:
                    if(view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !name) {
                                    view.getBtn8().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !code) {
                                    view.getBtn8().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !capital) {
                                    view.getBtn8().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !population) {
                                    view.getBtn8().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !area) {
                                    view.getBtn8().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !avgHeight) {
                                    view.getBtn8().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !bip) {
                                    view.getBtn8().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !avgTemperature) {
                                    view.getBtn8().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !flag) {
                                    view.getBtn8().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn8().getText().isBlank() && view.getBtn8().getGraphic() == null && !outline) {
                                    view.getBtn8().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn8().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn8().getGraphic());
                        }
                        break;
                    }
                case 8:
                    if(view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !name) {
                                    view.getBtn9().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !code) {
                                    view.getBtn9().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !capital) {
                                    view.getBtn9().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !population) {
                                    view.getBtn9().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !area) {
                                    view.getBtn9().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !avgHeight) {
                                    view.getBtn9().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !bip) {
                                    view.getBtn9().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn9().getText().isBlank()  && view.getBtn9().getGraphic() == null && !avgTemperature){
                                view.getBtn9().setText(String.valueOf(c2.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                            case 8:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !flag) {
                                    view.getBtn9().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn9().getText().isBlank() && view.getBtn9().getGraphic() == null && !outline) {
                                    view.getBtn9().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn9().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn9().getGraphic());
                        }
                        break;
                    }
                case 9:
                    if(view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !name) {
                                    view.getBtn10().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !code) {
                                    view.getBtn10().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !capital) {
                                    view.getBtn10().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !population) {
                                    view.getBtn10().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !area) {
                                    view.getBtn10().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !avgHeight) {
                                    view.getBtn10().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !bip) {
                                    view.getBtn10().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !avgTemperature) {
                                    view.getBtn10().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !flag) {
                                    view.getBtn10().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn10().getText().isBlank() && view.getBtn10().getGraphic() == null && !outline) {
                                    view.getBtn10().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn10().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn10().getGraphic());
                        }
                        break;
                    }
                case 10:
                    if(view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !name) {
                                    view.getBtn11().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !code) {
                                    view.getBtn11().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !capital) {
                                    view.getBtn11().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !population) {
                                    view.getBtn11().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !area) {
                                    view.getBtn11().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !avgHeight) {
                                    view.getBtn11().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !bip) {
                                    view.getBtn11().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !avgTemperature) {
                                    view.getBtn11().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !flag) {
                                    view.getBtn11().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn11().getText().isBlank() && view.getBtn11().getGraphic() == null && !outline) {
                                    view.getBtn11().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn11().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn11().getGraphic());
                        }
                        break;
                    }
                case 11:
                    if(view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !name) {
                                    view.getBtn12().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !code) {
                                    view.getBtn12().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !capital) {
                                    view.getBtn12().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !population) {
                                    view.getBtn12().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !area) {
                                    view.getBtn12().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !avgHeight) {
                                    view.getBtn12().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !bip) {
                                    view.getBtn12().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !avgTemperature) {
                                    view.getBtn12().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !flag) {
                                    view.getBtn12().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn12().getText().isBlank() && view.getBtn12().getGraphic() == null && !outline) {
                                    view.getBtn12().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn12().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn12().getGraphic());
                        }
                        break;
                    }
                case 12:
                    if(view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !name) {
                                    view.getBtn13().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !code) {
                                    view.getBtn13().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !capital) {
                                    view.getBtn13().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !population) {
                                    view.getBtn13().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !area) {
                                    view.getBtn13().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !avgHeight) {
                                    view.getBtn13().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !bip) {
                                    view.getBtn13().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !avgTemperature) {
                                    view.getBtn13().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !flag) {
                                    view.getBtn13().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn13().getText().isBlank() && view.getBtn13().getGraphic() == null && !outline) {
                                    view.getBtn13().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn13().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn13().getGraphic());
                        }
                        break;
                    }
                case 13:
                    if(view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !name) {
                                    view.getBtn14().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !code) {
                                    view.getBtn14().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !capital) {
                                    view.getBtn14().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !population) {
                                    view.getBtn14().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !area) {
                                    view.getBtn14().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !avgHeight) {
                                    view.getBtn14().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !bip) {
                                    view.getBtn14().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !avgTemperature) {
                                    view.getBtn14().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !flag) {
                                    view.getBtn14().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn14().getText().isBlank() && view.getBtn14().getGraphic() == null && !outline) {
                                    view.getBtn14().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn14().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn14().getGraphic());
                        }
                        break;
                    }
                case 14:
                    if(view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !name) {
                                    view.getBtn15().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !code) {
                                    view.getBtn15().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !capital) {
                                    view.getBtn15().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !population) {
                                    view.getBtn15().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !area) {
                                    view.getBtn15().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !avgHeight) {
                                    view.getBtn15().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !bip) {
                                    view.getBtn15().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !avgTemperature) {
                                    view.getBtn15().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !flag) {
                                    view.getBtn15().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn15().getText().isBlank() && view.getBtn15().getGraphic() == null && !outline) {
                                    view.getBtn15().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn15().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn15().getGraphic());
                        }
                        break;
                    }
                case 15:
                    if(view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !name) {
                                    view.getBtn16().setText(c2.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !code) {
                                    view.getBtn16().setText(c2.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !capital) {
                                    view.getBtn16().setText(c2.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !population) {
                                    view.getBtn16().setText(String.valueOf(c2.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !area) {
                                    view.getBtn16().setText(String.valueOf(c2.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !avgHeight) {
                                    view.getBtn16().setText(String.valueOf(c2.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !bip) {
                                    view.getBtn16().setText(String.valueOf(c2.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !avgTemperature) {
                                    view.getBtn16().setText(String.valueOf(c2.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !flag) {
                                    view.getBtn16().setGraphic(new ImageView(c2.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn16().getText().isBlank() && view.getBtn16().getGraphic() == null && !outline) {
                                    view.getBtn16().setGraphic(new ImageView(c2.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC2.add(view.getBtn16().getText());
                        } else {
                            richtigeAntwortenfürC2.add(view.getBtn16().getGraphic());
                        }
                        break;
                    }
            }
        }
        name = false; code = false; capital = false; population = false;
        area = false; avgHeight = false; bip = false; avgTemperature = false;
        flag = false; outline = false;
        for (int i = 0; i < n; i++){
            int a = random.nextInt(10);
            int b = random.nextInt(16);

            switch (b){
                case 0:
                    boolean text = true;
                    if(view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null) {
                        switch (a) {
                            case 0:
                                if (view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !name) {
                                    view.getBtn1().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !code) {
                                    view.getBtn1().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !capital) {
                                    view.getBtn1().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !population) {
                                    view.getBtn1().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !area) {
                                    view.getBtn1().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !avgHeight) {
                                    view.getBtn1().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !bip) {
                                    view.getBtn1().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !avgTemperature) {
                                    view.getBtn1().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !flag) {
                                    view.getBtn1().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !outline) {
                                    view.getBtn1().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn1().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn1().getGraphic());
                        }
                        break;
                    }
                case 1:
                    if(view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !name) {
                                    view.getBtn1().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !code) {
                                    view.getBtn2().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !capital) {
                                    view.getBtn2().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !population) {
                                    view.getBtn2().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !area) {
                                    view.getBtn2().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !avgHeight) {
                                    view.getBtn2().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !bip) {
                                    view.getBtn2().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !avgTemperature) {
                                    view.getBtn2().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !flag) {
                                    view.getBtn2().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !outline) {
                                    view.getBtn2().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn2().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn2().getGraphic());
                        }
                        break;
                    }
                case 2:
                    if(view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !name) {
                                    view.getBtn3().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !code) {
                                    view.getBtn3().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !capital) {
                                    view.getBtn3().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !population) {
                                    view.getBtn3().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !area) {
                                    view.getBtn3().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !avgHeight) {
                                    view.getBtn3().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !bip) {
                                    view.getBtn3().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !avgTemperature) {
                                    view.getBtn3().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && flag) {
                                    view.getBtn3().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && outline) {
                                    view.getBtn3().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = false;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn3().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn3().getGraphic());
                        }
                        break;
                    }
                case 3:
                    if(view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !name) {
                                    view.getBtn4().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !code) {
                                    view.getBtn4().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !capital) {
                                    view.getBtn4().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !population) {
                                    view.getBtn4().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !area) {
                                    view.getBtn4().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !avgHeight) {
                                    view.getBtn4().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !bip) {
                                    view.getBtn4().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !avgTemperature) {
                                    view.getBtn4().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !flag) {
                                    view.getBtn4().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !outline) {
                                    view.getBtn4().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn4().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn4().getGraphic());
                        }
                        break;
                    }
                case 4:
                    if(view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !name) {
                                    view.getBtn5().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !code) {
                                    view.getBtn5().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !capital) {
                                    view.getBtn5().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !population) {
                                    view.getBtn5().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !area) {
                                    view.getBtn5().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !avgHeight) {
                                    view.getBtn5().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !bip) {
                                    view.getBtn5().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !avgTemperature) {
                                    view.getBtn5().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !flag) {
                                    view.getBtn5().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !outline) {
                                    view.getBtn5().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn5().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn5().getGraphic());
                        }
                        break;
                    }
                case 5:
                    if(view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !name) {
                                    view.getBtn6().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !code) {
                                    view.getBtn6().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !capital) {
                                    view.getBtn6().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !population) {
                                    view.getBtn6().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !area) {
                                    view.getBtn6().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !avgHeight) {
                                    view.getBtn6().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !bip) {
                                    view.getBtn6().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !avgTemperature) {
                                    view.getBtn6().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !flag) {
                                    view.getBtn6().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !outline) {
                                    view.getBtn6().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn6().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn6().getGraphic());
                        }
                        break;
                    }
                case 6:
                    if(view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !name) {
                                    view.getBtn7().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !code) {
                                    view.getBtn7().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !capital) {
                                    view.getBtn7().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !population) {
                                    view.getBtn7().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !area) {
                                    view.getBtn7().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !avgHeight) {
                                    view.getBtn7().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !bip) {
                                    view.getBtn7().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !avgTemperature) {
                                    view.getBtn7().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !flag) {
                                    view.getBtn7().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !outline) {
                                    view.getBtn7().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn7().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn7().getGraphic());
                        }
                        break;
                    }
                case 7:
                    if(view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !name) {
                                    view.getBtn8().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !code) {
                                    view.getBtn8().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !capital) {
                                    view.getBtn8().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !population) {
                                    view.getBtn8().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !area) {
                                    view.getBtn8().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !avgHeight) {
                                    view.getBtn8().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !bip) {
                                    view.getBtn8().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !avgTemperature) {
                                    view.getBtn8().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !flag) {
                                    view.getBtn8().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !outline) {
                                    view.getBtn8().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn8().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn8().getGraphic());
                        }
                        break;
                    }
                case 8:
                    if(view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !name) {
                                    view.getBtn9().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !code) {
                                    view.getBtn9().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !capital) {
                                    view.getBtn9().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !population) {
                                    view.getBtn9().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !area) {
                                    view.getBtn9().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !avgHeight) {
                                    view.getBtn9().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !bip) {
                                    view.getBtn9().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !avgTemperature) {
                                    view.getBtn9().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !flag) {
                                    view.getBtn9().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !outline) {
                                    view.getBtn9().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn9().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn9().getGraphic());
                        }
                        break;
                    }
                case 9:
                    if(view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !name) {
                                    view.getBtn10().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !code) {
                                    view.getBtn10().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !capital) {
                                    view.getBtn10().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !population) {
                                    view.getBtn10().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !area) {
                                    view.getBtn10().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !avgHeight) {
                                    view.getBtn10().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !bip) {
                                    view.getBtn10().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !avgTemperature) {
                                    view.getBtn10().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !flag) {
                                    view.getBtn10().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !outline) {
                                    view.getBtn10().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn10().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn10().getGraphic());
                        }
                        break;
                    }
                case 10:
                    if(view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !name) {
                                    view.getBtn11().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !code) {
                                    view.getBtn11().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !capital) {
                                    view.getBtn11().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !population) {
                                    view.getBtn11().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !area) {
                                    view.getBtn11().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !avgHeight) {
                                    view.getBtn11().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !bip) {
                                    view.getBtn11().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !avgTemperature) {
                                    view.getBtn11().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !flag) {
                                    view.getBtn11().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !outline) {
                                    view.getBtn11().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn11().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn11().getGraphic());
                        }
                        break;
                    }
                case 11:
                    if(view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !name) {
                                    view.getBtn12().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !code) {
                                    view.getBtn12().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !capital) {
                                    view.getBtn12().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !population) {
                                    view.getBtn12().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !area) {
                                    view.getBtn12().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !avgHeight) {
                                    view.getBtn12().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !bip) {
                                    view.getBtn12().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !avgTemperature) {
                                    view.getBtn12().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !flag) {
                                    view.getBtn12().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !outline) {
                                    view.getBtn12().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn12().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn12().getGraphic());
                        }
                        break;
                    }
                case 12:
                    if(view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !name) {
                                    view.getBtn13().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !code) {
                                    view.getBtn13().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !capital) {
                                    view.getBtn13().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !population) {
                                    view.getBtn13().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !area) {
                                    view.getBtn13().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !avgHeight) {
                                    view.getBtn13().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !bip) {
                                    view.getBtn13().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !avgTemperature) {
                                    view.getBtn13().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !flag) {
                                    view.getBtn13().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !outline) {
                                    view.getBtn13().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn13().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn13().getGraphic());
                        }
                        break;
                    }
                case 13:
                    if(view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !name) {
                                    view.getBtn14().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !code) {
                                    view.getBtn14().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !capital) {
                                    view.getBtn14().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !population) {
                                    view.getBtn14().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !area) {
                                    view.getBtn14().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !avgHeight) {
                                    view.getBtn14().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !bip) {
                                    view.getBtn14().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !avgTemperature) {
                                    view.getBtn14().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !flag) {
                                    view.getBtn14().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !outline) {
                                    view.getBtn14().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn14().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn14().getGraphic());
                        }
                        break;
                    }
                case 14:
                    if(view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !name) {
                                    view.getBtn15().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !code) {
                                    view.getBtn15().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !capital) {
                                    view.getBtn15().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !population) {
                                    view.getBtn15().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !area) {
                                    view.getBtn15().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !avgHeight) {
                                    view.getBtn15().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !bip) {
                                    view.getBtn15().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !avgTemperature) {
                                    view.getBtn15().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !flag) {
                                    view.getBtn15().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !outline) {
                                    view.getBtn15().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn15().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn15().getGraphic());
                        }
                        break;
                    }
                case 15:
                    if(view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null) {
                        text = true;
                        switch (a) {
                            case 0:
                                if (view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !name) {
                                    view.getBtn16().setText(c3.getName());
                                    text = true;
                                    name = true;
                                    break;
                                }
                            case 1:
                                if (view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !code) {
                                    view.getBtn16().setText(c3.getCode());
                                    text = true;
                                    code = true;
                                    break;
                                }
                            case 2:
                                if (view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !capital) {
                                    view.getBtn16().setText(c3.getCapital());
                                    text = true;
                                    capital = true;
                                    break;
                                }
                            case 3:
                                if (view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !population) {
                                    view.getBtn16().setText(String.valueOf(c3.getPopulation()));
                                    text = true;
                                    population = true;
                                    break;
                                }
                            case 4:
                                if (view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !area) {
                                    view.getBtn16().setText(String.valueOf(c3.getArea()));
                                    text = true;
                                    area = true;
                                    break;
                                }
                            case 5:
                                if (view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !avgHeight) {
                                    view.getBtn16().setText(String.valueOf(c3.getAvgHeight()));
                                    text = true;
                                    avgHeight = true;
                                    break;
                                }
                            case 6:
                                if (view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !bip) {
                                    view.getBtn16().setText(String.valueOf(c3.getBip()));
                                    text = true;
                                    bip = true;
                                    break;
                                }
                            case 7:
                                if (view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !avgTemperature) {
                                    view.getBtn16().setText(String.valueOf(c3.getAvgTemperature()));
                                    text = true;
                                    avgTemperature = true;
                                    break;
                                }
                            case 8:
                                if (view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !flag) {
                                    view.getBtn16().setGraphic(new ImageView(c3.getFlag()));
                                    text = false;
                                    flag = true;
                                    break;
                                }
                            case 9:
                                if (view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !outline) {
                                    view.getBtn16().setGraphic(new ImageView(c3.getOutline()));
                                    text = false;
                                    outline = true;
                                    break;
                                }
                        }
                        if (text) {
                            richtigeAntwortenfürC3.add(view.getBtn16().getText());
                        } else {
                            richtigeAntwortenfürC3.add(view.getBtn16().getGraphic());
                        }
                        break;
                    }
            }
        }
        name = false; code = false; capital = false; population = false;
        area = false; avgHeight = false; bip = false; avgTemperature = false;
        flag = false; outline = false;
        for (int i = 0; i < n; i++){
            int a = random.nextInt(10);
            int b = random.nextInt(16);

            switch (b){
                case 0:
                    boolean text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !name) {
                                view.getBtn1().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !code) {
                                view.getBtn1().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !capital) {
                                view.getBtn1().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !population) {
                                view.getBtn1().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !area) {
                                view.getBtn1().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !avgHeight) {
                                view.getBtn1().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !bip) {
                                view.getBtn1().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !avgTemperature) {
                                view.getBtn1().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !flag) {
                                view.getBtn1().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn1().getText() == null && view.getBtn1().getGraphic() == null && !outline) {
                                view.getBtn1().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn1().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn1().getGraphic());
                    }
                    break;
                case 1:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !name) {
                                view.getBtn1().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !code) {
                                view.getBtn2().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !capital) {
                                view.getBtn2().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !population) {
                                view.getBtn2().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !area) {
                                view.getBtn2().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !avgHeight) {
                                view.getBtn2().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !bip) {
                                view.getBtn2().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !avgTemperature) {
                                view.getBtn2().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !flag) {
                                view.getBtn2().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn2().getText() == null && view.getBtn2().getGraphic() == null && !outline) {
                                view.getBtn2().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn2().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn2().getGraphic());
                    }
                    break;
                case 2:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !name) {
                                view.getBtn3().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !code) {
                                view.getBtn3().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !capital) {
                                view.getBtn3().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !population) {
                                view.getBtn3().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !area) {
                                view.getBtn3().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !avgHeight) {
                                view.getBtn3().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !bip) {
                                view.getBtn3().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && !avgTemperature) {
                                view.getBtn3().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && flag) {
                                view.getBtn3().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn3().getText() == null && view.getBtn3().getGraphic() == null && outline) {
                                view.getBtn3().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = false;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn3().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn3().getGraphic());
                    }
                    break;
                case 3:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !name) {
                                view.getBtn4().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !code) {
                                view.getBtn4().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !capital) {
                                view.getBtn4().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !population) {
                                view.getBtn4().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !area) {
                                view.getBtn4().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !avgHeight) {
                                view.getBtn4().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !bip) {
                                view.getBtn4().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !avgTemperature) {
                                view.getBtn4().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !flag) {
                                view.getBtn4().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn4().getText() == null && view.getBtn4().getGraphic() == null && !outline) {
                                view.getBtn4().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn4().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn4().getGraphic());
                    }
                    break;
                case 4:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !name) {
                                view.getBtn5().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !code) {
                                view.getBtn5().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !capital) {
                                view.getBtn5().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !population) {
                                view.getBtn5().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !area) {
                                view.getBtn5().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !avgHeight) {
                                view.getBtn5().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !bip) {
                                view.getBtn5().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !avgTemperature) {
                                view.getBtn5().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !flag) {
                                view.getBtn5().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn5().getText() == null && view.getBtn5().getGraphic() == null && !outline) {
                                view.getBtn5().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn5().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn5().getGraphic());
                    }
                    break;
                case 5:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !name) {
                                view.getBtn6().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !code) {
                                view.getBtn6().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !capital) {
                                view.getBtn6().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !population) {
                                view.getBtn6().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !area) {
                                view.getBtn6().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !avgHeight) {
                                view.getBtn6().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !bip) {
                                view.getBtn6().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !avgTemperature) {
                                view.getBtn6().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !flag) {
                                view.getBtn6().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn6().getText() == null && view.getBtn6().getGraphic() == null && !outline) {
                                view.getBtn6().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn6().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn6().getGraphic());
                    }
                    break;
                case 6:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !name) {
                                view.getBtn7().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !code) {
                                view.getBtn7().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !capital) {
                                view.getBtn7().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !population) {
                                view.getBtn7().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !area) {
                                view.getBtn7().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !avgHeight) {
                                view.getBtn7().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !bip) {
                                view.getBtn7().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !avgTemperature) {
                                view.getBtn7().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !flag) {
                                view.getBtn7().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn7().getText() == null && view.getBtn7().getGraphic() == null && !outline) {
                                view.getBtn7().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn7().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn7().getGraphic());
                    }
                    break;
                case 7:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !name) {
                                view.getBtn8().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !code) {
                                view.getBtn8().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !capital) {
                                view.getBtn8().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !population) {
                                view.getBtn8().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !area) {
                                view.getBtn8().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !avgHeight) {
                                view.getBtn8().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !bip) {
                                view.getBtn8().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !avgTemperature) {
                                view.getBtn8().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !flag) {
                                view.getBtn8().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn8().getText() == null && view.getBtn8().getGraphic() == null && !outline) {
                                view.getBtn8().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn8().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn8().getGraphic());
                    }
                    break;
                case 8:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !name) {
                                view.getBtn9().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !code) {
                                view.getBtn9().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !capital) {
                                view.getBtn9().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !population) {
                                view.getBtn9().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !area) {
                                view.getBtn9().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !avgHeight) {
                                view.getBtn9().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !bip) {
                                view.getBtn9().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !avgTemperature) {
                                view.getBtn9().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !flag) {
                                view.getBtn9().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn9().getText() == null && view.getBtn9().getGraphic() == null && !outline) {
                                view.getBtn9().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn9().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn9().getGraphic());
                    }
                    break;
                case 9:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !name) {
                                view.getBtn10().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !code) {
                                view.getBtn10().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !capital) {
                                view.getBtn10().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !population) {
                                view.getBtn10().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !area) {
                                view.getBtn10().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !avgHeight) {
                                view.getBtn10().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !bip) {
                                view.getBtn10().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !avgTemperature) {
                                view.getBtn10().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !flag) {
                                view.getBtn10().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn10().getText() == null && view.getBtn10().getGraphic() == null && !outline) {
                                view.getBtn10().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn10().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn10().getGraphic());
                    }
                    break;
                case 10:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !name) {
                                view.getBtn11().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !code) {
                                view.getBtn11().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !capital) {
                                view.getBtn11().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !population) {
                                view.getBtn11().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !area) {
                                view.getBtn11().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !avgHeight) {
                                view.getBtn11().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !bip) {
                                view.getBtn11().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !avgTemperature) {
                                view.getBtn11().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !flag) {
                                view.getBtn11().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn11().getText() == null && view.getBtn11().getGraphic() == null && !outline) {
                                view.getBtn11().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn11().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn11().getGraphic());
                    }
                    break;
                case 11:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !name) {
                                view.getBtn12().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !code) {
                                view.getBtn12().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !capital) {
                                view.getBtn12().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !population) {
                                view.getBtn12().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !area) {
                                view.getBtn12().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !avgHeight) {
                                view.getBtn12().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !bip) {
                                view.getBtn12().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !avgTemperature) {
                                view.getBtn12().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !flag) {
                                view.getBtn12().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn12().getText() == null && view.getBtn12().getGraphic() == null && !outline) {
                                view.getBtn12().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn12().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn12().getGraphic());
                    }
                    break;
                case 12:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !name) {
                                view.getBtn13().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !code) {
                                view.getBtn13().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !capital) {
                                view.getBtn13().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !population) {
                                view.getBtn13().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !area) {
                                view.getBtn13().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !avgHeight) {
                                view.getBtn13().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !bip) {
                                view.getBtn13().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !avgTemperature) {
                                view.getBtn13().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !flag) {
                                view.getBtn13().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn13().getText() == null && view.getBtn13().getGraphic() == null && !outline) {
                                view.getBtn13().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn13().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn13().getGraphic());
                    }
                    break;
                case 13:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !name) {
                                view.getBtn14().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !code) {
                                view.getBtn14().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !capital) {
                                view.getBtn14().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !population) {
                                view.getBtn14().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !area) {
                                view.getBtn14().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !avgHeight) {
                                view.getBtn14().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !bip) {
                                view.getBtn14().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !avgTemperature) {
                                view.getBtn14().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !flag) {
                                view.getBtn14().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn14().getText() == null && view.getBtn14().getGraphic() == null && !outline) {
                                view.getBtn14().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn14().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn14().getGraphic());
                    }
                    break;
                case 14:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !name) {
                                view.getBtn15().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !code) {
                                view.getBtn15().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !capital) {
                                view.getBtn15().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !population) {
                                view.getBtn15().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !area) {
                                view.getBtn15().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !avgHeight) {
                                view.getBtn15().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !bip) {
                                view.getBtn15().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !avgTemperature) {
                                view.getBtn15().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !flag) {
                                view.getBtn15().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn15().getText() == null && view.getBtn15().getGraphic() == null && !outline) {
                                view.getBtn15().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn15().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn15().getGraphic());
                    }
                    break;
                case 15:
                    text = true;
                    switch (a){
                        case 0:
                            if(view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !name) {
                                view.getBtn16().setText(c4.getName());
                                text = true;
                                name = true;
                                break;
                            }
                        case 1:
                            if(view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !code) {
                                view.getBtn16().setText(c4.getCode());
                                text = true;
                                code = true;
                                break;
                            }
                        case 2:
                            if(view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !capital) {
                                view.getBtn16().setText(c4.getCapital());
                                text = true;
                                capital = true;
                                break;
                            }
                        case 3:
                            if(view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !population) {
                                view.getBtn16().setText(String.valueOf(c4.getPopulation()));
                                text = true;
                                population = true;
                                break;
                            }
                        case 4:
                            if(view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !area) {
                                view.getBtn16().setText(String.valueOf(c4.getArea()));
                                text = true;
                                area = true;
                                break;
                            }
                        case 5:
                            if(view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !avgHeight) {
                                view.getBtn16().setText(String.valueOf(c4.getAvgHeight()));
                                text = true;
                                avgHeight = true;
                                break;
                            }
                        case 6:
                            if(view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !bip) {
                                view.getBtn16().setText(String.valueOf(c4.getBip()));
                                text = true;
                                bip = true;
                                break;
                            }
                        case 7:
                            if(view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !avgTemperature) {
                                view.getBtn16().setText(String.valueOf(c4.getAvgTemperature()));
                                text = true;
                                avgTemperature = true;
                                break;
                            }
                        case 8:
                            if(view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !flag) {
                                view.getBtn16().setGraphic(new ImageView(c4.getFlag()));
                                text = false;
                                flag = true;
                                break;
                            }
                        case 9:
                            if (view.getBtn16().getText() == null && view.getBtn16().getGraphic() == null && !outline) {
                                view.getBtn16().setGraphic(new ImageView(c4.getOutline()));
                                text = false;
                                outline = true;
                                break;
                            }
                    }
                    if(text){
                        richtigeAntwortenfürC4.add(view.getBtn16().getText());
                    }
                    else{
                        richtigeAntwortenfürC4.add(view.getBtn16().getGraphic());
                    }
                    break;
            }
        }
    }

    public boolean auswählen(String wert) {
        ausgewählt.add(wert);
        boolean c1 = false;
        boolean c2 = false;
        boolean c3 = false;
        boolean c4 = false;
        if(ausgewählt.size() == 1) {
            if (richtigeAntwortenfürC1.contains(ausgewählt)) {
                c1 = true;
            }
            if (richtigeAntwortenfürC2.contains(ausgewählt)) {
                c2 = true;
            }
            if (richtigeAntwortenfürC2.contains(ausgewählt)) {
                c3 = true;
            }
            if (richtigeAntwortenfürC2.contains(ausgewählt)) {
                c4 = true;
            }
        }
        if(c1){
            return richtigeAntwortenfürC1.contains(ausgewählt);
        }
        if(c2){
            return richtigeAntwortenfürC2.contains(ausgewählt);
        }
        if(c3){
            return richtigeAntwortenfürC1.contains(ausgewählt);
        }
        if(c4){
            return richtigeAntwortenfürC2.contains(ausgewählt);
        }
        return false;
    }

    public boolean allesRichtig() {
        return (ausgewählt.containsAll(richtigeAntwortenfürC1) || ausgewählt.containsAll(richtigeAntwortenfürC2)
                || ausgewählt.containsAll(richtigeAntwortenfürC3) || ausgewählt.containsAll(richtigeAntwortenfürC4))
                && (ausgewählt.size() == richtigeAntwortenfürC1.size() || ausgewählt.size() == richtigeAntwortenfürC2.size()
                || ausgewählt.size() == richtigeAntwortenfürC3.size() || ausgewählt.size() == richtigeAntwortenfürC4.size());
    }

    public void reset() {
        ausgewählt.clear();
    }
}


