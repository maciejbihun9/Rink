package model;

import main.Skater;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Maciek on 2016-12-22.
 */
public class SkatersQueue {

    private static final int clientQueueSize = 15;

    private static LinkedList<Skater> clientQueue = new LinkedList<Skater>();

    private static final Lock lock = new ReentrantLock();

    public static void addClient(Skater skater){
        synchronized(lock){
            if(clientQueue.size() >= clientQueueSize){
                System.out.println("There is too much clients waiting");
            } else {
                clientQueue.add(skater);
                System.out.println("New customer arrived!!!, the queue status is : " + clientQueue.size());
            }
        }
    }

    public static Skater getClient(){
        synchronized (lock){
            System.out.println("Get client from the queue. Status is : " + clientQueue.size());
            return clientQueue.getFirst();
        }
    }

}
