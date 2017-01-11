package icepanelbusiness;

import model.Skater;

import java.util.List;

/**
 * Created by Maciek on 2017-01-10.
 */
public class SkaterCrashHandler {

    public static Skater getCrashedSkater(Skater movingSkater, List<Skater> observerSkaters){
        //moving skater parameters
        int movingSkaterX = movingSkater.getXposition();
        int movingSkaterY = movingSkater.getYposition();
        for(Skater observerSkater : observerSkaters){
            //skip moving skater in observerlist
            if(observerSkater.equals(movingSkater))
                continue;
            //observer skater parameters
            int observerSkaterX = observerSkater.getXposition();
            int observerSkaterY = observerSkater.getYposition();

            if(Math.abs(movingSkaterX - observerSkaterX) < 10 & Math.abs(movingSkaterY - observerSkaterY) < 10){
                return observerSkater;
            }
        }
        return null;
    }

    public static void handleSkatersCrashing(Skater movingSkater, List<Skater> observerSkaters){
        Skater crashedSkater = getCrashedSkater(movingSkater, observerSkaters);
        if(crashedSkater != null){
            System.out.println(movingSkater.getXposition() + " " + crashedSkater.getXposition());
            movingSkater.setCondition(20);
            crashedSkater.setCondition(20);
        } else {

        }
    }

}
