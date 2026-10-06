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
        System.out.println(c1.getName_EN());
        System.out.println(c2.getName_EN());
        System.out.println(c3.getName_EN());
        System.out.println(c4.getName_EN());
    }


    private final Set<Object> correctAnswersC1 = Collections.synchronizedSet(new HashSet<>());
    private final Set<Object> correctAnswersC2 = Collections.synchronizedSet(new HashSet<>());
    private final Set<Object> correctAnswersC3 = Collections.synchronizedSet(new HashSet<>());
    private final Set<Object> correctAnswersC4 = Collections.synchronizedSet(new HashSet<>());
    private final Set<Object> selected = new HashSet<>();
    private final Button[] buttons = new Button[]{view.getBtn1(), view.getBtn2(), view.getBtn3(), view.getBtn4(),
            view.getBtn5(), view.getBtn6(), view.getBtn7(), view.getBtn8(),
            view.getBtn9(), view.getBtn10(), view.getBtn11(), view.getBtn12(),
            view.getBtn13(), view.getBtn14(), view.getBtn15(), view.getBtn16()};

    public FactsGameModel() {
        setCorrectAnswers();
    }

    public void setCorrectAnswers() {
        setCountries();
        Random random = new Random();

        Button[] buttons = new Button[]{
                view.getBtn1(), view.getBtn2(), view.getBtn3(), view.getBtn4(),
                view.getBtn5(), view.getBtn6(), view.getBtn7(), view.getBtn8(),
                view.getBtn9(), view.getBtn10(), view.getBtn11(), view.getBtn12(),
                view.getBtn13(), view.getBtn14(), view.getBtn15(), view.getBtn16()
        };

        Country[] countries = {c1, c2, c3, c4};
        Set[] answersSet = {correctAnswersC1, correctAnswersC2, correctAnswersC3, correctAnswersC4};

        for (int c = 0; c < 4; c++) {
            Country country = countries[c];
            Set<Object> currentSet = answersSet[c];
            Set<Integer> selectedProperties = new HashSet<>();

            while (currentSet.size() < 4) {
                int property = random.nextInt(10);

                if (selectedProperties.contains(property)) {
                    continue;
                }

                int buttonIndex = random.nextInt(16);
                Button btn = buttons[buttonIndex];

                if (btn.getText().isBlank() && btn.getGraphic() == null) {

                    Object addedObject = null;

                    switch (property) {
                        case 0 -> {
                            btn.setText(country.getName_EN());
                            addedObject = country.getName_EN();
                        }
                        case 1 -> {
                            btn.setText(country.getCode());
                            addedObject = country.getCode();
                        }
                        case 2 -> {
                            btn.setText(country.getCapital());
                            addedObject = country.getCapital();
                        }
                        case 3 -> {
                            String population = nf.format(country.getPopulation()) + " people";
                            btn.setText(population);
                            addedObject = population;
                        }
                        case 4 -> {
                            String area = nf.format(country.getArea()) + " km² area";
                            btn.setText(area);
                            addedObject = area;
                        }
                        case 5 -> {
                            String bodyHeight = nf.format(country.getAvgHeight()) + "cm ⌀ body height";
                            btn.setText(bodyHeight);
                            addedObject = bodyHeight;
                        }
                        case 6 -> {
                            String gdpText = gdpFormat(country.getGdp()) + " $";
                            btn.setText(gdpText);
                            addedObject = gdpText;
                        }
                        case 7 -> {
                            String temp = nf.format(country.getAvgTemperature()) + " ⌀ °C";
                            btn.setText(temp);
                            addedObject = temp;
                        }
                        case 8 -> {
                            ImageView img = new ImageView(country.getFlag());
                            img.setFitHeight(75);
                            img.setFitWidth(100);
                            btn.setGraphic(img);
                            addedObject = img;
                        }
                        case 9 -> {
                            ImageView img = new ImageView(country.getOutline());
                            img.setFitHeight(75);
                            img.setFitWidth(100);
                            btn.setGraphic(img);
                            addedObject = img;
                        }
                    }

                    if (addedObject != null) {
                        currentSet.add(addedObject);
                        selectedProperties.add(property);
                    }
                }
            }
        }
        System.out.println(correctAnswersC1);
        System.out.println(correctAnswersC2);
        System.out.println(correctAnswersC3);
        System.out.println(correctAnswersC4);
    }


    public boolean choose(Object val) {
        selected.add(val);

        if (selected.size() == 1) {
            if (correctAnswersC1.containsAll(selected)) {
                isC1 = true;
            }
            if (correctAnswersC2.containsAll(selected)) {
                isC2 = true;
            }
            if (correctAnswersC3.containsAll(selected)) {
                isC3 = true;
            }
            if (correctAnswersC4.containsAll(selected)) {
                isC4 = true;
            }
        }
        if (isC1) {
            return correctAnswersC1.containsAll(selected);
        }
        if (isC2) {
            return correctAnswersC2.containsAll(selected);
        }
        if (isC3) {
            return correctAnswersC3.containsAll(selected);
        }
        if (isC4) {
            return correctAnswersC4.containsAll(selected);
        }
        return false;
    }


    public boolean everythingCorrect() {

        if ((selected.containsAll(correctAnswersC1) || selected.containsAll(correctAnswersC2)
                || selected.containsAll(correctAnswersC3) || selected.containsAll(correctAnswersC4))
                && (selected.size() == correctAnswersC1.size() || selected.size() == correctAnswersC2.size()
                || selected.size() == correctAnswersC3.size() || selected.size() == correctAnswersC4.size())) {
            isC1 = false;
            isC2 = false;
            isC3 = false;
            isC4 = false;
            return true;
        }
        return false;
    }

    public void reset() {
        selected.clear();
    }

    public FactsGameView getView() {
        return view;
    }


    public FactsGameModelCountryData getFactsGameModelCountryData() {
        return factsGameModelCountryData;
    }

    public Set<Object> getSelected() {
        return selected;
    }

    private String gdpFormat(double gdp) {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance(java.util.Locale.GERMAN);
        if (gdp >= 1_000_000_000) {
            double billion = gdp / 1_000_000_000.0;
            nf.setMaximumFractionDigits(2);
            return nf.format(billion) + " billion GDP";
        }
        return nf.format(gdp) + " GDP";
    }
}


