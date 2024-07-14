package view.animations;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import model.Game;
import model.Plane;

public class PlaneExplosion extends Transition {
    private final Game game;
    private final Plane plane;
    private final Pane pane;

    public PlaneExplosion(Game game, Plane plane, Pane pane) {
        this.game = game;
        this.plane = plane;
        this.pane = pane;
    }

    @Override
    protected void interpolate(double v) {
        int number = 1;
        if (0 <= v && v <= 0.33) number = 1;
        else if (0.33 < v && v <= 0.66) number = 2;
        else if (0.66 < v && v <= 1) number = 3;


        game.getPlane().setFill(new ImagePattern(new Image(
                PlaneExplosion.class.getResource("/Images/meteorCollapse" + number + ".png").toExternalForm(), 112, 76, false, false)));
        Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }

//    private void planeCollision(Plane plane) {
//        this.stop();
//        FadeTransition fadeTransition = new FadeTransition();
//        fadeTransition.setNode(tank);
//        fadeTransition.setDuration(Duration.millis(1000));
//        fadeTransition.setFromValue(1);
//        fadeTransition.setToValue(0.01);
//        fadeTransition.setOnFinished(actionEvent -> pane.getChildren().remove(tank));
//        fadeTransition.play();
//
//
//
//
//        tank.setOnKeyPressed(keyEvent -> {
//        });
//    }
}
