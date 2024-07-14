package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.animations.PlaneAnimation;

public class Plane extends Rectangle {
//    PlaneAnimation planeAnimation;
//
//    public PlaneAnimation getPlaneAnimation() {
//        return planeAnimation;
//    }
//
//    public void setPlaneAnimation(PlaneAnimation planeAnimation) {
//        this.planeAnimation = planeAnimation;
//    }
    public PlaneAnimation planeAnimation;


    public PlaneAnimation getPlaneAnimation() {
        return planeAnimation;
    }

    public void setPlaneAnimation(PlaneAnimation planeAnimation) {
        this.planeAnimation = planeAnimation;
    }

    public final double WIDTH = 100;
    public final double HEIGHT = 100;
    public final Game game;
    
    public Plane(Game game) {
        super(65, 32);
        this.game = game;
        setX((game.WIDTH - WIDTH) / 2);
        setY(game.HEIGHT-700);
        setFill(new ImagePattern(new Image(Plane.class.getResource("/Picture1.png").toExternalForm() ,65 , 32 , false , false) ) );
    }
}
