package ice_rink_management;

import model.Skater;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * Created by Maciek on 2017-01-14.
 */
public class IceRinkRepo {

    private static List<Skater> skatersOnTheIce = new ArrayList<Skater>();

    private static final Logger iceRinkLogger = Logger.getLogger(IceRinkRepo.class.getName());

    private static final Lock lock = new ReentrantLock();

    public static final int ICE_RINK_SIZE = 15;

    public static void add(Skater skater) {
        synchronized (lock) {
            if(skatersOnTheIce.size() < ICE_RINK_SIZE){
                skatersOnTheIce.add(skater);
                iceRinkLogger.info("New skater on the ice arrived. The status is : " + skatersOnTheIce.size());
            } else {
                iceRinkLogger.info("There is too much skaters on the ice.");
            }
        }
    }

    public static List<Skater> getSkatersOnTheIce(){
        synchronized (lock){
            return skatersOnTheIce;
        }
    }

    public static int getRepoSize() {
        synchronized (lock) {
            return skatersOnTheIce.size();
        }
    }

    public static void removeSkater(Skater skater){
        synchronized (lock){
            skatersOnTheIce.remove(skater);
        }
    }

    public static int getRinkMaxSize(){
        return ICE_RINK_SIZE;
    }


}
