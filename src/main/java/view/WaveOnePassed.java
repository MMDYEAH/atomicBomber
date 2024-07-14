package view;

import controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Game;
import model.User;

public class WaveOnePassed extends Application {
    @FXML
    Button button;
    Game game;

    Image icon = new Image(getClass().getResourceAsStream("/icon.png"));

    @Override
    public void start(Stage stage) throws Exception {
        game = ApplicationController.getGame();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = fxmlLoader.load(GameOver.class.getResource("/waveOnePassed.fxml"));
        Scene gameOverScene = new Scene(pane, 613, 418);
        stage.setScene(gameOverScene);
        stage.getIcons().add(icon);
        button = (Button) gameOverScene.lookup("#button");
        button.setOnMouseClicked(mouseEvent -> {
            reStartGame(game);
        });
        ColorAdjust colorStatus = new ColorAdjust();
        colorStatus.setSaturation(ApplicationController.saturate);
        stage.getScene().getRoot().setEffect(colorStatus);
        stage.show();
        stage.setMinWidth(613);
        stage.setMinHeight(418);
        stage.setMaxWidth(613);
        stage.setMaxHeight(418);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void reStartGame(Game game) {
        try {
            game.gameLauncher.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

