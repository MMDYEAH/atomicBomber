package view;

import controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.spi.ResourceBundleControlProvider;

public class MainMenu extends Application {
    Image icon = new Image(getClass().getResourceAsStream("/icon.png"));
    public SplitPane splitPane;
    @FXML
    public AnchorPane anchorPane;
    @FXML
    Text Text;


    private MainMenuController mainMenuController;
    public void startGame (MouseEvent mouseEvent){
        try {
                new GameLauncher(User.getLogedInUser().getUsername()).start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = fxmlLoader.load(LoginMenu.class.getResource("/mainMenu.fxml"));


//        splitPane = (SplitPane) pane.lookup("#splitPane");
//        anchorPane = (AnchorPane) pane.lookup("#anchorPane");
//        username = (Label) splitPane.lookup("#username");
//        username.setText(User.getLogedInUser().getUsername());
        stage.getIcons().add(icon);
//        usernameLabel.setOnContextMenuRequested(contextMenuEvent -> {
//            usernameLabel.setText(User.getLogedInUser().getUsername());
//        });
        Scene mainMenuScene = new Scene(pane);

        Text = (Text) mainMenuScene.lookup("#Text");
        Text.setText(User.getLogedInUser().getUsername());
        stage.setScene(mainMenuScene);

        ColorAdjust colorStatus = new ColorAdjust();
        colorStatus.setSaturation(ApplicationController.saturate);
        stage.getScene().getRoot().setEffect(colorStatus);
        stage.show();
        mainMenuController = new MainMenuController();
        System.out.println(User.getLogedInUser().getUsername());
    }
//    public void goToLoginMenu() {
//        mainMenuController.goToLoginMenu();
//    }
//
//    public void goToProfile() {
//        mainMenuController.goToProfile();
//    }
//
//    public void goToAvatar() {
//        mainMenuController.goToAvatar();
//    }
//
//    public void goToSetting() {
//        mainMenuController.goToSetting();
//    }
//
//
//
//
//    public void goToPointChart() {
//        mainMenuController.goToPointChart();
//    }

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

    public void goToMainMenu() throws Exception {
        MainMenu mainMenu = new MainMenu();
        mainMenu.start(ApplicationController.getStage());
    }


    public void goToPointChart() {
        try {
            PointChart pointChart = new PointChart();
            pointChart.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
