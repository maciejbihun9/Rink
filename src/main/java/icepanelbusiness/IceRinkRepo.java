package icepanelbusiness;

import concurrentComponenets.MovementStyle;
import jdk.nashorn.internal.ir.annotations.Immutable;
import model.Skater;
import model.SkaterStatics;
import model.SkatersQueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
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
            skatersOnTheIce.add(skater);
            iceRinkLogger.info("New skater on the ice arrived. The status is : " + skatersOnTheIce.size());
        }
    }

    public static void moveSkaters(){
        synchronized (lock){
            Iterator<Skater> skatersIterator = skatersOnTheIce.iterator();
            while(skatersIterator.hasNext()){
                Skater nextSkater = skatersIterator.next();
                int[] coordinates = MovementStyle.randomStyle(nextSkater);
                nextSkater.setBounds(coordinates[0], coordinates[1], SkaterStatics.WIDTH, SkaterStatics.HEIGHT);
                IceRinkValidator.validateSkaterPosition(nextSkater);
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

    public static void removeSubList(List<Skater> skatersToRemove) {
        synchronized (lock) {
            Iterator<Skater> iterator = skatersOnTheIce.iterator();
            while (iterator.hasNext()) {
                Skater nextSkater = iterator.next();
                if(nextSkater.equals(skatersToRemove.get(0)))
                    iterator.remove();
                if(nextSkater.equals(skatersToRemove.get(1)))
                    iterator.remove();
            }
        }

    }

}
