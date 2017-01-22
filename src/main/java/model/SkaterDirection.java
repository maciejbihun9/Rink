package model;

import java.util.Random;

/**
 * Created by Maciek on 2017-01-08.
 */
public enum SkaterDirection {
    TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, TOP;

    public static SkaterDirection selectSkaterDirection(int startingPosition){
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
