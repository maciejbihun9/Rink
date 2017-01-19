package model;

import icepanelbusiness.IceRinkFrame;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * Created by Maciek on 2016-12-22.
 */
public class SkatersQueue {

    private static final int clientQueueSize = 15;

    private static LinkedList<Skater> clientQueue = new LinkedList<Skater>();

    private static final Logger logger = Logger.getLogger(SkatersQueue.class.getName());

    private static final Lock lock = new ReentrantLock();

    public static void addClient(Skater skater){
            if(clientQueue.size() >= clientQueueSize){
                logger.info("There is too much clients waiting");
            } else {
                clientQueue.add(skater);
                logger.info("New customer arrived!!!, the queue status is : " + clientQueue.size());
            }
    }

    public static Skater getClient() throws InterruptedException {
        synchronized (lock){
            if(clientQueue.size() == 0){
                logger.info("There is no clients waiting!!!");
                return null;
            } else {
                logger.info("Clients waiting : " + clientQueue.size());
                return clientQueue.poll();
            }
        }
    }

}
