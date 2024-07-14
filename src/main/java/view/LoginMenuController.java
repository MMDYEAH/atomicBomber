package view;

import controller.ApplicationController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.User;


public class LoginMenuController {


    //    private AudioClip buttonClickSound;
//    public LoginMenuController(){
//        buttonClickSound = new AudioClip(getClass().getResource("/buttonSound.mp3").toString());
//    }
//    @FXML
//    private void playClickSound() {
//        buttonClickSound.play();
//    }
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;




//    @FXML
//    protected void clickSound() {
//        URL resource = getClass().getResource("/buttonSound.mp3");
//        Media clickSound = new Media(resource.toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(clickSound);
//        mediaPlayer.seek(mediaPlayer.getStartTime());
//        mediaPlayer.play();
//    }


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
        }
    }

    public void goToLoginMenu() {
        clickSound();
        //playClickSound();
        try {
            LoginMenu loginMenu = new LoginMenu();
            loginMenu.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToProfile() {
        clickSound();
        //playClickSound();
        try {
            Profile profile = new Profile();
            profile.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToAvatar() {
        //playClickSound();
        try {
            Avatar avatar = new Avatar();
            avatar.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToSetting() {
        //playClickSound();
        try {
            Setting setting = new Setting();
            setting.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToMainMenu() {
        //playClickSound();
        try {
            MainMenu mainMenu = new MainMenu();
            mainMenu.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToPointChart() {
        //playClickSound();
        try {
            PointChart pointChart = new PointChart();
            pointChart.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void startGame (MouseEvent mouseEvent) {
        try {
            new GameLauncher(username.getText()).start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LoginMenuController(MouseEvent mouseEvent) {

    }

    }


