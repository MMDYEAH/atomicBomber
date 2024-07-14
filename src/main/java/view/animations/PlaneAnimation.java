package view.animations;

import controller.ApplicationController;
import controller.GameController;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.*;
import view.GameOver;

public class PlaneAnimation extends Transition {
    private final Game game;
    private final Plane plane;
    private final Pane pane;
    private final int duration = 100;

    public PlaneAnimation(Game game, Plane plane, Pane pane) {
        this.game = game;
        this.plane = plane;
        this.pane = pane;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(duration));
    }

    public void move() {
        int speed = -2;
        double rotationRadian = Math.toRadians(game.getPlane().getRotate());
        double x = speed * Math.cos(rotationRadian) + game.getPlane().getX();
        double y = speed * Math.sin(rotationRadian) + game.getPlane().getY();
        if (x <= -plane.WIDTH) {
            x = game.getWIDTH() + plane.WIDTH;
        } else if (x >= game.getWIDTH() + plane.WIDTH) {
            x = -plane.WIDTH;
        } else if (y >= 523) {
                PlaneAnimation planeAnimation = new PlaneAnimation(game, game.getPlane(), pane);
                game.animations.add(planeAnimation);
                planeAnimation.play();
        } else if (y <= 0) {
            y = game.getPlane().getY();
        }
        game.getPlane().setX(x);
        game.getPlane().setY(y);

    }


    @Override
    protected void interpolate(double v) {
        if (plane.getY()>=523 || checkCollisions()) {
            planeCollision(plane);
            int number = 1;
            if (0 <= v && v <= 0.33) number = 1;
            else if (0.33 < v && v <= 0.66) number = 2;
            else if (0.66 < v && v <= 1) number = 3;


            plane.setFill(new ImagePattern(new Image(
                    ShootingAnimation.class.getResource("/Images/meteorCollapse" + number + ".png").toExternalForm(),112,76,false,false)));
        }else {
            move();
        }
    }
    private boolean checkCollisions() {
        for (Truck truck : game.trucks) {
            if (game.getPlane().getBoundsInParent().intersects(truck.getBoundsInParent())) {
                return true;
            }
        }
        for (Tank tank : game.tanks) {
            if (game.getPlane().getBoundsInParent().intersects(tank.getBoundsInParent())) {
                return true;
            }
        }
        for (Mig mig : game.migs) {
            if (game.getPlane().getBoundsInParent().intersects(mig.getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }
    private void planeCollision(Plane plane) {


        Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        this.stop();
        GameController.stopAnimations(game);
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(plane);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.01);
        fadeTransition.play();

        try {
            GameOver gameOver = new GameOver();
            gameOver.start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            game.gameLauncher.createTank.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        plane.setOnKeyPressed(keyEvent -> {
        });

    }
}
