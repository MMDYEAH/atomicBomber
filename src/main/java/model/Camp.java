package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Camp extends Rectangle {

    public final Game game;

    public Camp(Game game) {
        super(65, 55);
        this.game = game;
        setX(270);
        setY(550);
        setFill(new ImagePattern(new Image(Plane.class.getResource("/camp.jpg").toExternalForm())));
    }
}
