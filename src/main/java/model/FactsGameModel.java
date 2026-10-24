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

    public void setCorrectAnswers() {
        setCountries();
        Random random = new Random();

        Country[] countries = {c1, c2, c3, c4};
        Set[] answersSet = {correctAnswersC1, correctAnswersC2, correctAnswersC3, correctAnswersC4};

        correctAnswersC1.clear();
        correctAnswersC2.clear();
        correctAnswersC3.clear();
        correctAnswersC4.clear();

        Set<Object> globalValues = new HashSet<>();

        for (int c = 0; c < 4; c++) {
            Country country = countries[c];
            Set<Object> currentSet = answersSet[c];

            List<Integer> properties;
            boolean unique;
            List<Object> generatedValues = new ArrayList<>();
            do {
                unique = true;
                generatedValues.clear();

                List<Integer> identifiers = new ArrayList<>(List.of(0, 1, 8));
                Collections.shuffle(identifiers, random);

                List<Integer> pool = new ArrayList<>(List.of(2, 3, 4, 5, 6, 7, 9, 10,11));
                pool.add(identifiers.get(2));
                Collections.shuffle(pool, random);

                properties = List.of(
                        identifiers.get(0),
                        identifiers.get(1),
                        pool.get(0),
                        pool.get(1)
                );

                Set<Object> tempCountryValues = new HashSet<>();
                for (int property : properties) {
                    Object val = getPropertyValue(country, property);
                    if (globalValues.contains(val) || !tempCountryValues.add(val)) {
                        unique = false;
                        break;
                    }
                    generatedValues.add(val);
                }
            } while (!unique);
            for (int i = 0; i < properties.size(); i++) {
                int property = properties.get(i);
                Object val = generatedValues.get(i);

                globalValues.add(val);
                currentSet.add(val);

                Button btn;
                do {
                    btn = buttons[random.nextInt(16)];
                } while (!btn.getText().isBlank() || btn.getGraphic() != null);

                applyPropertyToButton(btn, property, val);
            }
        }

        System.out.println(correctAnswersC1);
        System.out.println(correctAnswersC2);
        System.out.println(correctAnswersC3);
        System.out.println(correctAnswersC4);
    }

    private Object getPropertyValue(Country country, int property) {
        boolean en = util.LanguageManager.getLanguage().equals("en");
        return switch (property) {
            case 0 -> en ? country.getName_EN() : country.getName_DE();
            case 1 -> country.getCode();
            case 2 -> en ? country.getCapital_EN() : country.getCapital_DE();
            case 3 -> nf.format(country.getPopulation()) + (en ? " people" : " Einwohner");
            case 4 -> nf.format(country.getArea()) + (en ? " km² area" : " km² Fläche");
            case 5 -> nf.format(country.getAvgHeight()) + (en ? "cm ⌀ body height" : "cm ⌀ Körpergröße");
            case 6 -> gdpFormat(country.getGdp()) + " $";
            case 7 -> nf.format(country.getAvgTemperature()) + " ⌀ °C";
            case 8 -> country.getFlag();
            case 9 -> country.getOutline();
            case 10 -> nf.format(country.getPassportStrength()) + (en ? " visa-free destinations" : " visafreie Reiseziele");
            case 11 -> nf.format(Math.round(country.getGdpc())) + " $"
                    + (en ? " GDP/capita" : " BIP pro Kopf");
            default -> throw new IllegalArgumentException("Unknown property: " + property);
        };
    }

    private void applyPropertyToButton(Button btn, int property, Object value) {
        if (property == 8 || property == 9) {
            Image imgResource = (Image) value;
            ImageView img = new ImageView(imgResource);
            img.setFitHeight(75);
            img.setFitWidth(100);
            btn.setGraphic(img);
        } else {
            btn.setText((String) value);
        }
    }

    public FactsGameModel() {
        setCorrectAnswers();
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
        return selectedButtons.size() != 4;
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