package ice_rink_management;

import model.Skater;
import model.SkaterDirection;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Maciek on 2017-01-08.
 */
public class RinkRules {

    public static final int WIDTH = 50;

    public static final int HEIGHT = 50;

    public static final int [][] startingPoints = new int [][]{
            {300, 20},//top
            {20, 300},//left
            {480, 300},//right
            {300, 580}//bottom
    };

    public static int [] generateSkaterMove(SkaterDirection skaterDirection, Skater skater){
        int [] skaterMoveValues = new int[2];
        int maxValue = 5;
        int minValue = 1;
        if(skaterDirection == SkaterDirection.BOTTOM_LEFT){
            skaterMoveValues[0] = ThreadLocalRandom.current().nextInt(-maxValue, minValue);
            skaterMoveValues[1] = ThreadLocalRandom.current().nextInt(minValue, maxValue);
        } else if(skaterDirection == SkaterDirection.BOTTOM_RIGHT){
            skaterMoveValues[0] = ThreadLocalRandom.current().nextInt(minValue, maxValue);
            skaterMoveValues[1] = ThreadLocalRandom.current().nextInt(minValue, maxValue);
        } else if(skaterDirection == SkaterDirection.TOP_LEFT){
            skaterMoveValues[0] = ThreadLocalRandom.current().nextInt(-maxValue, minValue);
            skaterMoveValues[1] = ThreadLocalRandom.current().nextInt(-maxValue, minValue);
        } else if(skaterDirection == SkaterDirection.TOP_RIGHT){
            skaterMoveValues[0] = ThreadLocalRandom.current().nextInt(minValue, maxValue);
            skaterMoveValues[1] = ThreadLocalRandom.current().nextInt(-maxValue, minValue);
        } else if(skaterDirection == SkaterDirection.TOP){
            int xTop = 300;
            skaterMoveValues[0] = (xTop - skater.getXposition()) / 100;
            skaterMoveValues[1] = -skater.getYposition() / 100;
        }
        return skaterMoveValues;
    }
}
