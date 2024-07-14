package view.animations;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import model.Missile;
import model.Tank;

public class TankExplosion extends Transition {
    private final Missile missile;
    private final Tank Tank;
    private final Pane pane;

    public TankExplosion(Missile missile, Pane pane, Tank Tank) {
        this.missile = missile;
        this.pane = pane;
        this.Tank = Tank;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        int number = 1;
        if (0 <= v && v <= 0.33) number = 1;
        else if (0.33 < v && v <= 0.66) number = 2;
        else if (0.66 < v && v <= 1) number = 3;


        Tank.setFill(new ImagePattern(new Image(
                ShootingAnimation.class.getResource("/Images/meteorCollapse" + number + ".png").toExternalForm(), 112, 76, false, false)));
    }
}
