package view;

import controller.ApplicationController;
import controller.GameController;
import javafx.scene.input.MouseEvent;
import model.Game;
import model.User;
import view.Setting;

public class PauseMenuController {
    public static Game game;


    public void changeMusicStatus(MouseEvent mouseEvent) {
        if (Setting.getMusicStatus() == true) {
            Setting.setMusicStatus(false);
            ApplicationController.getMediaPlayer().stop();
            System.out.println(Setting.getMusicStatus());
        } else {
            Setting.setMusicStatus(true);
            ApplicationController.getMediaPlayer().play();
            System.out.println(Setting.getMusicStatus());
        }
    }

    public void resumeGame(MouseEvent mouseEvent) throws Exception {
        GameLauncher.pauseRestartPosition=true;
        GameController.playAnimations(ApplicationController.getGame());
        GameLauncher gameLauncher = new GameLauncher(User.getLogedInUser().getUsername());
        try {
            gameLauncher.start(ApplicationController.getStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
