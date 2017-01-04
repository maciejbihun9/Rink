package main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Maciek on 2016-12-22.
 */
public class Skater extends Component implements Box {

    private boolean onTheIce = false;

    private Rectangle bounds;

    private static int counter = 0;

    //FINAL FIELDS
    private final int skaterId;

    private final double condition;

    private final Color color;

    public Skater(double condition, Color color, Dimension size) {
        this.color = color;
        bounds = new Rectangle(new Point(0, 0), size);
        this.condition = condition;
        this.skaterId = counter++;
    }

    public double getCondition() {
        return condition;
    }

    public int getSkaterId(){
        return skaterId;
    }

    public synchronized void update(int xCoordinates, int yCoordinates) {
        bounds.x += xCoordinates;
        bounds.y += yCoordinates;
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fill(bounds);
    }

    public synchronized int getSkaterXCoordinate(){
        return this.bounds.x;
    }

    public synchronized int getSkaterYCoordinate(){
        return this.bounds.y;
    }

    public synchronized void moveOnTheIce(){
        this.onTheIce = true;
    }

    public synchronized void moveOffTheIce(){
        this.onTheIce = false;
    }

    public synchronized boolean skaterStatus(){
        return onTheIce;
    }
}
