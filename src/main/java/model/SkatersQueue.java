package model;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Maciek on 2016-12-22.
 */
public class SkatersQueue {

    private static final int clientQueueSize = 15;

    private static LinkedBlockingQueue<Skater> clientQueue = new LinkedBlockingQueue<Skater>();

    public static void addClient(Skater skater){
            if(clientQueue.size() >= clientQueueSize){
                System.out.println("There is too much clients waiting");
            } else {
                clientQueue.add(skater);
                System.out.println("New customer arrived!!!, the queue status is : " + clientQueue.size());
            }
    }

    public static Skater getClient() throws InterruptedException {
            System.out.println("Get client from the queue. Status is : " + clientQueue.size());
            return clientQueue.take();
    }

}
