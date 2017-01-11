package icepanelbusiness;

import concurrentComponenets.MovementStyle;
import exceptions.BadConditionValueException;
import model.Skater;
import model.SkaterStatics;
import tools.ColorPicker;

import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by Maciek on 2016-12-20.
 */
public class IceRinkFrame extends JFrame {

    private static final int ICE_RINK_SIZE = 15;

    private static List<Skater> skatersOnTheIce = new ArrayList<Skater>();

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

        ActionListener addSkaterListener = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                skatersOnTheIce.add(new Skater(6, ColorPicker.pickColor()));
            }
        };

        javax.swing.Timer skaterTimer = new javax.swing.Timer(1000, addSkaterListener);
        skaterTimer.start();

        for(final Skater skater : skatersOnTheIce){
            westPanel.add(skater);
            ActionListener listener = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    int[] coordinates = MovementStyle.randomStyle(skater);
                    //System.out.println("coordinates :" + coordinates[0] + " " + coordinates[1]);
                    skater.setBounds(coordinates[0], coordinates[1], SkaterStatics.WIDTH, SkaterStatics.HEIGHT);
                    IceRinkValidator.validateSkaterPosition(skater);
                    SkaterCrashHandler.handleSkatersCrashing(skater, skatersOnTheIce);
                    skatersOnTheIce.remove(skater);
                    /*Skater crashedSkater = SkaterCrashHandler.getCrashedSkater(skater, skatersOnTheIce);
                    if(crashedSkater != null){
                        System.out.println("crashed skaters : " + crashedSkater.getXposition() + " " + skater.getXposition());
                    }*/
                }
            };
            javax.swing.Timer timer = new javax.swing.Timer(skater.getCondition(), listener);
            timer.start();
        }

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

}
