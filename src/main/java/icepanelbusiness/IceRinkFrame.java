package icepanelbusiness;

import concurrentComponenets.MovementStyle;
import concurrentComponenets.SkaterCrashListener;
import exceptions.BadConditionValueException;
import model.Skater;
import model.SkaterStatics;
import model.SkatersQueue;
import tools.ColorPicker;

import java.util.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by Maciek on 2016-12-20.
 */
public class IceRinkFrame extends JFrame {

    private static final int ICE_RINK_SIZE = 15;

    public static List<Skater> skatersOnTheIce = new ArrayList<Skater>();

    private static Lock listLock = new ReentrantLock();

    public IceRinkFrame(){
        setLayout(new BorderLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeComponents();

        validate();

        repaint();

        setResizable(false);

        pack();

        setVisible(true);
        //center the window
        setLocationRelativeTo(null);
    }

    private void initializeComponents(){

        final JPanel westPanel = ComponentsCreator.createJPanel(600, 600, null);

        final Skater skater1 = new Skater(6, Color.GRAY);
        final Skater skater2 = new Skater(3, Color.RED);
        final Skater skater3 = new Skater(7, Color.GREEN);
        final Skater skater4 = new Skater(1, Color.YELLOW);

        skatersOnTheIce.add(skater1);
        skatersOnTheIce.add(skater2);
        skatersOnTheIce.add(skater3);
        skatersOnTheIce.add(skater4);

        westPanel.add(skater1);
        westPanel.add(skater2);
        westPanel.add(skater3);
        westPanel.add(skater4);

        //HANDLE ADDING SKATERS ON THE ICE RINK
        ActionListener addSkaterListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                synchronized (listLock){
                    if(skatersOnTheIce.size() < ICE_RINK_SIZE){
                        Skater queueSkater = SkatersQueue.getClient();
                        skatersOnTheIce.add(queueSkater);
                        westPanel.add(queueSkater);
                    }
                }
            }
        };
        javax.swing.Timer newSkaterTimer = new javax.swing.Timer(1000, addSkaterListener);
        newSkaterTimer.start();

        //HANDLE SKATER MOVEMENT HERE
        ActionListener moveSkaterListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                synchronized (listLock){
                    for(final Skater skater : skatersOnTheIce){
                        int[] coordinates = MovementStyle.randomStyle(skater);
                        //System.out.println("coordinates :" + coordinates[0] + " " + coordinates[1]);
                        skater.setBounds(coordinates[0], coordinates[1], SkaterStatics.WIDTH, SkaterStatics.HEIGHT);
                        IceRinkValidator.validateSkaterPosition(skater);
                    }
                }
            }
        };
        javax.swing.Timer moveSkaterTimer = new javax.swing.Timer(10, moveSkaterListener);
        moveSkaterTimer.start();

        java.util.Timer skaterCrashTimer = new java.util.Timer();
        SkaterCrashListener skaterCrashListener = new SkaterCrashListener(westPanel);
        skaterCrashTimer.schedule(skaterCrashListener, 1000, 10);

        //description panel
        JPanel topPanel = ComponentsCreator.createJPanel(600, 50, new GridBagLayout());
        topPanel.add(ComponentsCreator.createJLabel("IceRinkGame", 600, 50));

        //TO ALLOCATE ELEMENTS RELATIVE TO THE PARENT CONTAINER YOU MUST SET PANEL LAYOUT TO NULL!!!
        JPanel buttonPanel = ComponentsCreator.createJPanel(100, 200, new GridLayout(12,1));
        buttonPanel.add(ComponentsCreator.createButton("START", 70, 35));

        JPanel widgetsPanel = ComponentsCreator.createJPanel(100, 600, new GridLayout(1, 1));
        widgetsPanel.validate();
        widgetsPanel.repaint();
        widgetsPanel.add(buttonPanel);

        add(topPanel, BorderLayout.NORTH);
        add(westPanel, BorderLayout.WEST);
        add(widgetsPanel, BorderLayout.EAST);
    }

    private void refreshIceRink(JPanel westPanel, List<Skater> skatersToRemove){
        for(Skater skater : skatersToRemove){
            westPanel.remove(skater);
        }
        westPanel.revalidate();
        westPanel.repaint();
    }

}
