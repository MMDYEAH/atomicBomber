package view;

import controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.User;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class PointChart extends Application {
    Image icon = new Image(getClass().getResourceAsStream("/icon.png"));
    @FXML
    Text one;
    @FXML
    Text two;
    @FXML
    Text three;
    @FXML
    Text four;
    @FXML
    Text five;
    @FXML
    Text six;
    @FXML
    Text seven;
    @FXML
    Text eight;
    @FXML
    Text nine;
    @FXML
    Text ten;

    public static ArrayList<Integer> killArrange = new ArrayList<>();
    public static ArrayList<String> killArrangeString = new ArrayList<>();


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = fxmlLoader.load(LoginMenu.class.getResource("/pointChart.fxml"));
        Scene pointChartScene = new Scene(pane);
        stage.setScene(pointChartScene);
        killArrangement();

        one = (Text) pointChartScene.lookup("#one");
        one.setText(killArrangeString.get(0));
        two = (Text) pointChartScene.lookup("#two");
        two.setText(killArrangeString.get(1));
        three = (Text) pointChartScene.lookup("#three");
        three.setText(killArrangeString.get(2));
        four = (Text) pointChartScene.lookup("#four");
        four.setText(killArrangeString.get(3));
        five = (Text) pointChartScene.lookup("#five");
        five.setText(killArrangeString.get(4));
        six = (Text) pointChartScene.lookup("#six");
        six.setText(killArrangeString.get(5));
        seven = (Text) pointChartScene.lookup("#seven");
        seven.setText(killArrangeString.get(6));
        eight = (Text) pointChartScene.lookup("#eight");
        eight.setText(killArrangeString.get(7));
        nine = (Text) pointChartScene.lookup("#nine");
        nine.setText(killArrangeString.get(8));
        ten = (Text) pointChartScene.lookup("#ten");
        ten.setText(killArrangeString.get(9));


        stage.getIcons().add(icon);
        ColorAdjust colorStatus = new ColorAdjust();
        colorStatus.setSaturation(ApplicationController.saturate);
        stage.getScene().getRoot().setEffect(colorStatus);
        stage.show();
    }

    private void killArrangement() {
    }

    public static void KillArrangement() {
        int max = 0;
        int i = 0;
        for (User user : User.users) {
            if (user.kill >= max) {
                max = user.kill;
                killArrange.set(i, max);
                killArrangeString.set(i, i + ": " + killArrange.get(i));
                i++;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
