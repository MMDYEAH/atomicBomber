package model;

import javafx.animation.Transition;
import javafx.scene.Group;
import view.GameLauncher;

import java.util.ArrayList;

public class Game {

    public Plane plane;
    public Tree tree;
    public Camp camp;

    public Camp getCamp() {
        return camp;
    }

    public void setCamp(Camp camp) {
        this.camp = camp;
    }

    public Trench getTrench() {
        return trench;
    }

    public void setTrench(Trench trench) {
        this.trench = trench;
    }

    public Trench trench;

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public final ArrayList<Truck> trucks = new ArrayList<>();
    public final ArrayList<Tank> tanks = new ArrayList<>();
    public final ArrayList<Mig> migs = new ArrayList<>();
    public final ArrayList<Tank2> tanks2 = new ArrayList<>();

    public final Group missiles = new Group();
    public static double speed = 28;
    public final double WIDTH = 500;
    public final double HEIGHT = 800;
    public String username;
    public GameLauncher gameLauncher;
    public final ArrayList<Transition> animations = new ArrayList<>();
    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public double getWIDTH() {
        return WIDTH;
    }

    public double getHEIGHT() {
        return HEIGHT;
    }

    public Game(String username, GameLauncher gameLauncher) {
        this.username = username;
        this.gameLauncher = gameLauncher;
    }
    public void removeTree() {
        this.tree = null;
    }

    public void removeCamp() {
        this.camp = null;
    }

    public void removeTrench() {
        this.trench = null;
    }
}
