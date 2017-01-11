package concurrentComponenets;

import icepanelbusiness.IceRinkFrame;
import icepanelbusiness.SkaterCrashHandler;
import model.Skater;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by Maciek on 2017-01-11.
 */
public class SkaterCrashListener extends TimerTask {

    private JPanel iceRinkPanel;

    public SkaterCrashListener(JPanel iceRinkPanel){
        this.iceRinkPanel = iceRinkPanel;
    }

    public void run() {
        List<Skater> skatersToRemove = new ArrayList<Skater>();
        for(final Skater skater : IceRinkFrame.skatersOnTheIce){
            List<Skater> crashedSkaters = SkaterCrashHandler.handleSkatersCrashing(skater, IceRinkFrame.skatersOnTheIce);
            if(crashedSkaters.isEmpty())
                continue;
            if(!skatersToRemove.contains(crashedSkaters.get(0))){
                skatersToRemove.add(crashedSkaters.get(0));
            }
            if(!skatersToRemove.contains(crashedSkaters.get(1))){
                skatersToRemove.add(crashedSkaters.get(1));
            }
        }
        IceRinkFrame.skatersOnTheIce.removeAll(skatersToRemove);
        refreshIceRink(iceRinkPanel, skatersToRemove);
    }

    private void refreshIceRink(JPanel westPanel, List<Skater> skatersToRemove){
        for(Skater skater : skatersToRemove){
            westPanel.remove(skater);
        }
        westPanel.revalidate();
        westPanel.repaint();
    }

}
