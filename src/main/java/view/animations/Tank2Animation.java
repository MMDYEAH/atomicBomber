package view.animations;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Game;
import model.Plane;
import model.Tank;
import model.Tank2;

public class Tank2Animation extends Transition {public Plane plane;
    private final Game game;
    private final Pane pane;
    private final Tank2 tank;
    private double speed = Game.speed / 60;
    private final int duration = 100;

    public Tank2Animation(Game game, Pane pane, Tank2 Tank) {
        this.game = game;
        this.pane = pane;
        this.tank = Tank;
        this.setCycleDuration(Duration.millis(duration));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        double x = tank.getX() + speed;
        tank.setX(x);
    }
}
