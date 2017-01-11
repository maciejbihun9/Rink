package main;

import concurrentComponenets.SkaterDemandCreator;
import icepanelbusiness.IceRinkFrame;

import java.util.Timer;

/**
 * Created by Maciek on 2016-12-18.
 */
public class Main {

    public static void main(String[] args) {

        //run gui application
        new IceRinkFrame();

        //run client demand
        Timer clientDemandTimer = new Timer();
        clientDemandTimer.schedule(new SkaterDemandCreator(), 1 * 1000, 1 * 1000);
    }

}
