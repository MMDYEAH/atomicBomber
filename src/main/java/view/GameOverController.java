package view;

import controller.ApplicationController;
import javafx.scene.input.MouseEvent;
import model.User;

public class GameOverController {
    public void goToLoginMenu() {
        try {
            LoginMenu loginMenu = new LoginMenu();
            loginMenu.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void reStartGame (MouseEvent mouseEvent) {
        try {
            new GameLauncher(User.getLogedInUser().getUsername()).start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
