package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.animations.TankAnimation;
import view.animations.TruckAnimation;

public class Truck extends Rectangle {
    public final double WIDTH = 100;
    public final double HEIGHT = 100;
    public final Game game;
    public TruckAnimation tankAnimation;

    public Truck(Game game) {
        super(65, 55);
        this.game = game;
        setX(500);
        setY(540);
        setFill(new ImagePattern(new Image(Plane.class.getResource("/truck.png").toExternalForm())));
    }

    public TruckAnimation getTankAnimation() {
        return tankAnimation;
    }

    public void setTankAnimation(TruckAnimation tankAnimation) {
        this.tankAnimation = tankAnimation;
    }
}
