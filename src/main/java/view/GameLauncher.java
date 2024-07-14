package view;

import controller.ApplicationController;
import controller.GameController;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;

import view.animations.*;

public class GameLauncher extends Application {

    public Text clusterNum;
    public Text atomNum;
    public final double WIDTH = 500;
    public final double HEIGHT = 800;
    public final Game game;
    public Pane pane;
    public Timeline createTruck;
    public Timeline createTank;
    public Timeline createMig;
    public Timeline createTank2;
    public Text Wave = new Text("you are on wave: " + 1);

    public Text killBoard;
    Tree tree;
    Camp camp;
    Trench trench;

    public GameLauncher(String username) {
        game = new Game(username, this);
        ApplicationController.setGame(game);
    }

    private boolean isPaused = false;
    public static boolean pauseRestartPosition = false;

    @Override
    public void start(Stage stage) throws Exception {
        Button pauseButton = new Button("pause");
        pane = new Pane(pauseButton);

        setupWaveUI(ShootingAnimation.getWave(), pane);

        if (ShootingAnimation.getWave() == 1) {


            pauseButton.setOnMouseClicked(mouseEvent -> showPauseMenu());
            stage.setMinWidth(500);
            stage.setMinHeight(800);
            stage.setMaxWidth(500);
            stage.setMaxHeight(800);
            setSize(pane);
            pane.setBackground(new Background(createBackgroundImage()));
            addTree(pane);
            addCamp(pane);
            addTrench(pane);
            createTank = new Timeline(new KeyFrame(Duration.seconds(5), actionEvent -> createTank()));
            createTank.setCycleCount(-1);
            createTank.play();
            createTruck = new Timeline(new KeyFrame(Duration.seconds(5), actionEvent -> createTruck()));
            createTruck.setCycleCount(-1);
            createTruck.play();
            pane.getChildren().add(createkillHbox());
            createPlane();
            pane.getChildren().add(game.getPlane());
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            game.getPlane().requestFocus();
            pauseButton.setLayoutX(130);

            ColorAdjust colorStatus = new ColorAdjust();
            colorStatus.setSaturation(ApplicationController.saturate);
            stage.getScene().getRoot().setEffect(colorStatus);
            stage.show();
            pauseRestartPosition = false;
        } else if (ShootingAnimation.getWave() == 2) {
            pauseButton.setOnMouseClicked(mouseEvent -> showPauseMenu());
            stage.setMinWidth(500);
            stage.setMinHeight(800);
            stage.setMaxWidth(500);
            stage.setMaxHeight(800);
            setSize(pane);
            pane.setBackground(new Background(createBackgroundImage()));
            addTree(pane);
            addTrench(pane);
            addCamp(pane);
            createTank = new Timeline(new KeyFrame(Duration.seconds(5), actionEvent -> createTank()));
            createTank.setCycleCount(-1);
            createTank.play();
//                createTruck = new Timeline(new KeyFrame(Duration.seconds(5), actionEvent -> createTruck()));
//                createTruck.setCycleCount(-1);
//                createTruck.play();
            pane.getChildren().add(createkillHbox());
            createPlane();
            pane.getChildren().add(game.getPlane());
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            game.getPlane().requestFocus();
            pauseButton.setLayoutX(130);

            ColorAdjust colorStatus = new ColorAdjust();
            colorStatus.setSaturation(ApplicationController.saturate);
            stage.getScene().getRoot().setEffect(colorStatus);
            stage.show();
            pauseRestartPosition = false;
        } else if (ShootingAnimation.getWave() == 3) {

            pauseButton.setOnMouseClicked(mouseEvent -> showPauseMenu());
            stage.setMinWidth(500);
            stage.setMinHeight(800);
            stage.setMaxWidth(500);
            stage.setMaxHeight(800);
            setSize(pane);
            pane.setBackground(new Background(createBackgroundImage()));

//                createTank = new Timeline(new KeyFrame(Duration.seconds(5), actionEvent -> createTank()));
//                createTank.setCycleCount(-1);
//                createTank.play();
            createMig = new Timeline(new KeyFrame(Duration.seconds(5), actionEvent -> createMig()));
            createMig.setCycleCount(-1);
            createMig.play();
            // Stop other enemy creation timelines
            if (createTank != null) createTank.stop();
            if (createTruck != null) createTruck.stop();
            pane.getChildren().add(createkillHbox());
            createPlane();
            pane.getChildren().add(game.getPlane());
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            game.getPlane().requestFocus();
            pauseButton.setLayoutX(130);

            ColorAdjust colorStatus = new ColorAdjust();
            colorStatus.setSaturation(ApplicationController.saturate);
            stage.getScene().getRoot().setEffect(colorStatus);
            stage.show();
            pauseRestartPosition = false;

            addTree(pane);
            addTrench(pane);
            addCamp(pane);
        }
    }

//    }

    public void addTree(Pane pane) {
        tree = new Tree(game);
        game.setTree(tree);
        pane.getChildren().add(tree);
    }

    public void addCamp(Pane pane) {
        camp = new Camp(game);
        game.setCamp(camp);
        pane.getChildren().add(camp);
    }

    public void addTrench(Pane pane) {
        trench = new Trench(game);
        game.setTrench(trench);
        pane.getChildren().add(trench);
    }

    private void showPauseMenu() {
        GameController.stopAnimations(game);
        goToPauseMenu();
    }

