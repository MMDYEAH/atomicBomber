package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.animations.ShootingAnimation;

public class Missile extends Rectangle{
    ShootingAnimation shootingAnimation;

    public ShootingAnimation getShootingAnimation() {
        return shootingAnimation;
    }

    public final double WIDTH = 8;
    public final double HEIGHT = 10;

    public void setShootingAnimation(ShootingAnimation shootingAnimation) {
        this.shootingAnimation = shootingAnimation;
    }

    public Missile(Plane plane) {
        super(8, 10);
        setX(plane.getX() + plane.WIDTH / 2 - WIDTH / 2);
        setY(plane.getY() + 2);
        this.setFill(new ImagePattern(
                new Image(Missile.class.getResource("/Images/missile.png").toExternalForm())));
    }
}
