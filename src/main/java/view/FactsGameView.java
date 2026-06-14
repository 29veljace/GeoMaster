package view;

import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class FactsGameView {
    private final Button btn1;
    private final Button btn2;
    private final Button btn3;
    private final Button btn4;
    private final Button btn5;
    private final Button btn6;
    private final Button btn7;
    private final Button btn8;
    private final Button btn9;
    private final Button btn10;
    private final Button btn11;
    private final Button btn12;
    private final Button btn13;
    private final Button btn14;
    private final Button btn15;
    private final Button btn16;
    private final Label status;
    private final VBox vBox;
    private final HBox hBox;
    private final GridPane gridPane;

    public FactsGameView() {
        btn1 = new Button();
        btn2 = new Button();
        btn3 = new Button();
        btn4 = new Button();
        btn5 = new Button();
        btn6 = new Button();
        btn7 = new Button();
        btn8 = new Button();
        btn9 = new Button();
        btn10 = new Button();
        btn11 = new Button();
        btn12 = new Button();
        btn13 = new Button();
        btn14 = new Button();
        btn15 = new Button();
        btn16 = new Button();
        status = new Label("Wähle die zusammengehörigen Fakten aus");
        status.setId("factsGameStatus");
        gridPane = new GridPane();
        gridPane.add(btn1,0,0);
        gridPane.add(btn2,1,0);
        gridPane.add(btn3,2,0);
        gridPane.add(btn4,3,0);
        gridPane.add(btn5,0,1);
        gridPane.add(btn6,1,1);
        gridPane.add(btn7,2,1);
        gridPane.add(btn8,3,1);
        gridPane.add(btn9,0,2);
        gridPane.add(btn10,1,2);
        gridPane.add(btn11,2,2);
        gridPane.add(btn12,3,2);
        gridPane.add(btn13,0,3);
        gridPane.add(btn14,1,3);
        gridPane.add(btn15,2,3);
        gridPane.add(btn16,3,3);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        vBox = new VBox(status,gridPane);
        vBox.setSpacing(50);
        vBox.setAlignment(Pos.CENTER);
        hBox = new HBox(vBox);
        hBox.setAlignment(Pos.CENTER);
        hBox.setId("factsGamePane");
    }

    public void markiere(Button btn) {
        btn.setStyle("-fx-background-color: lightgreen;");
    }

    public void resetButtons() {
        btn1.setStyle("");
        btn2.setStyle("");
        btn3.setStyle("");
        btn4.setStyle("");
        btn5.setStyle("");
        btn6.setStyle("");
        btn7.setStyle("");
        btn8.setStyle("");
        btn9.setStyle("");
        btn10.setStyle("");
        btn11.setStyle("");
        btn12.setStyle("");
        btn13.setStyle("");
        btn14.setStyle("");
        btn15.setStyle("");
        btn16.setStyle("");
    }

    public Button getBtn1() {
        return btn1;
    }

    public Button getBtn2() {
        return btn2;
    }

    public Button getBtn3() {
        return btn3;
    }

    public Button getBtn4() {
        return btn4;
    }

    public Button getBtn5() {
        return btn5;
    }

    public Button getBtn6() {
        return btn6;
    }

    public Button getBtn7() {
        return btn7;
    }

    public Button getBtn8() {
        return btn8;
    }

    public Button getBtn9() {
        return btn9;
    }

    public Button getBtn10() {
        return btn10;
    }

    public Button getBtn11() {
        return btn11;
    }

    public Button getBtn12() {
        return btn12;
    }

    public Button getBtn13() {
        return btn13;
    }

    public Button getBtn14() {
        return btn14;
    }

    public Button getBtn15() {
        return btn15;
    }

    public Button getBtn16() {
        return btn16;
    }

    public Label getStatus() {
        return status;
    }

    public VBox getvBox() {
        return vBox;
    }

    public HBox gethBox() {
        return hBox;
    }

    public GridPane getGridPane() {
        return gridPane;
    }
}
