package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.animations.MigAnimation;
import view.animations.TankAnimation;

public class Mig extends Rectangle {
    public final double WIDTH = 100;
    public final double HEIGHT = 100;
    public final Game game;
    public MigAnimation tankAnimation;

    public Mig(Game game) {
        super(105, 79);
        this.game = game;
        setX(0);
        setY(358);
        setFill(new ImagePattern(new Image(Plane.class.getResource("/mig.png").toExternalForm())));
    }

    public MigAnimation getTankAnimation() {
        return tankAnimation;
    }

    public void setTankAnimation(MigAnimation tankAnimation) {
        this.tankAnimation = tankAnimation;
    }

}
