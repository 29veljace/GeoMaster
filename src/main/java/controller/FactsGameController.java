package controller;

import javafx.scene.control.Button;
import model.FactsGameModel;
import model.GameMode;
import util.HighScoreManager;
import util.SceneManager;

public class FactsGameController {
    // controller für das spiel mit den fakten
    private final FactsGameModel model;
    private int lives;
    private int counter;

    public FactsGameController(FactsGameModel model) {
        this.model = model;
        lives = 3;
        counter = 0;
        initEvents();
    }

    private void initEvents() {
        for (Button btn : model.getButtons()) {
            btn.setOnAction(_ -> handle(btn));
        }
        model.getView().getSubmitBtn().setOnAction(_ -> submit());
    }

    // Klick auf einen Fakt: nur Auswahl umschalten, noch keine Auswertung
    private void handle(Button btn) {
        model.toggle(btn);
        if (model.isSelected(btn)) {
            model.getView().markSelected(btn);
        } else {
            model.getView().unmark(btn);
        }
        model.getView().getSubmitBtn().setDisable(!model.canSubmit());
    }

    // Klick auf Submit: die vier gewählten Fakten auswerten
    private void submit() {
        if (!model.canSubmit()) {
            return;
        }
        FactsGameModel.SubmitResult result = model.submit();

        if (result.correct()) {
            for (Button b : model.getSelectedButtons()) {
                b.setVisible(false);
            }
            model.reset();
            model.getView().getSubmitBtn().setDisable(true);

            if (util.LanguageManager.getLanguage().equals("en")) {
                model.getView().getStatus().setText("Everything correct!");
            } else {
                model.getView().getStatus().setText("Alles richtig!");
            }

            counter++;
            if (counter == 4) {
                HighScoreManager.increaseStreak();
                SceneManager.switchView(GameMode.FACTS_GAME_STREAK);
            }
            return;
        }

        // falsch: ein Leben weniger, Auswahl zurücksetzen
        lives--;
        for (Button b : model.getSelectedButtons()) {
            model.getView().unmark(b);
        }
        model.reset();
        model.getView().getSubmitBtn().setDisable(true);
        model.getView().getStatus().setText(errorMessage(result.mistakes(), lives));

        if (lives == 0) {
            SceneManager.switchView(GameMode.MAIN_MENU);
        }
    }

    private String errorMessage(int mistakes, int livesLeft) {
        if (util.LanguageManager.getLanguage().equals("en")) {
            return mistakes + (mistakes == 1 ? " mistake" : " mistakes") + " – you have "
                    + livesLeft + (livesLeft == 1 ? " life" : " lives") + " left";
        }
        return mistakes + (mistakes == 1 ? " Fehler" : " Fehler") + " – du hast noch "
                + livesLeft + " Leben übrig";
    }

    public FactsGameModel getModel() {
        return model;
    }
}