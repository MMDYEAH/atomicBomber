package view;

import controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Profile extends Application {
    Image icon = new Image(getClass().getResourceAsStream("/icon.png"));

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane =  fxmlLoader.load(LoginMenu.class.getResource("/profile.fxml"));
        Scene profileScene = new Scene(pane);
        stage.setScene(profileScene);
        stage.getIcons().add(icon);
        ColorAdjust colorStatus = new ColorAdjust();
        colorStatus.setSaturation(ApplicationController.saturate);
        stage.getScene().getRoot().setEffect(colorStatus);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
