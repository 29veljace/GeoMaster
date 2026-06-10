package model;


import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import view.FactsGameView;

import java.util.Collections;
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
        System.out.println(factsGameModelCountryData.getConnection());
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
        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getName());
        System.out.println(c4.getName());
    }


    private final Set<Object> richtigeAntwortenC1 = Collections.synchronizedSet(new HashSet<>());
    private final Set<Object> richtigeAntwortenC2 = Collections.synchronizedSet(new HashSet<>());
    private final Set<Object> richtigeAntwortenC3 = Collections.synchronizedSet(new HashSet<>());
    private final Set<Object> richtigeAntwortenC4 = Collections.synchronizedSet(new HashSet<>());
    private final Set<Object> ausgewaehlt = new HashSet<>();
    private final Button[] buttons = new Button[]{view.getBtn1(),view.getBtn2(),view.getBtn3(),view.getBtn4(),
                                            view.getBtn5(),view.getBtn6(),view.getBtn7(),view.getBtn8(),
                                            view.getBtn9(),view.getBtn10(),view.getBtn11(),view.getBtn12(),
                                            view.getBtn13(),view.getBtn14(),view.getBtn15(),view.getBtn16()};

    public FactsGameModel(){
        setRichtigeAntworten();
    }

    public void setRichtigeAntworten(){
        setCountries();
        Random random = new Random();

        // Alle Buttons in ein Array packen, um sie über einen Index anzusprechen
        Button[] buttons = new Button[] {
                view.getBtn1(), view.getBtn2(), view.getBtn3(), view.getBtn4(),
                view.getBtn5(), view.getBtn6(), view.getBtn7(), view.getBtn8(),
                view.getBtn9(), view.getBtn10(), view.getBtn11(), view.getBtn12(),
                view.getBtn13(), view.getBtn14(), view.getBtn15(), view.getBtn16()
        };

        // Die 4 Länder und ihre zugehörigen Sets in Arrays packen
        Country[] countries = {c1, c2, c3, c4};
        Set[] antwortenSets = {richtigeAntwortenC1, richtigeAntwortenC2, richtigeAntwortenC3, richtigeAntwortenC4};

        for (int c = 0; c < 4; c++) {
            Country country = countries[c];
            Set<Object> aktuellesSet = antwortenSets[c];
            Set<Integer> gewaehlteEigenschaften = new HashSet<>();

            while (aktuellesSet.size() < 4) {
                int eigenschaft = random.nextInt(10);

                if (gewaehlteEigenschaften.contains(eigenschaft)) {
                    continue;
                }

                int buttonIndex = random.nextInt(16);
                Button btn = buttons[buttonIndex];

                if (btn.getText().isBlank() && btn.getGraphic() == null) {

                    Object hinzugefuegtesObjekt = null;

                    switch (eigenschaft) {
                        case 0 -> { btn.setText(country.getName()); hinzugefuegtesObjekt = country.getName(); }
                        case 1 -> { btn.setText(country.getCode()); hinzugefuegtesObjekt = country.getCode(); }
                        case 2 -> { btn.setText(country.getCapital()); hinzugefuegtesObjekt = country.getCapital(); }
                        case 3 -> { btn.setText(country.getPopulation() + " (pop.)"); hinzugefuegtesObjekt = btn.getText(); }
                        case 4 -> { btn.setText(country.getArea() + " km²"); hinzugefuegtesObjekt = btn.getText(); }
                        case 5 -> { btn.setText(country.getAvgHeight() + " cm"); hinzugefuegtesObjekt = btn.getText(); }
                        case 6 -> { btn.setText(country.getBip() + " (Bip)"); hinzugefuegtesObjekt = btn.getText(); }
                        case 7 -> { btn.setText(country.getAvgTemperature() + " °C"); hinzugefuegtesObjekt = btn.getText(); }
                        case 8 -> {
                            ImageView img = new ImageView(country.getFlag());
                            img.setFitHeight(75); img.setFitWidth(100);
                            btn.setGraphic(img);
                            hinzugefuegtesObjekt = img;
                        }
                        case 9 -> {
                            ImageView img = new ImageView(country.getOutline());
                            img.setFitHeight(75); img.setFitWidth(100);
                            btn.setGraphic(img);
                            hinzugefuegtesObjekt = img;
                        }
                    }

                    if (hinzugefuegtesObjekt != null) {
                        aktuellesSet.add(hinzugefuegtesObjekt);
                        gewaehlteEigenschaften.add(eigenschaft);
                    }
                }
            }
        }
    }



    public boolean auswaehlen(Object wert) {
        ausgewaehlt.add(wert);
        boolean c1 = false;
        boolean c2 = false;
        boolean c3 = false;
        boolean c4 = false;
        if(ausgewaehlt.size() == 1) {
            if (richtigeAntwortenC1.containsAll(ausgewaehlt)) {
                c1 = true;
            }
            if (richtigeAntwortenC2.containsAll(ausgewaehlt)) {
                c2 = true;
            }
            if (richtigeAntwortenC3.containsAll(ausgewaehlt)) {
                c3 = true;
            }
            if (richtigeAntwortenC4.containsAll(ausgewaehlt)) {
                c4 = true;
            }
        }
        if(c1){
            return richtigeAntwortenC1.containsAll(ausgewaehlt);
        }
        if(c2){
            return richtigeAntwortenC2.containsAll(ausgewaehlt);
        }
        if(c3){
            return richtigeAntwortenC3.containsAll(ausgewaehlt);
        }
        if(c4){
            return richtigeAntwortenC4.containsAll(ausgewaehlt);
        }
        return false;
    }


    public boolean allesRichtig() {

        return (ausgewaehlt.containsAll(richtigeAntwortenC1) || ausgewaehlt.containsAll(richtigeAntwortenC2)
                || ausgewaehlt.containsAll(richtigeAntwortenC3) || ausgewaehlt.containsAll(richtigeAntwortenC4))
                && (ausgewaehlt.size() == richtigeAntwortenC1.size() || ausgewaehlt.size() == richtigeAntwortenC2.size()
                || ausgewaehlt.size() == richtigeAntwortenC3.size() || ausgewaehlt.size() == richtigeAntwortenC4.size());
    }

    public void reset() {
        ausgewaehlt.clear();
    }

    public FactsGameView getView() {
        return view;
    }



    public FactsGameModelCountryData getFactsGameModelCountryData() {
        return factsGameModelCountryData;
    }

    public Set<Object> getAusgewaehlt() {
        return ausgewaehlt;
    }

}


