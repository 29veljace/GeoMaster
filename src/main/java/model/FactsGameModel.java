package model;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
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

    NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);

    public Button[] getButtons() { return buttons; }
    public Set<Button> getSelectedButtons() { return selectedButtons; }

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

    private final Button[] buttons = new Button[]{
            view.getBtn1(), view.getBtn2(), view.getBtn3(), view.getBtn4(),
            view.getBtn5(), view.getBtn6(), view.getBtn7(), view.getBtn8(),
            view.getBtn9(), view.getBtn10(), view.getBtn11(), view.getBtn12(),
            view.getBtn13(), view.getBtn14(), view.getBtn15(), view.getBtn16()
    };

    public FactsGameModel() {
        setCorrectAnswers();
    }

    public void setCorrectAnswers() {
        setCountries();
        Random random = new Random();

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
                            if (util.LanguageManager.getLanguage().equals("en")) {
                                btn.setText(country.getName_EN());
                                addedObject = country.getName_EN();
                            } else {
                                btn.setText(country.getName_DE());
                                addedObject = country.getName_DE();
                            }
                        }
                        case 1 -> {
                            btn.setText(country.getCode());
                            addedObject = country.getCode();
                        }
                        case 2 -> {
                            if (util.LanguageManager.getLanguage().equals("en")) {
                                btn.setText(country.getCapital_EN());
                                addedObject = country.getCapital_EN();
                            } else {
                                btn.setText(country.getCapital_DE());
                                addedObject = country.getCapital_DE();
                            }
                        }
                        case 3 -> {
                            String population;
                            if (util.LanguageManager.getLanguage().equals("en")) {
                                population = nf.format(country.getPopulation()) + " people";
                            } else {
                                population = nf.format(country.getPopulation()) + " Einwohner";
                            }
                            btn.setText(population);
                            addedObject = population;
                        }
                        case 4 -> {
                            String area;
                            if (util.LanguageManager.getLanguage().equals("en")) {
                                area = nf.format(country.getArea()) + " km² area";
                            } else {
                                area = nf.format(country.getArea()) + " km² area";
                            }
                            btn.setText(area);
                            addedObject = area;
                        }
                        case 5 -> {
                            String bodyHeight;
                            if (util.LanguageManager.getLanguage().equals("en")) {
                                bodyHeight = nf.format(country.getAvgHeight()) + "cm ⌀ body height";
                            } else {
                                bodyHeight = nf.format(country.getAvgHeight()) + "cm ⌀ Körpergröße";
                            }
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
                            Image flagImage = country.getFlag();
                            ImageView img = new ImageView(flagImage);
                            img.setFitHeight(75);
                            img.setFitWidth(100);
                            btn.setGraphic(img);
                            // Wir speichern das Image-Objekt statt des ImageView-Nodes für stabilen Vergleich
                            addedObject = flagImage;
                        }
                        case 9 -> {
                            Image outlineImage = country.getOutline();
                            ImageView img = new ImageView(outlineImage);
                            img.setFitHeight(75);
                            img.setFitWidth(100);
                            btn.setGraphic(img);
                            // Wir speichern das Image-Objekt statt des ImageView-Nodes für stabilen Vergleich
                            addedObject = outlineImage;
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
        NumberFormat localNf = util.LanguageManager.getLanguage().equals("en")
                ? java.text.NumberFormat.getInstance(java.util.Locale.US)
                : java.text.NumberFormat.getInstance(java.util.Locale.GERMAN);

        if (gdp >= 1_000_000_000) {
            double billion = gdp / 1_000_000_000.0;
            localNf.setMaximumFractionDigits(2);
            if (util.LanguageManager.getLanguage().equals("en")) {
                return localNf.format(billion) + " billion GDP";
            } else {
                return localNf.format(billion) + " Mrd. BIP";
            }
        }
        if (util.LanguageManager.getLanguage().equals("de")) {
            return localNf.format(gdp) + " BIP";
        }
        return localNf.format(gdp) + " GDP";
    }

    public record SubmitResult(boolean correct, int mistakes) {}

    private final Set<Button> selectedButtons = new LinkedHashSet<>();

    private Object valueOf(Button btn) {
        if (btn.getGraphic() != null && btn.getGraphic() instanceof ImageView imageView) {
            return imageView.getImage();
        }
        return btn.getText();
    }

    public void toggle(Button btn) {
        Object val = valueOf(btn);
        if (selectedButtons.contains(btn)) {
            selectedButtons.remove(btn);
            selected.remove(val);
        } else if (selectedButtons.size() < 4) {
            selectedButtons.add(btn);
            selected.add(val);
        }
    }

    public boolean isSelected(Button btn) {
        return selectedButtons.contains(btn);
    }

    public boolean canSubmit() {
        return selectedButtons.size() == 4;
    }

    public SubmitResult submit() {
        List<Set<Object>> allSets = List.of(correctAnswersC1, correctAnswersC2, correctAnswersC3, correctAnswersC4);
        int best = 0;
        for (Set<Object> answers : allSets) {
            int overlap = 0;
            for (Button b : selectedButtons) {
                if (answers.contains(valueOf(b))) overlap++;
            }
            best = Math.max(best, overlap);
        }
        int mistakes = 4 - best;
        return new SubmitResult(mistakes == 0, mistakes);
    }

    public void reset() {
        selected.clear();
        selectedButtons.clear();
    }
}