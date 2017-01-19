package concurrentComponenets;

import model.Skater;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Maciek on 2017-01-04.
 */
public class MovementStyle {

    public static int [] rectangleStyle(JButton newButton){
        int [] coordinates = new int[2];
        Rectangle bounds = newButton.getBounds();
        int x = bounds.x;
        int y = bounds.y;
        if(bounds.x == 50 && bounds.y < 250){
            y = bounds.y + 1;
        } else if(bounds.y == 250 && bounds.x < 250){
            x = bounds.x + 1;
        } else if(bounds.x == 250 && bounds.y > 50){
            y = bounds.y - 1;
        } else if(bounds.x > 50 && bounds.y == 50) {
            x = bounds.x - 1;
        }
        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;
    }

    public static int [] triangleStyle(JButton newButton, int beginX, int beginY){
        boolean wayBack = false;
        int [] coordinates = new int[2];
        Rectangle bounds = newButton.getBounds();
        int x = bounds.x;
        int y = bounds.y;
        if((x > beginX + 100)){
            wayBack = true;
        } else if(y == beginY){
            wayBack = false;
        }
        if(wayBack == false){
            if(bounds.x < beginX + 50 && bounds.y < beginY + 25){
                x = bounds.x + 2;
                y = bounds.y + 1;
            } else if((bounds.x >= beginX + 50)){
                x = bounds.x + 2;
                y = bounds.y - 1;
            }
        } else if(wayBack) {
            if(bounds.x > beginX + 25 && bounds.y < beginY + 25){
                x = bounds.x - 2;
                y = bounds.y + 1;
            } else {
                x = bounds.x - 2;
                y = bounds.y - 1;
            }
        }

        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;
    }

    public static int [] randomStyle(Skater skater){
        int [] coordinates = new int [2];
        Rectangle skaterBounds = skater.getBounds();
        int x;
        int y;
        x = skaterBounds.x + skater.getMoveX();
        y = skaterBounds.y + skater.getMoveY();
        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;
    }

    private int [] generateRandomCoordinates(boolean up, boolean down, boolean right, boolean left){
        int [] coordinates = new int [2];
        int xStep = 0;
        int yStep = 0;
        if(up & right){
            xStep = ThreadLocalRandom.current().nextInt(0, 4);
            yStep = ThreadLocalRandom.current().nextInt(-4, 0);
        } else if(up & left){
            xStep = ThreadLocalRandom.current().nextInt(-4, 0);
            yStep = ThreadLocalRandom.current().nextInt(-4, 0);
        } else if(down & right){
            xStep = ThreadLocalRandom.current().nextInt(0, 4);
            yStep = ThreadLocalRandom.current().nextInt(0, 4);
        } else if(down & left){
            xStep = ThreadLocalRandom.current().nextInt(-4, 0);
            yStep = ThreadLocalRandom.current().nextInt(0, 4);
        }
        coordinates[0] = xStep;
        coordinates[1] = yStep;
        return coordinates;
    }


}
