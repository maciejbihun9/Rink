package concurrentComponenets;

import icepanelbusiness.IceRinkRepo;
import icepanelbusiness.SkaterCrashHandler;
import model.Skater;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
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
        List<Skater> copyOfSkatersOnTheIce = IceRinkRepo.getSkatersOnTheIce();

        Iterator<Skater> iterator = copyOfSkatersOnTheIce.iterator();
        while(iterator.hasNext()){
            Skater nextSkater = iterator.next();
            List<Skater> crashedSkaters = SkaterCrashHandler.handleSkatersCrashing(nextSkater, copyOfSkatersOnTheIce);
            if(crashedSkaters.isEmpty())
                continue;
            if(!skatersToRemove.contains(crashedSkaters.get(0))){
                skatersToRemove.add(crashedSkaters.get(0));
            }
            if(!skatersToRemove.contains(crashedSkaters.get(1))){
                skatersToRemove.add(crashedSkaters.get(1));
            }
        }
        if(!skatersToRemove.isEmpty()){
            IceRinkRepo.removeSubList(skatersToRemove);
            refreshIceRink(iceRinkPanel, skatersToRemove);
        }
    }

    private void refreshIceRink(JPanel westPanel, List<Skater> skatersToRemove){
        for(Skater skater : skatersToRemove){
            westPanel.remove(skater);
            try {
                showCrashFire(skater.getXposition(), skater.getYposition());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        westPanel.revalidate();
        westPanel.repaint();
    }

    private void showCrashFire(int xPosition, int yPosition) throws InterruptedException {
        ImageIcon image = new ImageIcon("C:\\Users\\Maciek\\workspace\\concurrency\\Rink\\src\\main\\resources\\bang.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(xPosition, yPosition, 50, 50);
        iceRinkPanel.add(imageLabel);
        Thread.sleep(3000);
        iceRinkPanel.remove(imageLabel);
        iceRinkPanel.revalidate();
        iceRinkPanel.repaint();
    }

}
