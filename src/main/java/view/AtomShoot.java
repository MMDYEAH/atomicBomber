package view;

import controller.ApplicationController;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import model.*;
import view.animations.*;

import controller.ApplicationController;
import controller.GameController;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.Transition;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import model.*;
import view.Finish;
import view.GameOver;
import view.WaveOnePassed;

public class AtomShoot extends Transition {

    private final Game game;
    private final Pane pane;
    private final Atom missile;
    private final double speed = Game.speed / 7;
    private final int duration = 100;

    public AtomShoot(Pane pane, Game game, Atom missile) {
        this.pane = pane;
        this.game = game;
        this.missile = missile;
        this.setCycleDuration(Duration.millis(duration));
        this.setCycleCount(-1);
    }


    @Override
    protected void interpolate(double v) {
        if (ShootingAnimation.uiOnce==1) {
            game.gameLauncher.setupWaveUI(ShootingAnimation.getWave(), pane);
            ShootingAnimation.uiOnce++;
        }
        double y = missile.getY() + ((missile.getY() / 39) * speed / 12);
        double x = missile.getX() + (speed / 14);

        game.gameLauncher.atomNum.setText(": "+User.getLogedInUser().atom);
        game.gameLauncher.clusterNum.setText(": " + User.getLogedInUser().clusters);
        game.gameLauncher.Wave.setText("you are in wave: " + ShootingAnimation.getWave());


        if (y>=500) {
            Media media3 = new Media(getClass().getResource("/Media/explosion.wav").toString());
            MediaPlayer mediaPlayer3 = new MediaPlayer(media3);
            mediaPlayer3.setAutoPlay(true);

            pane.getChildren().remove(game.getTree());
            missile.getShootingAnimation().stop();
            pane.getChildren().remove(missile);
            game.gameLauncher.atomNum.setText(": "+User.getLogedInUser().atom);
            game.gameLauncher.clusterNum.setText(": " + User.getLogedInUser().clusters);


                Media media4 = new Media(getClass().getResource("/Media/explosion.wav").toString());
                MediaPlayer mediaPlayer4 = new MediaPlayer(media4);
                mediaPlayer4.setAutoPlay(true);

                pane.getChildren().remove(game.getCamp());
                missile.getShootingAnimation().stop();
                pane.getChildren().remove(missile);

                Media media2 = new Media(getClass().getResource("/Media/explosion.wav").toString());
                MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
                mediaPlayer2.setAutoPlay(true);

                pane.getChildren().remove(game.getTrench());
                missile.getShootingAnimation().stop();
                pane.getChildren().remove(missile);



            for (Truck child : game.trucks) {
                Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);

                User.getLogedInUser().kill += 1;
                if (User.getLogedInUser().kill == 3) {
                    try {
                        ShootingAnimation.setWave();
                        System.out.println(ShootingAnimation.getWave());
                        WaveOnePassed waveOnePassed = new WaveOnePassed();
                        waveOnePassed.start(ApplicationController.getStage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                game.gameLauncher.killBoard.setText(game.username + "'s kills: " + User.getLogedInUser().kill);

                AtomExplosionAnimation explosionAnimation = new AtomExplosionAnimation(missile, pane, child);
                game.animations.add(explosionAnimation);
                explosionAnimation.play();
                TruckCollision(child);
                missile.getShootingAnimation().stop();
                pane.getChildren().remove(missile);
                break;

            }
            for (Tank child : game.tanks) {
                Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);

                game.gameLauncher.atomNum.setText(": "+User.getLogedInUser().atom);
                game.gameLauncher.clusterNum.setText(": " + User.getLogedInUser().clusters);

                mediaPlayer.setAutoPlay(true);

                User.getLogedInUser().kill += 1;
                game.gameLauncher.killBoard.setText(game.username + "'s kills: " + User.getLogedInUser().kill);
                game.gameLauncher.Wave.setText("you are in wave: " + ShootingAnimation.getWave());

                if (User.getLogedInUser().kill == 3) {
                    try {
                        ShootingAnimation.setWave();
                        WaveOnePassed waveOnePassed = new WaveOnePassed();
                        waveOnePassed.start(ApplicationController.getStage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (User.getLogedInUser().kill == 7) {
                    try {
                        ShootingAnimation.setWave();
                        System.out.println(ShootingAnimation.getWave());
                        WaveOnePassed waveOnePassed = new WaveOnePassed();
                        waveOnePassed.start(ApplicationController.getStage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                TankAtomExplosion explosionAnimation = new TankAtomExplosion(missile, pane, child);
                game.animations.add(explosionAnimation);
                explosionAnimation.play();
                tankCollision(child);
                missile.getShootingAnimation().stop();
                pane.getChildren().remove(missile);
                break;

            }
        }
        for (Mig child : game.migs) {
            if (game.getPlane().getBoundsInParent().intersects(child.getBoundsInParent())) {
                Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);
                game.gameLauncher.atomNum.setText(": "+User.getLogedInUser().atom);
                game.gameLauncher.clusterNum.setText(": " + User.getLogedInUser().clusters);
                game.gameLauncher.Wave.setText("you are in wave: " + ShootingAnimation.getWave());

                try {
                    GameOver gameOver = new GameOver();
                    gameOver.start(ApplicationController.getStage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (missile.getBoundsInParent().intersects(child.getBoundsInParent())) {

                Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);


                User.getLogedInUser().kill += 1;
                game.gameLauncher.killBoard.setText(game.username + "'s kills: " + User.getLogedInUser().kill);

                if (User.getLogedInUser().kill == 10) {
                    try {
                        ShootingAnimation.setWave();
                        System.out.println(ShootingAnimation.getWave());
                        Finish waveOnePassed = new Finish();
                        waveOnePassed.start(ApplicationController.getStage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                MigAtomExplosion explosionAnimation = new MigAtomExplosion(this.missile, pane, child);
                game.animations.add(explosionAnimation);
                explosionAnimation.play();
                MigCollision(child);
                missile.getShootingAnimation().stop();
                pane.getChildren().remove(missile);
                break;
            }
        }

        if (y >= 570) {
            pane.getChildren().remove(missile);
            this.stop();
        }

        missile.setX(x);
        missile.setY(y);
    }

    private void tankCollision(Tank truck) {
        game.tanks.remove(truck);
        this.stop();
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(truck);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.01);
        fadeTransition.setOnFinished(actionEvent -> pane.getChildren().remove(truck));
        fadeTransition.play();
        truck.setOnKeyPressed(keyEvent -> {
        });

        System.out.println(game.username + "'s kills: " + User.getLogedInUser().kill);
    }

    private void tank2Collision(Tank truck) {
        game.tanks2.remove(truck);
        this.stop();
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(truck);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.01);
        fadeTransition.setOnFinished(actionEvent -> pane.getChildren().remove(truck));
        fadeTransition.play();
        truck.setOnKeyPressed(keyEvent -> {
        });

        System.out.println(game.username + "'s kills: " + User.getLogedInUser().kill);
    }

    private void TruckCollision(Truck truck) {
        game.trucks.remove(truck);
        this.stop();
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(truck);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.01);
        fadeTransition.setOnFinished(actionEvent -> pane.getChildren().remove(truck));
        fadeTransition.play();


        truck.setOnKeyPressed(keyEvent -> {
        });

        System.out.println(game.username + "'s kills: " + User.getLogedInUser().kill);
    }

    private void PlainCollision(Plane truck) {
        this.stop();
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(truck);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.01);
        fadeTransition.setOnFinished(actionEvent -> pane.getChildren().remove(truck));
        fadeTransition.play();


        truck.setOnKeyPressed(keyEvent -> {
        });

        System.out.println(game.username + "'s kills: " + User.getLogedInUser().kill);
    }

    private void MigCollision(Mig truck) {
        game.migs.remove(truck);
        this.stop();
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(truck);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.01);
        fadeTransition.setOnFinished(actionEvent -> pane.getChildren().remove(truck));
        fadeTransition.play();


        truck.setOnKeyPressed(keyEvent -> {
        });

        System.out.println(game.username + "'s kills: " + User.getLogedInUser().kill);
    }

}