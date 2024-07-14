package view;

import controller.ApplicationController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import model.User;

public class SettingController {
    @FXML
    Button gray;
    @FXML
    Button color;

    static AnchorPane anchorPane;

    @FXML
    private CheckBox easy;
    @FXML
    private CheckBox medium;
    @FXML
    private CheckBox hard;
    public static boolean colorStatus = true;

    // TODO: 5/22/2024 rangi kardan null mide???/
//    @FXML
//    public static void setBlackAndWhiteStyle(Pane pane){
//        SettingController.pane.setStyle("-fx-background-color: #FFFFFF;-fx-text-fill: #000000");
//        colorStatus=false;
//    }
//    @FXML
//    public static void setColorStyle(Pane pane){
//        SettingController.pane.setStyle("");
//        colorStatus=true;
//    }


    public void chooseLevel() {
        easy.setOnMouseClicked(mouseEvent -> User.getLogedInUser().setLevel(1));
        medium.setOnMouseClicked(mouseEvent -> User.getLogedInUser().setLevel(2));
        hard.setOnMouseClicked(mouseEvent -> User.getLogedInUser().setLevel(3));
    }

    public void goToLoginMenu() {
        try {
            LoginMenu loginMenu = new LoginMenu();
            loginMenu.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToProfile() {
        try {
            Profile profile = new Profile();
            profile.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToAvatar() {
        try {
            Avatar avatar = new Avatar();
            avatar.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToSetting() {
        try {
            Setting setting = new Setting();
            setting.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToMainMenu() {
        try {
            MainMenu mainMenu = new MainMenu();
            mainMenu.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToPointChart() {
        try {
            PointChart pointChart = new PointChart();
            pointChart.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeMusicStatus() {
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




//    public static ColorAdjust blackWhite() {
//        if (setWhiteScreen = true) {
//            setWhiteScreen = false;
//            ApplicationController.makeBlack();
//            ColorAdjust grayscale = new ColorAdjust();
//            grayscale.setSaturation(-1);
//            System.out.println("become black:::");
//        } else {
//            setWhiteScreen = true;
//            ApplicationController.makeColorful();
//
//            ColorAdjust colorScale = new ColorAdjust();
//            colorScale.setSaturation(1);
//        }
//
//        return null;
//    }


}
