package model;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import view.FactsGameView;

import java.text.NumberFormat;
import java.util.*;

public class FactsGameModel {

    private FactsGameView view = new FactsGameView();
    private FactsGameModelCountryData factsGameModelCountryData = new FactsGameModelCountryData();
    private Country c1;
    private Country c2;
    private Country c3;
    private Country c4;
    private boolean isC1 = false;
    private boolean isC2 = false;
    private boolean isC3 = false;
    private boolean isC4 = false;
    NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);

    public void setCountries() {
        factsGameModelCountryData.connect();
        System.out.println(factsGameModelCountryData.getConnection());
        c1 = factsGameModelCountryData.getCountry();
        do {
            c2 = factsGameModelCountryData.getCountry();
        } while (c1.getId() == c2.getId());
        do {
            c3 = factsGameModelCountryData.getCountry();
        } while (c1.getId() == c3.getId() || c2.getId() == c3.getId());
        do {
            c4 = factsGameModelCountryData.getCountry();
        } while (c1.getId() == c4.getId() || c2.getId() == c4.getId() || c3.getId() == c4.getId());
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
    private final Button[] buttons = new Button[]{view.getBtn1(), view.getBtn2(), view.getBtn3(), view.getBtn4(),
            view.getBtn5(), view.getBtn6(), view.getBtn7(), view.getBtn8(),
            view.getBtn9(), view.getBtn10(), view.getBtn11(), view.getBtn12(),
            view.getBtn13(), view.getBtn14(), view.getBtn15(), view.getBtn16()};

    public FactsGameModel() {
        setRichtigeAntworten();
    }

    public void setRichtigeAntworten() {
        setCountries();
        Random random = new Random();

        Button[] buttons = new Button[]{
                view.getBtn1(), view.getBtn2(), view.getBtn3(), view.getBtn4(),
                view.getBtn5(), view.getBtn6(), view.getBtn7(), view.getBtn8(),
                view.getBtn9(), view.getBtn10(), view.getBtn11(), view.getBtn12(),
                view.getBtn13(), view.getBtn14(), view.getBtn15(), view.getBtn16()
        };

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
                        case 0 -> {
                            btn.setText(country.getName());
                            hinzugefuegtesObjekt = country.getName();
                        }
                        case 1 -> {
                            btn.setText(country.getCode());
                            hinzugefuegtesObjekt = country.getCode();
                        }
                        case 2 -> {
                            btn.setText(country.getCapital());
                            hinzugefuegtesObjekt = country.getCapital();
                        }
                        case 3 -> {
                            String einwohner = nf.format(country.getPopulation()) + " Einwohner";
                            btn.setText(einwohner);
                            hinzugefuegtesObjekt = einwohner;
                        }
                        case 4 -> {
                            String flaeche = nf.format(country.getArea()) + " km² Fläche";
                            btn.setText(flaeche);
                            hinzugefuegtesObjekt = flaeche;
                        }
                        case 5 -> {
                            String groesse = nf.format(country.getAvgHeight()) + "cm ⌀ Körpergröße";
                            btn.setText(groesse);
                            hinzugefuegtesObjekt = groesse;
                        }
                        case 6 -> {
                            String bipText = gdpFormat(country.getBip()) + " $";
                            btn.setText(bipText);
                            hinzugefuegtesObjekt = bipText;
                        }
                        case 7 -> {
                            String temp = nf.format(country.getAvgTemperature()) + " ⌀ °C";
                            btn.setText(temp);
                            hinzugefuegtesObjekt = temp;
                        }
                        case 8 -> {
                            ImageView img = new ImageView(country.getFlag());
                            img.setFitHeight(75);
                            img.setFitWidth(100);
                            btn.setGraphic(img);
                            hinzugefuegtesObjekt = img;
                        }
                        case 9 -> {
                            ImageView img = new ImageView(country.getOutline());
                            img.setFitHeight(75);
                            img.setFitWidth(100);
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
        System.out.println(richtigeAntwortenC1);
        System.out.println(richtigeAntwortenC2);
        System.out.println(richtigeAntwortenC3);
        System.out.println(richtigeAntwortenC4);
    }


    public boolean auswaehlen(Object wert) {
        ausgewaehlt.add(wert);

        if (ausgewaehlt.size() == 1) {
            if (richtigeAntwortenC1.containsAll(ausgewaehlt)) {
                isC1 = true;
            }
            if (richtigeAntwortenC2.containsAll(ausgewaehlt)) {
                isC2 = true;
            }
            if (richtigeAntwortenC3.containsAll(ausgewaehlt)) {
                isC3 = true;
            }
            if (richtigeAntwortenC4.containsAll(ausgewaehlt)) {
                isC4 = true;
            }
        }
        if (isC1) {
            return richtigeAntwortenC1.containsAll(ausgewaehlt);
        }
        if (isC2) {
            return richtigeAntwortenC2.containsAll(ausgewaehlt);
        }
        if (isC3) {
            return richtigeAntwortenC3.containsAll(ausgewaehlt);
        }
        if (isC4) {
            return richtigeAntwortenC4.containsAll(ausgewaehlt);
        }
        return false;
    }


    public boolean allesRichtig() {

        if ((ausgewaehlt.containsAll(richtigeAntwortenC1) || ausgewaehlt.containsAll(richtigeAntwortenC2)
                || ausgewaehlt.containsAll(richtigeAntwortenC3) || ausgewaehlt.containsAll(richtigeAntwortenC4))
                && (ausgewaehlt.size() == richtigeAntwortenC1.size() || ausgewaehlt.size() == richtigeAntwortenC2.size()
                || ausgewaehlt.size() == richtigeAntwortenC3.size() || ausgewaehlt.size() == richtigeAntwortenC4.size())) {
            isC1 = false;
            isC2 = false;
            isC3 = false;
            isC4 = false;
            return true;
        }
        return false;
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

    private String gdpFormat(double gdp) {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance(java.util.Locale.GERMAN);
        if (gdp >= 1_000_000_000) {
            double milliarden = gdp / 1_000_000_000.0;
            nf.setMaximumFractionDigits(2);
            return nf.format(milliarden) + " Mrd. BIP";
        }
        return nf.format(gdp) + " BIP";
    }
}


