package model;

import main.Skater;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Maciek on 2016-12-22.
 */
public class ClientQueue {

    private static LinkedList<Skater> clientQueue = new LinkedList<Skater>();

    private static final Lock lock = new ReentrantLock();

    public void addClient(Skater skater){
        synchronized(lock){
            clientQueue.add(skater);
            System.out.println("New customer arrived!!!, the queue status is : " + clientQueue.size());
        }
    }

    public Skater getClient(){
        synchronized (lock){
            System.out.println("Get client from the queue. Status is : " + clientQueue.size());
            return clientQueue.getFirst();
        }
    }

}
