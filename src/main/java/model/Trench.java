package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Trench extends Rectangle {
    public final Game game;

    public Trench(Game game) {
        super(65, 55);
        this.game = game;
        setX(150);
        setY(550);
        setFill(new ImagePattern(new Image(Plane.class.getResource("/trench.png").toExternalForm())));
    }
}
