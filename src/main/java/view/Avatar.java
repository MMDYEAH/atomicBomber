package view;

import controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Avatar extends Application {
    @FXML
    private RadioButton defaultPlane;
    @FXML
    private RadioButton passengerPlane;
    @FXML
    private RadioButton warPlane;
    Image icon = new Image(getClass().getResourceAsStream("/icon.png"));



    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane =  fxmlLoader.load(LoginMenu.class.getResource("/avatar.fxml"));
        Scene avatarScene = new Scene(pane);
        stage.setScene(avatarScene);

        stage.getIcons().add(icon);

//        defaultPlane.setOnMouseClicked(mouseEvent -> {
//
//        });
        ColorAdjust colorStatus = new ColorAdjust();
        colorStatus.setSaturation(ApplicationController.saturate);
        stage.getScene().getRoot().setEffect(colorStatus);

        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