    public void goToPauseMenu() {
        try {
            PauseMenu pauseMenu = new PauseMenu();
            pauseMenu.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTank() {
        Tank tank = new Tank(game);
        game.tanks.add(tank);

        tank.setTankAnimation(new TankAnimation(game, pane, tank));
        game.animations.add(tank.getTankAnimation());
        tank.getTankAnimation().play();
        pane.getChildren().add(tank);
    }

    private void createTank2() {
        Tank2 tank = new Tank2(game);
        game.tanks2.add(tank);

        tank.setTankAnimation(new Tank2Animation(game, pane, tank));
        game.animations.add(tank.getTankAnimation());
        tank.getTankAnimation().play();
        pane.getChildren().add(tank);
    }

    private void createTruck() {
        Truck truck = new Truck(game);
        game.trucks.add(truck);

        truck.setTankAnimation(new TruckAnimation(game, pane, truck));
        game.animations.add(truck.getTankAnimation());
        truck.getTankAnimation().play();
        pane.getChildren().add(truck);
    }

    private void createMig() {
        Mig tank = new Mig(game);
        game.migs.add(tank);

        tank.setTankAnimation(new MigAnimation(game, pane, tank));
        game.animations.add(tank.getTankAnimation());
        tank.getTankAnimation().play();
        pane.getChildren().add(tank);
    }

    private void createPlane() {
        game.setPlane(new Plane(game));
        game.getPlane().setPlaneAnimation(new PlaneAnimation(game, game.getPlane(), pane));
        game.animations.add(game.getPlane().getPlaneAnimation());
        game.getPlane().getPlaneAnimation().play();
        game.getPlane().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.D) {
                GameController.moveLeft(game.getPlane(), HEIGHT);
            } else if (keyEvent.getCode() == KeyCode.W) {
                GameController.moveDown(game.getPlane(), HEIGHT);
            } else if (keyEvent.getCode() == KeyCode.S) {
                GameController.moveUp(game.getPlane(), HEIGHT);
            } else if (keyEvent.getCode() == KeyCode.A) {
                GameController.moveRight(game.getPlane(), WIDTH);
            } else if (keyEvent.getCode() == KeyCode.SPACE) {
                GameController.shoot(pane, game.getPlane(), game);
            } else if (keyEvent.getCode() == KeyCode.K) {
                if (User.getLogedInUser().clusters >= 1) {
                    User.getLogedInUser().clusters--;
                    System.out.println(User.getLogedInUser().clusters);
                    for (int i = 0; i < 4; i++) {
                        // Pause for 1 second (adjust duration as needed)
                        Timeline pause = new Timeline(new KeyFrame(Duration.millis(198), event -> {
                            GameController.shoot(pane, game.getPlane(), game);
                        }));
                        pause.setCycleCount(5);
                        pause.play();
                    }
                }
            } else if (keyEvent.getCode() == KeyCode.J) {
                if (User.getLogedInUser().atom >= 1) {
                    User.getLogedInUser().atom--;
                    System.out.println(User.getLogedInUser().atom);
                    GameController.shootAtom(pane, game.getPlane(), game);
                }
            } else if (keyEvent.getCode() == KeyCode.L) {
                User.getLogedInUser().clusters++;
            } else if (keyEvent.getCode() == KeyCode.P) {
                User.getLogedInUser().atom++;
            } else if (keyEvent.getCode() == KeyCode.O) {
                User.getLogedInUser().kill += 3;
            }
        });
    }

    private void setSize(Pane pane) {
        pane.setMinHeight(HEIGHT);
        pane.setMaxHeight(HEIGHT);
        pane.setMinWidth(WIDTH);
        pane.setMaxWidth(WIDTH);
    }

    private HBox createkillHbox() {
        HBox hBox = new HBox();
        killBoard = new Text(360, 50,
                game.username + "'s kill: 0");
        killBoard.setFill(Color.OLIVE);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(killBoard);
        hBox.setLayoutX(10);
        return hBox;
    }

    private void setBackground(Pane pane) {
        Image backgroundImage = new Image(GameLauncher.class.getResource("/Images/envirenement.png").toExternalForm());
        ImageView background = new ImageView(backgroundImage);
        background.setX((game.WIDTH / 2) - (backgroundImage.getWidth() / 2));
        pane.getChildren().add(background);
    }

    private BackgroundImage createBackgroundImage() {
        Image image = new Image(Game.class.getResource("/Images/envirenement.png").toExternalForm(), WIDTH, HEIGHT, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return backgroundImage;
    }

    public void setupWaveUI(int wave, Pane pane) {
        // Load the image
        String imagePath = "/cluster.jpg"; // Change this to the path of your image file
        Image image = new Image(getClass().getResource(imagePath).toExternalForm());
        ImageView imageView = new ImageView(image);
        pane.getChildren().add(imageView);
        imageView.setFitWidth(58);
        imageView.setFitHeight(58);
        imageView.setLayoutY(14);

        clusterNum = new Text();
        game.gameLauncher.clusterNum.setText(": " + User.getLogedInUser().clusters);
        VBox clus = new VBox(Wave, clusterNum);
        pane.getChildren().add(clus);
        clus.setLayoutY(14);
        clus.setLayoutX(68);

        // Load the image
        String imagePath2 = "/atom.png"; // Change this to the path of your image file
        Image image2 = new Image(getClass().getResource(imagePath2).toExternalForm());
        ImageView imageView2 = new ImageView(image2);
        pane.getChildren().add(imageView2);
        imageView2.setFitWidth(58);
        imageView2.setFitHeight(58);
        imageView2.setLayoutY(72);

        atomNum = new Text();
        atomNum.setText(": " + User.getLogedInUser().atom);
        VBox at = new VBox(atomNum);
        pane.getChildren().add(at);
        at.setLayoutY(70);
        at.setLayoutX(68);
        // ... rest of UI setup
    }
}
