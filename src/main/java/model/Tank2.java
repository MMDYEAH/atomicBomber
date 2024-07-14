package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.animations.Tank2Animation;
import view.animations.TankAnimation;

public class Tank2 extends Rectangle {
    public final double WIDTH = 100;
    public final double HEIGHT = 100;
    public final Game game;
    public Tank2Animation tankAnimation;

    public Tank2(Game game) {
        super(65, 55);
        this.game = game;
        setX(0);
        setY(540);
        setFill(new ImagePattern(new Image(Plane.class.getResource("/tank2.png").toExternalForm())));

    }

    public Tank2Animation getTankAnimation() {
        return tankAnimation;
    }

    public void setTankAnimation(Tank2Animation tankAnimation) {
        this.tankAnimation = tankAnimation;
    }
}
