package model;

import exceptions.BadConditionValueException;
import main.*;
import tools.RoundedBorder;

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

    private final int skaterId;

    //Condition must be between 1 - 10. Lower value is better.
    private int condition;

    public Skater(int condition, Color color) {
        super(counter + "");
        this.condition = condition;
        this.skaterId = counter++;
        Random random = new Random();
        int rand = random.nextInt(3);
        int[] skaterStartingPoint = getSkaterStartingPoint(rand);
        skaterDirection = selectSkaterDirection(rand);
        int[] skaterInitialMove = SkaterStatics.generateSkaterMove(skaterDirection);
        moveX = skaterInitialMove[0];
        moveY = skaterInitialMove[1];
        setBackground(color);
        setBounds(skaterStartingPoint[0], skaterStartingPoint[1], SkaterStatics.WIDTH, SkaterStatics.HEIGHT);
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
        Rectangle skaterBounds = getBounds();
        return skaterBounds.x;
    }

    public synchronized int getYposition(){
        Rectangle skaterBounds = getBounds();
        return skaterBounds.y;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition){
        this.condition = condition;
    }

    public int getSkaterId(){
        return skaterId;
    }

    private int [] getSkaterStartingPoint(int randomStartingPoint){
        return SkaterStatics.startingPoints[randomStartingPoint];
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

    public SkaterDirection selectSkaterDirection(int startingPosition){
        Random random = new Random();
        int rand = random.nextInt(1);
        SkaterDirection skaterDirection = null;
       switch (startingPosition){
           case 0:
               if(rand == 1){
                   skaterDirection = SkaterDirection.BOTTOM_LEFT;
               } else {
                   skaterDirection = SkaterDirection.BOTTOM_RIGHT;
               }
               break;
           case 1:
               if(rand == 1){
                   skaterDirection = SkaterDirection.TOP_RIGHT;
               } else {
                   skaterDirection = SkaterDirection.BOTTOM_RIGHT;
               }
               break;
           case 2:
               if(rand == 1){
                   skaterDirection = SkaterDirection.TOP_LEFT;
               } else {
                   skaterDirection = SkaterDirection.BOTTOM_LEFT;
               }
               break;
           case 3:
               if(rand == 1){
                   skaterDirection = SkaterDirection.TOP_LEFT;
               } else {
                   skaterDirection = SkaterDirection.TOP_RIGHT;
               }
               break;
       }
       return skaterDirection;
    }

}
