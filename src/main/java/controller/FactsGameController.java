package controller;


import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import model.FactsGameModel;
import model.GameMode;
import util.SceneManager;
import view.FactsGameView;

import java.util.List;


public class FactsGameController {
    // controller für das spiel mit den fakten
    private final FactsGameModel model;
    private final FactsGameView view;
    private int leben;
    private int counter;

    public FactsGameController(FactsGameModel model,FactsGameView view) {
        this.view = view;
        this.model = model;
        leben = 3;
        counter = 0;
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
        boolean richtig;
        if(btn.getText().isBlank()){
            ImageView wert = (ImageView) btn.getGraphic();
             richtig = model.auswaehlen(wert);
        }
        else {
            String wert = btn.getText();
             richtig = model.auswaehlen(wert);
        }

    view.markiere(btn);
    if (!richtig) {
        view.getStatus().setText("Falsch!");
        model.reset();
        view.resetButtons();
        leben--;
        view.getStatus().setText("Du hast noch " + leben + " Leben übrig");
        if(leben == 0){
            SceneManager.switchView(GameMode.GAME_OVER);
        }
        return;
    }

    if (model.allesRichtig()) {
        view.getStatus().setText("Alles richtig!");
        List<Button> buttonListList = view.getGridPane().getChildren().stream().filter(node -> node instanceof Button).map(node -> (Button) node).filter(button -> button.getStyleClass().contains("-fx-background-color: lightgreen")).filter(button -> button.isVisible()).toList();
        for(int i = 0;i < buttonListList.size();i++){
            buttonListList.get(i).setVisible(false);
        }
        counter++;
        if (counter == 4) {
            try {
                wait(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            SceneManager.switchView(GameMode.MAIN_MENU);
        }
    }
}

    public FactsGameModel getModel() {
        return model;
    }

    public FactsGameView getView() {
        return view;
    }
}
