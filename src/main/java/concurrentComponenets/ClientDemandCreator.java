package concurrentComponenets;

import main.Skater;
import personel.Receptionist;

import java.awt.*;
import java.util.Random;
import java.util.TimerTask;

/**
 * Created by Maciek on 2016-12-22.
 */
public class ClientDemandCreator extends TimerTask {

    public void run() {
        Receptionist.getReceptionist().addClientToSkaterQueue(createClientDemand());
    }

    /**
     * Generates random client demand on ice panel skating.
     */
    private Skater createClientDemand(){
        //generate random skater preferences
        Random random = new Random();
        double condition = 0 + (1 - 0) * random.nextDouble();
        return new Skater(condition, Color.GREEN, new Dimension(50, 50));
    }
}
