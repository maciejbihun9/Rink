package model;

import ice_rink_management.IceRinkRepo;
import ice_rink_management.RinkRules;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Maciek on 2016-12-22.
 */
public class Skater extends JButton {

    private SkaterDirection skaterDirection;

    private int moveX = 0;

    private int moveY = 0;

    private static int counter = 0;

    private long skaterTimeOnIce;

    private boolean exitPathSelected = false;

    //Condition must be between 1 - 10. Lower value is better.
    private int condition;

    public Skater(int condition, Color color) {
        super(counter++ + "");
        this.condition = condition;
        Random random = new Random();
        int rand = random.nextInt(3);
        int[] skaterStartingPoint = getSkaterStartingPoint(rand);
        skaterDirection = SkaterDirection.selectSkaterDirection(rand);
        int[] skaterInitialMove = RinkRules.generateSkaterMove(skaterDirection, this);
        moveX = skaterInitialMove[0];
        moveY = skaterInitialMove[1];
        setBackground(color);
        setBounds(skaterStartingPoint[0], skaterStartingPoint[1], RinkRules.WIDTH, RinkRules.HEIGHT);
    }

    @Override
    public Rectangle getBounds() {
        return super.getBounds();
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
    }

    public synchronized int getXposition(){
        return getBounds().x;
    }

    public synchronized int getYposition(){
        return getBounds().y;
    }

    public void startSkating(){
        skaterTimeOnIce = System.currentTimeMillis();
    }

    public boolean isTired(){
        //if skater time expired
        return System.currentTimeMillis() - skaterTimeOnIce > condition * 1000F;
    }

    private int [] getSkaterStartingPoint(int randomStartingPoint){
        return RinkRules.startingPoints[randomStartingPoint];
    }

    public void setExitPath(){
        exitPathSelected = true;
    }

    public boolean isExitPathSelected(){
        return exitPathSelected;
    }

    public int getMoveX() {
        return moveX;
    }

    public void setMoveX(int moveX) {
        this.moveX = moveX;
    }

    public int getMoveY() {
        return moveY;
    }

    public void setMoveY(int moveY) {
        this.moveY = moveY;
    }

}
