package view;

import controller.ApplicationController;

public class AvatarController {
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
}
