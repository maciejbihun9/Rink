package concurrentComponenets;

import icepanelbusiness.IceRinkFrame;
import icepanelbusiness.IceRinkRepo;
import model.Skater;
import model.SkatersQueue;

import javax.swing.*;
import java.util.TimerTask;

/**
 * Created by Maciek on 2017-01-14.
 */
public class IceRinkCoordinator extends TimerTask {

    private JPanel icePanel;

    public IceRinkCoordinator(JPanel icePanel){
        this.icePanel = icePanel;
    }

    public void run() {
        if(IceRinkRepo.getRepoSize() < IceRinkRepo.ICE_RINK_SIZE){
            Skater queueSkater = null;
            try {
                queueSkater = SkatersQueue.getClient();
                if(queueSkater == null)
                    return;
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            IceRinkRepo.add(queueSkater);
            icePanel.add(queueSkater);
        }
    }

}
