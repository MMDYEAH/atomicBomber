package view;

import controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.User;

public class Setting extends Application {
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
    Image icon = new Image(getClass().getResourceAsStream("/icon.png"));

    private static boolean musicStatus = true;
    public static boolean getMusicStatus() {
        return musicStatus;
    }

    public static void setMusicStatus(boolean musicStatus) {
        Setting.musicStatus = musicStatus;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image backgroundImage = new Image("/OIG4 (1).jpg");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane =  fxmlLoader.load(LoginMenu.class.getResource("/setting.fxml"));

        pane.setBackground(new Background(background));


        Scene settingScene = new Scene(pane);
        stage.setScene(settingScene);
        stage.getIcons().add(icon);
        ColorAdjust colorStatus = new ColorAdjust();
        colorStatus.setSaturation(ApplicationController.saturate);
        stage.getScene().getRoot().setEffect(colorStatus);
        stage.show();
    }
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
        public static void main (String[]args){
            launch(args);
        }

    public void setGray(MouseEvent mouseEvent) {
        ApplicationController.saturate = -1;
    }

    public void setColorful(MouseEvent mouseEvent) {
        ApplicationController.saturate = 0;
    }
}
