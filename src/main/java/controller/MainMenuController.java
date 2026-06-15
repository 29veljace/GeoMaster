package controller;

import javafx.application.Platform;
import view.*;
import javafx.stage.Stage;
import model.*;
import util.*;


public class MainMenuController {
    private MainMenuView mainMenuView;
    private Stage stage;

    public MainMenuController(MainMenuView menuView, Stage stage) {
        mainMenuView = menuView;
        this.stage = stage;
        initEvents();
    }
    public void initEvents(){
        mainMenuView.exit.setOnMouseClicked(_ -> {
            Platform.exit();
            System.exit(0);
        });
        mainMenuView.getFlagGuessing().setOnAction(_ -> {
            SceneManager.switchView(GameMode.FLAG_GAME);
        });
        mainMenuView.getOutlineGuessing().setOnAction(_ -> {
            SceneManager.switchView(GameMode.OUTLINE_GAME);
        });
        mainMenuView.getFactsGame().setOnAction(_ -> {
            SceneManager.switchView(GameMode.FACTS_GAME);
        });
        mainMenuView.getCapitalGame().setOnAction(_ -> {
            SceneManager.switchView(GameMode.CAPITAL_GAME);
        });
        mainMenuView.getHigherLower().setOnAction(_ -> {
            SceneManager.switchView(GameMode.HIGHER_LOWER);
        });
    }
}