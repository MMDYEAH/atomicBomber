package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.animations.TankAnimation;

public class Tree extends Rectangle {
    public final Game game;

    public Tree(Game game) {
        super(65, 55);
        this.game = game;
        setX(390);
        setY(550);
        setFill(new ImagePattern(new Image(Plane.class.getResource("/tree.png").toExternalForm())));
    }

}
