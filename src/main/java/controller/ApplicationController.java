package controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.Game;
import view.SettingController;

import java.util.Random;

public class ApplicationController {
    public static final Random random = new Random();
    private static Stage stage;
    private static MediaPlayer mediaPlayer;
    public static Game game;
    public static int saturate = 0 ;
    public static int getSaturate() {
        return saturate;
    }

    public static void setSaturate(int saturate) {
        ApplicationController.saturate = saturate;
    }

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        ApplicationController.game = game;
    }

    public static void setStage(Stage stage) {
        ApplicationController.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        ApplicationController.mediaPlayer = mediaPlayer;
    }

}
