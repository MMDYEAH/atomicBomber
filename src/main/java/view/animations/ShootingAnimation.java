package view.animations;

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

public class ShootingAnimation extends Transition {
    public static int uiOnce = 1;
    static int wave = 1;

    public static int getWave() {
        return wave;
    }

    public static void setWave() {
        wave++;
    }

    private final Game game;
    private final Pane pane;
    private final Missile missile;
    private final double speed = Game.speed / 7;
    private final int duration = 100;

    public ShootingAnimation(Pane pane, Game game, Missile missile) {
        this.pane = pane;
        this.game = game;
        this.missile = missile;
        this.setCycleDuration(Duration.millis(duration));
        this.setCycleCount(-1);
    }


    @Override
    protected void interpolate(double v) {
        if (uiOnce == 1) {
            game.gameLauncher.setupWaveUI(ShootingAnimation.getWave(), pane);
            uiOnce++;
        }
        double y = missile.getY() + ((missile.getY() / 39) * speed / 12);
        double x = missile.getX() + (speed / 14);
        game.gameLauncher.atomNum.setText(": " + User.getLogedInUser().atom);
        game.gameLauncher.clusterNum.setText(": " + User.getLogedInUser().clusters);
        game.gameLauncher.Wave.setText("you are in wave: " + wave);
        for (Truck child : game.trucks) {
            if (game.getPlane().getBoundsInParent().intersects(child.getBoundsInParent())) {
                Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);

                PlainCollision(game.getPlane());

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
                if (User.getLogedInUser().kill == 3) {
                    try {
                        setWave();
                        System.out.println(getWave());
                        WaveOnePassed waveOnePassed = new WaveOnePassed();
                        waveOnePassed.start(ApplicationController.getStage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (User.getLogedInUser().kill == 10) {
                    try {
                        setWave();
                        System.out.println(getWave());
                        Finish waveOnePassed = new Finish();
                        waveOnePassed.start(ApplicationController.getStage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                game.gameLauncher.killBoard.setText(game.username + "'s kills: " + User.getLogedInUser().kill);
                game.gameLauncher.atomNum.setText(": " + User.getLogedInUser().atom);
                game.gameLauncher.clusterNum.setText(": " + User.getLogedInUser().clusters);
                game.gameLauncher.Wave.setText("you are in wave: " + wave);

                ExplosionAnimation explosionAnimation = new ExplosionAnimation(this.missile, pane, child);
                game.animations.add(explosionAnimation);
                explosionAnimation.play();
                TruckCollision(child);
                missile.getShootingAnimation().stop();
                pane.getChildren().remove(missile);
                break;
            }
        }
        for (Tank child : game.tanks) {
            if (game.getPlane().getBoundsInParent().intersects(child.getBoundsInParent())) {
                Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);

                PlainCollision(game.getPlane());

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
                game.gameLauncher.atomNum.setText(": " + User.getLogedInUser().atom);
                game.gameLauncher.clusterNum.setText(": " + User.getLogedInUser().clusters);
                game.gameLauncher.Wave.setText("you are in wave: " + wave);

                if (User.getLogedInUser().kill == 3) {
                    try {
                        setWave();
                        WaveOnePassed waveOnePassed = new WaveOnePassed();
                        waveOnePassed.start(ApplicationController.getStage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (User.getLogedInUser().kill == 7) {
                    try {
                        setWave();
                        System.out.println(getWave());
                        WaveOnePassed waveOnePassed = new WaveOnePassed();
                        waveOnePassed.start(ApplicationController.getStage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (User.getLogedInUser().kill == 10) {
                    try {
                        setWave();
                        System.out.println(getWave());
                        Finish waveOnePassed = new Finish();
                        waveOnePassed.start(ApplicationController.getStage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                TankExplosion explosionAnimation = new TankExplosion(this.missile, pane, child);
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

                PlainCollision(game.getPlane());

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
                game.gameLauncher.atomNum.setText(": " + User.getLogedInUser().atom);
                game.gameLauncher.clusterNum.setText(": " + User.getLogedInUser().clusters);


                if (User.getLogedInUser().kill == 10) {
                    try {
                        setWave();
                        System.out.println(getWave());
                        Finish waveOnePassed = new Finish();
                        waveOnePassed.start(ApplicationController.getStage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                MigExplosion explosionAnimation = new MigExplosion(this.missile, pane, child);
                game.animations.add(explosionAnimation);
                explosionAnimation.play();
                MigCollision(child);
                missile.getShootingAnimation().stop();
                pane.getChildren().remove(missile);
                break;
            }
        }
        if (game.getTree() != null && missile.getBoundsInParent().intersects(game.getTree().getBoundsInParent())) {
            Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);

            TreeExplosion explosionAnimation = new TreeExplosion(this.missile, pane, game.getTree());
            game.animations.add(explosionAnimation);
            explosionAnimation.play();

            missile.getShootingAnimation().stop();
            pane.getChildren().remove(missile);

            // Delay the removal of the tree
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            delay.setOnFinished(event -> {
                treeCollision(game.getTree());
                pane.getChildren().remove(game.getTree());
                game.removeTree();
            });
            delay.play();
        }

        if (game.getCamp() != null && missile.getBoundsInParent().intersects(game.getCamp().getBoundsInParent())) {
            Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);

            CampExplosion explosionAnimation = new CampExplosion(this.missile, pane, game.getCamp());
            game.animations.add(explosionAnimation);
            explosionAnimation.play();

            missile.getShootingAnimation().stop();
            pane.getChildren().remove(missile);

            // Delay the removal of the camp
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            delay.setOnFinished(event -> {
                campCollision(game.getCamp());
                pane.getChildren().remove(game.getCamp());
                game.removeCamp();
            });
            delay.play();
        }
        if (game.getTrench() != null && missile.getBoundsInParent().intersects(game.getTrench().getBoundsInParent())) {
            Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);

            TrenchExplosion explosionAnimation = new TrenchExplosion(this.missile, pane, game.getTrench());
            game.animations.add(explosionAnimation);
            explosionAnimation.play();

            missile.getShootingAnimation().stop();
            pane.getChildren().remove(missile);

            // Delay the removal of the trench
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            delay.setOnFinished(event -> {
                trenchCollision(game.getTrench());
                pane.getChildren().remove(game.getTrench());
                game.removeTrench();
            });
            delay.play();
        }


        if (y >= 570) {
            pane.getChildren().remove(missile);
            this.stop();
        }

        missile.setX(x);
        missile.setY(y);
    }

    private void treeCollision(Tree truck) {
        this.stop();
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(truck);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.01);
        fadeTransition.setOnFinished(actionEvent -> pane.getChildren().remove(truck));
        fadeTransition.play();

        System.out.println(game.username + "'s kills: " + User.getLogedInUser().kill);
    }

    private void trenchCollision(Trench truck) {
        this.stop();
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(truck);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.01);
        fadeTransition.setOnFinished(actionEvent -> pane.getChildren().remove(truck));
        fadeTransition.play();

        System.out.println(game.username + "'s kills: " + User.getLogedInUser().kill);
    }

    private void campCollision(Camp truck) {
        this.stop();
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(truck);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.01);
        fadeTransition.setOnFinished(actionEvent -> pane.getChildren().remove(truck));
        fadeTransition.play();

        System.out.println(game.username + "'s kills: " + User.getLogedInUser().kill);
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
