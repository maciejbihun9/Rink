package concurrentComponenets;

import exceptions.BadConditionValueException;
import model.Skater;
import personel.Receptionist;
import tools.ColorPicker;

import java.awt.*;
import java.util.Random;
import java.util.TimerTask;

/**
 * Generates random client demand on ice panel skating.
 */
public class SkaterDemandCreator extends TimerTask {


    public void run() {
        Receptionist.getReceptionist().addClientToSkaterQueue(createClientDemand());
    }

    private Skater createClientDemand() {
        //generate random skater preferences
        Random random = new Random();
        int condition =  1 + random.nextInt(10);
        return new Skater(condition, ColorPicker.pickColor());
    }


}
