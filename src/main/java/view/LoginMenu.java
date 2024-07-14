package view;

import controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import model.User;

import java.net.URISyntaxException;
import java.net.URL;

public class LoginMenu extends Application {
    int i =0;
    private Stage stage;
    private Scene loginScene;
    private Scene profileScene;
    Image icon = new Image(getClass().getResourceAsStream("/icon.png"));

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;



    @FXML
    protected void clickSound() {
        Media media = new Media(getClass().getResource("/buttonSound.mp3").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }

    public void login() {
        clickSound();
        //playClickSound();
        if (User.getUserByUsername(username.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطای ثبت نام");
            alert.setContentText("این حساب کاربری قبلا ثبت نشده است.");
            alert.setHeaderText("خطای عدم وجود حساب کاربری");
            alert.show();
        } else if (!password.getText().equals(User.getUserByUsername(username.getText()).getPassword())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطای ورود پسوورد");
            alert.setContentText("رمزعبور خود را صحیح وارد نکرده اید");
            alert.setHeaderText("عدم تطابق رمز عبور");
            alert.show();
        }
//        User.getUserByUsername(username.getText()).changeLoginStatus(User.getUserByUsername(username.getText()));
        User.setLoggedInUser(User.getUserByUsername(username.getText()));

    }

    public void register() {
        clickSound();
        if (User.getUserByUsername(username.getText()) != null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطای ثبت نام");
            alert.setContentText("این حساب کاربری قبلا ثبت شده است.");
            alert.setHeaderText("خطای وجود حساب کاربری از قبل");
            alert.show();
        } else {
            User user = new User(username.getText(), password.getText(), false);
            User.users.add(user);
        }

    }
        public void goToLoginMenu () {
            clickSound();
            //playClickSound();
            try {
                LoginMenu loginMenu = new LoginMenu();
                loginMenu.start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void goToProfile () {
            clickSound();
            //playClickSound();
            try {
                Profile profile = new Profile();
                profile.start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void goToAvatar () {
            //playClickSound();
            try {
                Avatar avatar = new Avatar();
                avatar.start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void goToSetting () {
            //playClickSound();
            try {
                Setting setting = new Setting();
                setting.start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void goToMainMenu () {
            //playClickSound();
            try {
                MainMenu mainMenu = new MainMenu();
                mainMenu.start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void goToPointChart () {
            //playClickSound();
            try {
                PointChart pointChart = new PointChart();
                pointChart.start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public void startGame (MouseEvent mouseEvent){
            try {
                if(User.getLogedInUser().getUsername() != null) {
                    new GameLauncher(User.getLogedInUser().getUsername()).start(ApplicationController.getStage());
                }else{
                    new GameLauncher("Guest" + i).start(ApplicationController.getStage());
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void LoginMenuController (MouseEvent mouseEvent){

        }


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = fxmlLoader.load(LoginMenu.class.getResource("/login.fxml"));
        Scene loginScene = new Scene(pane, 560, 400);
        stage.setScene(loginScene);

        stage.show();
        stage.getIcons().add(icon);
        onPlayMusic();
        stage.setTitle("Atomic Bomber");
        stage.setScene(loginScene);
        ColorAdjust colorStatus = new ColorAdjust();
        colorStatus.setSaturation(ApplicationController.saturate);
        stage.getScene().getRoot().setEffect(colorStatus);
        stage.show();
        stage.setMinWidth(560);
        stage.setMinHeight(400);
        stage.setMaxWidth(560);
        stage.setMaxHeight(400);
        ApplicationController.setStage(stage);


    }

    @FXML
    protected void onPlayMusic() {
        if (ApplicationController.getMediaPlayer() == null) {
            try {
                String fileName = getClass().getResource("/music.wav").toURI().toString();
                Media music = new Media(fileName);
                MediaPlayer player = new MediaPlayer(music);
                ApplicationController.setMediaPlayer(new MediaPlayer(music));
                ApplicationController.getMediaPlayer().play();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
