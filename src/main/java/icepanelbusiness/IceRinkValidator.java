package icepanelbusiness;

import model.Skater;
import model.SkaterDirection;
import model.SkaterStatics;

/**
 * Created by Maciek on 2017-01-08.
 */
public class IceRinkValidator {

    private static final int iceRinkLeftBoundery = 0;

    private static final int iceRinkRightBoundery = 600;

    private static final int iceRinkTopBoundery = 0;

    private static final int iceRinkBottonBoundery = 600;

    public static void validateSkaterPosition(Skater skater){
        //crossed right boundery
        if(skater.getXposition() > iceRinkRightBoundery){
            SkaterDirection skaterDirection = skater.selectSkaterDirection(2);
            setSkaterMoves(skater, skaterDirection);
        } else if(skater.getXposition() < iceRinkLeftBoundery){
            SkaterDirection skaterDirection = skater.selectSkaterDirection(1);
            setSkaterMoves(skater, skaterDirection);
        } else if(skater.getYposition() > iceRinkBottonBoundery){
            SkaterDirection skaterDirection = skater.selectSkaterDirection(3);
            setSkaterMoves(skater, skaterDirection);
        } else if(skater.getYposition() < iceRinkTopBoundery){
            SkaterDirection skaterDirection = skater.selectSkaterDirection(0);
            setSkaterMoves(skater, skaterDirection);
        }
    }

    private static void setSkaterMoves(Skater skater, SkaterDirection skaterDirection){
        int[] skaterMoveValues = SkaterStatics.generateSkaterMove(skaterDirection);
        skater.setMoveX(skaterMoveValues[0]);
        skater.setMoveY(skaterMoveValues[1]);
    }

}
