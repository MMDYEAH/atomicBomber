package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.AtomShoot;
import view.animations.ShootingAnimation;

public class Atom extends Rectangle {
    AtomShoot shootingAnimation;

    public AtomShoot getShootingAnimation() {
        return shootingAnimation;
    }

    public final double WIDTH = 8;
    public final double HEIGHT = 10;

    public void setShootingAnimation(AtomShoot shootingAnimation) {
        this.shootingAnimation = shootingAnimation;
    }

    public Atom(Plane plane) {
        super(25, 34);
        setX(plane.getX() + plane.WIDTH / 2 - WIDTH / 2);
        setY(plane.getY() + 2);
        this.setFill(new ImagePattern(
                new Image(Missile.class.getResource("/atom.png").toExternalForm())));
    }
}
