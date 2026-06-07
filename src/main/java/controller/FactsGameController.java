package controller;


import javafx.scene.control.Button;
import model.FactsGameModel;
import model.GameMode;
import util.SceneManager;
import view.FactsGameView;


public class FactsGameController {
    // controller für das spiel mit den fakten
    private final FactsGameModel model;
    private final FactsGameView view;
    private int leben;

    public FactsGameController(FactsGameModel model,FactsGameView view) {
        this.view = view;
        this.model = model;
        leben = 3;
        initEvents();
}

private void initEvents() {
    view.getBtn1().setOnAction(e -> handle(view.getBtn1()));
    view.getBtn2().setOnAction(e -> handle(view.getBtn2()));
    view.getBtn3().setOnAction(e -> handle(view.getBtn3()));
    view.getBtn4().setOnAction(e -> handle(view.getBtn4()));
    view.getBtn5().setOnAction(e -> handle(view.getBtn5()));
    view.getBtn6().setOnAction(e -> handle(view.getBtn6()));
    view.getBtn7().setOnAction(e -> handle(view.getBtn7()));
    view.getBtn8().setOnAction(e -> handle(view.getBtn8()));
    view.getBtn9().setOnAction(e -> handle(view.getBtn9()));
    view.getBtn10().setOnAction(e -> handle(view.getBtn10()));
    view.getBtn11().setOnAction(e -> handle(view.getBtn11()));
    view.getBtn12().setOnAction(e -> handle(view.getBtn12()));
    view.getBtn13().setOnAction(e -> handle(view.getBtn13()));
    view.getBtn14().setOnAction(e -> handle(view.getBtn14()));
    view.getBtn15().setOnAction(e -> handle(view.getBtn15()));
    view.getBtn16().setOnAction(e -> handle(view.getBtn16()));
}

private void handle(Button btn) {
    String wert = btn.getText();
    boolean richtig = model.auswählen(wert);
    // markieren
    view.markiere(btn);
    // falsch
    if (!richtig) {
        view.getStatus().setText("Falsch!");
        model.reset();
        view.resetButtons();
        leben--;
        try {
            wait(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        view.getStatus().setText("Du hast noch " + leben + " Leben übrig");
        if(leben == 0){
            SceneManager.switchView(GameMode.GAME_OVER);
        }
        return;
    }

    // alles richtig
    if (model.allesRichtig()) {
        view.getStatus().setText("Alles richtig!");
        try {
            wait(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SceneManager.switchView(GameMode.MAIN_MENU);
    }
}
}
