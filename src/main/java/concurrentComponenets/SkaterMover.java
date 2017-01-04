package concurrentComponenets;

import icepanelbusiness.IcePanel;
import main.Skater;

import javax.swing.*;
import java.util.TimerTask;

/**
 * Created by Maciek on 2017-01-04.
 */
public class SkaterMover extends TimerTask {

    private IcePanel icePanel;

    private Skater skater;

    private JLabel iceLabel;

    public SkaterMover(Skater skater, IcePanel icePanel, JLabel iceLabel){
        this.icePanel = icePanel;
        this.skater = skater;
        this.iceLabel = iceLabel;
    }

    public void run() {
        moveSkater();
    }

    public void moveSkater(){
        iceLabel.revalidate();
        iceLabel.repaint();
        int skaterXCoordinate = skater.getSkaterXCoordinate();
        int skaterYCoordinate = skater.getSkaterYCoordinate();
        skater.update(skaterXCoordinate + 2, skaterYCoordinate + 2);
        icePanel.drawSkater(skater);
    }

}
