package main;

import clients_queue_management.SkaterDemandCreator;
import ice_rink_management.IceRinkFrame;

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
        clientDemandTimer.schedule(new SkaterDemandCreator(), 1 * 250, 1 * 543);
    }

}
