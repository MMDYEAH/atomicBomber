package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.GameLauncher;
import view.animations.ShootingAnimation;
import view.animations.TankAnimation;

public class Tank extends Rectangle {
    public final double WIDTH = 100;
    public final double HEIGHT = 100;
    public final Game game;
    public TankAnimation tankAnimation;

    public Tank(Game game) {
        super(65, 55);
        this.game = game;
        setX(0);
        setY(540);
        if (ShootingAnimation.getWave()==1) {
            setFill(new ImagePattern(new Image(Plane.class.getResource("/tank1.png").toExternalForm())));
        } else if (ShootingAnimation.getWave()==2) {
            setFill(new ImagePattern(new Image(Plane.class.getResource("/tank2.png").toExternalForm())));
        }
    }

    public TankAnimation getTankAnimation() {
        return tankAnimation;
    }

    public void setTankAnimation(TankAnimation tankAnimation) {
        this.tankAnimation = tankAnimation;
    }
}
