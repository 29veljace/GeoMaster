package controller;

import model.Country;
import model.GameMode;
import model.HigherLowerModel;
import util.SceneManager;
import view.HigherLowerView;

import java.util.Random;

public class HigherLowerController {
    // controller für das higher/lower spiel
    HigherLowerModel higherLowerModel;
    HigherLowerView higherLowerView;

    public HigherLowerController(HigherLowerView view, HigherLowerModel model){
        higherLowerModel = model;
        higherLowerView = view;
        buildQuestion();
    }
    public void buildQuestion(){
        higherLowerModel.connect();
        boolean b = true;
        Country c1 = higherLowerModel.getCountry();
        Country c2 = higherLowerModel.getCountry();
        while (b){
            b = false;
            if(c1.getId() == c2.getId()){
                c2 = higherLowerModel.getCountry();
                b = true;
            }
        }
        Random random = new Random();
        int i = random.nextInt(5);
        switch (i){
            case 0:
                higherLowerView.getLabel().setText("POPULATION");
                higherLowerView.getImageView1().setImage(c1.getFlag());
                higherLowerView.getImageView2().setImage(c2.getFlag());
                higherLowerView.getButton1().setText(c1.getName());
                higherLowerView.getButton2().setText(c2.getName());
                if(c1.getPopulation() > c2.getPopulation()){
                    higherLowerView.getButton1().setOnAction(actionEvent -> {
                    correctAnswer();
                    });
                    higherLowerView.getButton2().setOnAction(actionEvent -> {
                        wrongAnswer();
                    });
                }else {
                    higherLowerView.getButton1().setOnAction(actionEvent -> {
                        wrongAnswer();
                    });
                    higherLowerView.getButton2().setOnAction(actionEvent -> {
                        correctAnswer();
                    });
                }
            case 1:
                higherLowerView.getLabel().setText("AREA");
                higherLowerView.getImageView1().setImage(c1.getFlag());
                higherLowerView.getImageView2().setImage(c2.getFlag());
                higherLowerView.getButton1().setText(c1.getName());
                higherLowerView.getButton2().setText(c2.getName());
                if(c1.getArea() > c2.getArea()){
                    higherLowerView.getButton1().setOnAction(actionEvent -> {
                        correctAnswer();
                    });
                    higherLowerView.getButton2().setOnAction(actionEvent -> {
                        wrongAnswer();
                    });
                }else {
                    higherLowerView.getButton1().setOnAction(actionEvent -> {
                        wrongAnswer();
                    });
                    higherLowerView.getButton2().setOnAction(actionEvent -> {
                        correctAnswer();
                    });
                }
            case 2:
                higherLowerView.getLabel().setText("AVERAGE HEIGHT");
                higherLowerView.getImageView1().setImage(c1.getFlag());
                higherLowerView.getImageView2().setImage(c2.getFlag());
                higherLowerView.getButton1().setText(c1.getName());
                higherLowerView.getButton2().setText(c2.getName());
                if(c1.getAvgHeight() > c2.getAvgHeight()){
                    higherLowerView.getButton1().setOnAction(actionEvent -> {
                        correctAnswer();
                    });
                    higherLowerView.getButton2().setOnAction(actionEvent -> {
                        wrongAnswer();
                    });
                }else {
                    higherLowerView.getButton1().setOnAction(actionEvent -> {
                        wrongAnswer();
                    });
                    higherLowerView.getButton2().setOnAction(actionEvent -> {
                        correctAnswer();
                    });
                }
            case 3:
                higherLowerView.getLabel().setText("BIP");
                higherLowerView.getImageView1().setImage(c1.getFlag());
                higherLowerView.getImageView2().setImage(c2.getFlag());
                higherLowerView.getButton1().setText(c1.getName());
                higherLowerView.getButton2().setText(c2.getName());
                if(c1.getBip() > c2.getBip()){
                    higherLowerView.getButton1().setOnAction(actionEvent -> {
                        correctAnswer();
                    });
                    higherLowerView.getButton2().setOnAction(actionEvent -> {
                        wrongAnswer();
                    });
                }else {
                    higherLowerView.getButton1().setOnAction(actionEvent -> {
                        wrongAnswer();
                    });
                    higherLowerView.getButton2().setOnAction(actionEvent -> {
                        correctAnswer();
                    });
                }
            case 4:
                higherLowerView.getLabel().setText("AVERAGE TEMPERATURE");
                higherLowerView.getImageView1().setImage(c1.getFlag());
                higherLowerView.getImageView2().setImage(c2.getFlag());
                higherLowerView.getButton1().setText(c1.getName());
                higherLowerView.getButton2().setText(c2.getName());
                if(c1.getAvgTemperature() > c2.getAvgTemperature()){
                    higherLowerView.getButton1().setOnAction(actionEvent -> {
                        correctAnswer();
                    });
                    higherLowerView.getButton2().setOnAction(actionEvent -> {
                        wrongAnswer();
                    });
                }else {
                    higherLowerView.getButton1().setOnAction(actionEvent -> {
                        wrongAnswer();
                    });
                    higherLowerView.getButton2().setOnAction(actionEvent -> {
                        correctAnswer();
                    });
                }
        }
    }
    public void correctAnswer(){
        buildQuestion();
    }

    public void wrongAnswer(){
        SceneManager.switchView(GameMode.GAME_OVER);
    }
}
