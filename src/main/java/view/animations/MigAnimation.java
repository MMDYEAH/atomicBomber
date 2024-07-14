package view.animations;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Game;
import model.Mig;
import model.Plane;
import model.Tank;

public class MigAnimation extends Transition {
    public Plane plane;
    private final Game game;
    private final Pane pane;
    private final Mig tank;
    private double speed = Game.speed / 60;
    private final int duration = 100;

    public MigAnimation(Game game, Pane pane, Mig Tank) {
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
