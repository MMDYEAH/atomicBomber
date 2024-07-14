package controller;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import model.Atom;
import model.Plane;
import model.Game;
import model.Missile;
import view.AtomShoot;
import view.animations.ShootingAnimation;

public class GameController {


    public static void moveLeft(Plane plane, double width) {
        double rotateDegree = ((plane.getRotate() % 360) + 360) % 360;
        if ((rotateDegree > 180 && rotateDegree <= 270) || (rotateDegree >= 270 && rotateDegree <= 360)) {
            plane.setRotate(rotateDegree - 15);
        }
        if ((rotateDegree <= 90 && rotateDegree >= 0) || (rotateDegree >= 90 && rotateDegree < 180)) {
            plane.setRotate(rotateDegree + 15);
        }
    }

    public static void moveRight(Plane plane, double width) {
        double rotateDegree = ((plane.getRotate() % 360) + 360) % 360;
        if ((rotateDegree >= 180 && rotateDegree <= 270) || (rotateDegree >= 270 && rotateDegree < 360)) {
            plane.setRotate(rotateDegree + 15);
        }
        if ((rotateDegree <= 90 && rotateDegree > 0) || (rotateDegree >= 90 && rotateDegree <= 180)) {
            plane.setRotate(rotateDegree - 15);
        }
    }

    public static void moveUp(Plane plane, double height) {
        double rotateDegree = ((plane.getRotate() % 360) + 360) % 360;
        if ((rotateDegree <= 90 && rotateDegree >= 0) || (rotateDegree > 270 && rotateDegree <= 360)) {
            plane.setRotate(rotateDegree - 15);
        }
        if ((rotateDegree >= 90 && rotateDegree <= 180) || (rotateDegree >= 180 && rotateDegree < 270)) {
            plane.setRotate(rotateDegree + 15);
        }
    }


    public static void moveDown(Plane plane, double height) {
        double rotateDegree = ((plane.getRotate() % 360) + 360) % 360;
        if ((rotateDegree < 90 && rotateDegree >= 0) || (rotateDegree >= 270 && rotateDegree <= 360)) {
            plane.setRotate(rotateDegree + 15);
        }
        if ((rotateDegree > 90 && rotateDegree <= 180) || (rotateDegree >= 180 && rotateDegree <= 270)) {
            plane.setRotate(rotateDegree - 15);
        }
    }

    public static void shoot(Pane pane, Plane plane, Game game) {
        Missile missile = new Missile(plane);
        ShootingAnimation shootingAnimation = new ShootingAnimation(pane, game, missile);
        missile.setShootingAnimation(shootingAnimation);
        int cannonIndex = pane.getChildren().indexOf(plane);
        pane.getChildren().add(missile);
//        game.missiles.getChildren().add(missile);
        game.animations.add(shootingAnimation);
        shootingAnimation.play();
    }
    public static void shootAtom(Pane pane, Plane plane, Game game) {
        Atom missile = new Atom(plane);
        AtomShoot shootingAnimation = new AtomShoot(pane, game, missile);
        missile.setShootingAnimation(shootingAnimation);
        int cannonIndex = pane.getChildren().indexOf(plane);
        pane.getChildren().add(missile);
//        game.missiles.getChildren().add(missile);
        game.animations.add(shootingAnimation);
        shootingAnimation.play();
    }


    public static void stopAnimations(Game game) {
        for (Transition animation : game.animations) {
            animation.stop();
        }
    }
    public static void playAnimations(Game game) {
        for (Transition animation : game.animations) {
            animation.play();
        }
    }

}
