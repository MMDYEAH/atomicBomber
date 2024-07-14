package view;

import controller.ApplicationController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.User;

public class ProfileController {
    public static User guest = new User("guest", null, true);

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

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField changeUsername;
    @FXML
    private PasswordField changePassword;

    public void removeAccount() {
        if (User.getUserByUsername(username.getText()) != null) {
            if (User.getUserByUsername(username.getText()).getPassword().equals(password.getText())) {
                User.removeUser(User.getUserByUsername(username.getText()));
            }
        }
    }

    public void logoutAccount() {
        User.setLoggedInUser(guest);
        System.out.println(".khgjgxfhjvk,mn./");
    }

    public void changeUsernameAndPassword() {
        if (User.getUserByUsername(username.getText()) != null) {
            if (User.getUserByUsername(username.getText()).getLogedInUser().getUsername().equals(username.getText())) {
                if (changeUsername.getText() != null && changeUsername.getText() != username.getText()) {
                    //User.getUserByUsername(username.getText()).getUsername() = changeUsername.getText();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("خطای تغییر نام کاربری");
                    alert.setContentText("این حساب کاربری قبلا همین نام را داشته است است.");
                    alert.setHeaderText("خطای اسم تکراری");
                    alert.show();
                }
                if (changePassword.getText() != null) {
                    //User.getUserByUsername(username.getText()).getPassword() = changePassword.getText();
                }
            }
        }
    }


    public void LoginMenuController(MouseEvent mouseEvent) {

    }
}
