package controller;


import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import model.FactsGameModel;
import model.GameMode;
import util.GameSession;
import util.HighScoreManager;
import util.SceneManager;
import view.FactsGameView;

import java.util.List;


public class FactsGameController {
    // controller für das spiel mit den fakten
    private final FactsGameModel model;
    private int leben;
    private int counter;

    public FactsGameController(FactsGameModel model) {
        this.model = model;
        leben = 3;
        counter = 0;
        initEvents();
    }

    private void initEvents() {
        model.getView().getBtn1().setOnAction(e -> handle(model.getView().getBtn1()));
        model.getView().getBtn2().setOnAction(e -> handle(model.getView().getBtn2()));
        model.getView().getBtn3().setOnAction(e -> handle(model.getView().getBtn3()));
        model.getView().getBtn4().setOnAction(e -> handle(model.getView().getBtn4()));
        model.getView().getBtn5().setOnAction(e -> handle(model.getView().getBtn5()));
        model.getView().getBtn6().setOnAction(e -> handle(model.getView().getBtn6()));
        model.getView().getBtn7().setOnAction(e -> handle(model.getView().getBtn7()));
        model.getView().getBtn8().setOnAction(e -> handle(model.getView().getBtn8()));
        model.getView().getBtn9().setOnAction(e -> handle(model.getView().getBtn9()));
        model.getView().getBtn10().setOnAction(e -> handle(model.getView().getBtn10()));
        model.getView().getBtn11().setOnAction(e -> handle(model.getView().getBtn11()));
        model.getView().getBtn12().setOnAction(e -> handle(model.getView().getBtn12()));
        model.getView().getBtn13().setOnAction(e -> handle(model.getView().getBtn13()));
        model.getView().getBtn14().setOnAction(e -> handle(model.getView().getBtn14()));
        model.getView().getBtn15().setOnAction(e -> handle(model.getView().getBtn15()));
        model.getView().getBtn16().setOnAction(e -> handle(model.getView().getBtn16()));
    }

    private void handle(Button btn) {
        boolean richtig;
        if (btn.getText().isBlank()) {
            ImageView wert = (ImageView) btn.getGraphic();
            richtig = model.auswaehlen(wert);
        } else {
            String wert = btn.getText();
            richtig = model.auswaehlen(wert);
        }

        model.getView().markiere(btn);
        if (!richtig) {
            model.getView().getStatus().setText("Falsch!");
            model.reset();
            model.getView().resetButtons();
            leben--;
            model.getView().getStatus().setText("Du hast noch " + leben + " Leben übrig");
            if (leben == 0) {
                SceneManager.switchView(GameMode.MAIN_MENU);
            }
            return;
        }

        if (model.allesRichtig()) {
            model.getView().getStatus().setText("Alles richtig!");
            Button[] buttons = new Button[]{
                    model.getView().getBtn1(), model.getView().getBtn2(), model.getView().getBtn3(), model.getView().getBtn4(),
                    model.getView().getBtn5(), model.getView().getBtn6(), model.getView().getBtn7(), model.getView().getBtn8(),
                    model.getView().getBtn9(), model.getView().getBtn10(), model.getView().getBtn11(), model.getView().getBtn12(),
                    model.getView().getBtn13(), model.getView().getBtn14(), model.getView().getBtn15(), model.getView().getBtn16()
            };
            Object[] objects = model.getAusgewaehlt().toArray();
            for (int i = 0; i < 16; i++) {
                for (int a = 0; a < 4; a++) {
                    if (objects[a] == buttons[i].getText() || objects[a] == buttons[i].getGraphic()) {
                        buttons[i].setVisible(false);
                    }
                }
            }
            model.reset();
            counter++;
            if (counter == 4) {
                HighScoreManager.increaseStreak();
                SceneManager.switchView(GameMode.FACTS_GAME_STREAK);
            }
        }
    }

    public FactsGameModel getModel() {
        return model;
    }


}
