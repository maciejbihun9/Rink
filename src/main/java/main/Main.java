package main;

import concurrentComponenets.ClientDemandCreator;
import concurrentComponenets.SkaterMover;
import icepanelbusiness.IceRinkFrame;

import java.util.Random;
import java.util.Timer;

/**
 * Created by Maciek on 2016-12-18.
 */
public class Main {

    public static void main(String[] args) {
        //run gui application
        IceRinkFrame iceRinkFrame = new IceRinkFrame();



        Random random = new Random();
        int arrivalTime = random.nextInt(1);

        //run client demand
        Timer clientDimendTimer = new Timer();
        clientDimendTimer.schedule(new ClientDemandCreator(), 1 * 1000, 1 * 1000);

        //

    }

}
