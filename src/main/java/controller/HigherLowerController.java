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
                higherLowerView.getLabel().setText("population");
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
        }
    }
    public void correctAnswer(){
        buildQuestion();
    }

    public void wrongAnswer(){
        SceneManager.switchView(GameMode.GAME_OVER);
    }
}
