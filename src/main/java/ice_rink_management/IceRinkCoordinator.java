package ice_rink_management;

import tools.MovementStyle;
import model.Skater;
import clients_queue_management.SkatersQueue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

/**
 * Created by Maciek on 2017-01-14.
 */
public class IceRinkCoordinator extends TimerTask {

    private JPanel icePanel;

    public IceRinkCoordinator(JPanel icePanel){
        this.icePanel = icePanel;
    }

    public void run(){
        if(IceRinkRepo.getRepoSize() < IceRinkRepo.getRinkMaxSize()){
            final Skater skater = SkatersQueue.getClient();
            SkaterMoverExecutor.submitSkater(new Runnable() {
                public void run() {
                    //handle skater moving
                    icePanel.add(skater);
                    skater.startSkating();
                    IceRinkRepo.add(skater);
                    ActionListener actionListener = new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            int[] coordinates = MovementStyle.randomStyle(skater);
                            skater.setBounds(coordinates[0], coordinates[1], RinkRules.WIDTH, RinkRules.HEIGHT);
                            IceRinkValidator.validateSkaterPosition(skater);
                            if(skater.isTired() && inOutArea(skater)){
                                icePanel.remove(skater);
                                icePanel.revalidate();
                                icePanel.repaint();
                            }
                        }
                    };
                    new javax.swing.Timer(10, actionListener).start();
                }
            });
        }
    }

    private boolean inOutArea(Skater skater){
        if(skater.getYposition() <= 10){
            IceRinkRepo.removeSkater(skater);
            return true;
        }
        return false;
    }

}
