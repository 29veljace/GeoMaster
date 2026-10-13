package controller;

import model.Country;
import model.GameMode;
import model.HigherLowerModel;
import util.GameSession;
import util.HighScoreManager;
import util.SceneManager;
import view.HigherLowerView;

import java.sql.SQLException;
import java.util.Random;

public class HigherLowerController {
    HigherLowerModel higherLowerModel;
    HigherLowerView higherLowerView;
    private int score;

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
        int i = random.nextInt(6);
        if (util.LanguageManager.getLanguage().equals("en")){
            switch (i){
                case 0:
                    higherLowerView.getLabel().setText("Which country has a larger population?");
                    higherLowerView.getImageView1().setImage(c1.getFlag());
                    higherLowerView.getImageView2().setImage(c2.getFlag());
                    higherLowerView.getButton1().setText(c1.getName_EN());
                    higherLowerView.getButton2().setText(c2.getName_EN());
                    if(c1.getPopulation() > c2.getPopulation()){
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> wrongAnswer());
                    }else if(c1.getPopulation() < c2.getPopulation()){
                        higherLowerView.getButton1().setOnAction(_ -> wrongAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }else{
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }
                    break;
                case 1:
                    higherLowerView.getLabel().setText("Which country is larger?");
                    higherLowerView.getImageView1().setImage(c1.getFlag());
                    higherLowerView.getImageView2().setImage(c2.getFlag());
                    higherLowerView.getButton1().setText(c1.getName_EN());
                    higherLowerView.getButton2().setText(c2.getName_EN());
                    if(c1.getArea() > c2.getArea()){
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> wrongAnswer());
                    }else if(c1.getArea() < c2.getArea()){
                        higherLowerView.getButton1().setOnAction(_ -> wrongAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }else{
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }
                    break;
                case 2:
                    higherLowerView.getLabel().setText("Which country has taller people?");
                    higherLowerView.getImageView1().setImage(c1.getFlag());
                    higherLowerView.getImageView2().setImage(c2.getFlag());
                    higherLowerView.getButton1().setText(c1.getName_EN());
                    higherLowerView.getButton2().setText(c2.getName_EN());
                    if(c1.getAvgHeight() > c2.getAvgHeight()){
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> wrongAnswer());
                    }else if(c1.getAvgHeight() < c2.getAvgHeight()){
                        higherLowerView.getButton1().setOnAction(_ -> wrongAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }else{
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }
                    break;
                case 3:
                    higherLowerView.getLabel().setText("Which country has a larger GDP?");
                    higherLowerView.getImageView1().setImage(c1.getFlag());
                    higherLowerView.getImageView2().setImage(c2.getFlag());
                    higherLowerView.getButton1().setText(c1.getName_EN());
                    higherLowerView.getButton2().setText(c2.getName_EN());
                    if(c1.getGdp() > c2.getGdp()){
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> wrongAnswer());
                    }else if(c1.getGdp() < c2.getGdp()){
                        higherLowerView.getButton1().setOnAction(_ -> wrongAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }else{
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }
                    break;
                case 4:
                    higherLowerView.getLabel().setText("Which country has the larger average temperature?");
                    higherLowerView.getImageView1().setImage(c1.getFlag());
                    higherLowerView.getImageView2().setImage(c2.getFlag());
                    higherLowerView.getButton1().setText(c1.getName_EN());
                    higherLowerView.getButton2().setText(c2.getName_EN());
                    if(c1.getAvgTemperature() > c2.getAvgTemperature()){
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> wrongAnswer());
                    }else if(c1.getAvgTemperature() < c2.getAvgTemperature()){
                        higherLowerView.getButton1().setOnAction(_ -> wrongAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }else{
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }
                    break;

                case 5:
                    higherLowerView.getLabel().setText("Which country has the larger GDP per capita?");
                    higherLowerView.getImageView1().setImage(c1.getFlag());
                    higherLowerView.getImageView2().setImage(c2.getFlag());
                    higherLowerView.getButton1().setText(c1.getName_EN());
                    higherLowerView.getButton2().setText(c2.getName_EN());
                    if(c1.getGdpc() > c2.getGdpc()){
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> wrongAnswer());
                    }else if(c1.getGdpc() < c2.getGdpc()){
                        higherLowerView.getButton1().setOnAction(_ -> wrongAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }else{
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }
            }
        }
        else{
            switch (i){
                case 0:
                    higherLowerView.getLabel().setText("Welches Land hat die größere Bevölkerung?");
                    higherLowerView.getImageView1().setImage(c1.getFlag());
                    higherLowerView.getImageView2().setImage(c2.getFlag());
                    higherLowerView.getButton1().setText(c1.getName_DE());
                    higherLowerView.getButton2().setText(c2.getName_DE());
                    if(c1.getPopulation() > c2.getPopulation()){
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> wrongAnswer());
                    }else if(c1.getPopulation() < c2.getPopulation()){
                        higherLowerView.getButton1().setOnAction(_ -> wrongAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }else{
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }
                    break;
                case 1:
                    higherLowerView.getLabel().setText("Welches Land ist größer?");
                    higherLowerView.getImageView1().setImage(c1.getFlag());
                    higherLowerView.getImageView2().setImage(c2.getFlag());
                    higherLowerView.getButton1().setText(c1.getName_DE());
                    higherLowerView.getButton2().setText(c2.getName_DE());
                    if(c1.getArea() > c2.getArea()){
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> wrongAnswer());
                    }else if(c1.getArea() < c2.getArea()){
                        higherLowerView.getButton1().setOnAction(_ -> wrongAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }else{
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }
                    break;
                case 2:
                    higherLowerView.getLabel().setText("Welches Land hat die größeren Menschen?");
                    higherLowerView.getImageView1().setImage(c1.getFlag());
                    higherLowerView.getImageView2().setImage(c2.getFlag());
                    higherLowerView.getButton1().setText(c1.getName_DE());
                    higherLowerView.getButton2().setText(c2.getName_DE());
                    if(c1.getAvgHeight() > c2.getAvgHeight()){
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> wrongAnswer());
                    }else if(c1.getAvgHeight() < c2.getAvgHeight()){
                        higherLowerView.getButton1().setOnAction(_ -> wrongAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }else{
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }
                    break;
                case 3:
                    higherLowerView.getLabel().setText("Welches Land hat das größere BIP?");
                    higherLowerView.getImageView1().setImage(c1.getFlag());
                    higherLowerView.getImageView2().setImage(c2.getFlag());
                    higherLowerView.getButton1().setText(c1.getName_DE());
                    higherLowerView.getButton2().setText(c2.getName_DE());
                    if(c1.getGdp() > c2.getGdp()){
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> wrongAnswer());
                    }else if(c1.getGdp() < c2.getGdp()){
                        higherLowerView.getButton1().setOnAction(_ -> wrongAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }else{
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }
                    break;
                case 4:
                    higherLowerView.getLabel().setText("Welches Land hat die höhere Durchschnittstemperatur?");
                    higherLowerView.getImageView1().setImage(c1.getFlag());
                    higherLowerView.getImageView2().setImage(c2.getFlag());
                    higherLowerView.getButton1().setText(c1.getName_DE());
                    higherLowerView.getButton2().setText(c2.getName_DE());
                    if(c1.getAvgTemperature() > c2.getAvgTemperature()){
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> wrongAnswer());
                    }else if(c1.getAvgTemperature() < c2.getAvgTemperature()){
                        higherLowerView.getButton1().setOnAction(_ -> wrongAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }else{
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }
                    break;

                case 5:
                    higherLowerView.getLabel().setText("Welches Land hat das größere BIP pro Kopf?");
                    higherLowerView.getImageView1().setImage(c1.getFlag());
                    higherLowerView.getImageView2().setImage(c2.getFlag());
                    higherLowerView.getButton1().setText(c1.getName_DE());
                    higherLowerView.getButton2().setText(c2.getName_DE());
                    if(c1.getGdpc() > c2.getGdpc()){
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> wrongAnswer());
                    }else if(c1.getGdpc() < c2.getGdpc()){
                        higherLowerView.getButton1().setOnAction(_ -> wrongAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }else{
                        higherLowerView.getButton1().setOnAction(_ -> correctAnswer());
                        higherLowerView.getButton2().setOnAction(_ -> correctAnswer());
                    }
            }
        }

        try {
            higherLowerModel.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void correctAnswer(){
        score++;
        higherLowerView.getScoreNumber().setText(Integer.toString(score));
        buildQuestion();
    }

    public void wrongAnswer(){
        GameSession.setCurrentGame(GameMode.HIGHER_LOWER, score);
        saveHighScore();
        SceneManager.switchView(GameMode.GAME_OVER);
    }

    public void saveHighScore() {
        HighScoreManager.saveHLHighScore(score);
        score = 0;
    }
}
