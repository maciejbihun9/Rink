package main;

import tools.ComponentsCreator;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;


/**
 * Created by Maciek on 2016-12-20.
 */
public class IceRinkFrame extends JFrame {

    public IceRinkFrame(){
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //initialize componenets
        initlizeComponenets();

        validate();
        repaint();

        setResizable(false);
        pack();
        setVisible(true);
        //center the window
        setLocationRelativeTo(null);
    }

    private void initlizeComponenets(){

        //Create drawing area
        IcePanel icePanel = new IcePanel(600, 600, true);
        icePanel.drawOvals();



        icePanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JPanel topPanel = ComponentsCreator.createJPanel(600, 50, new GridBagLayout());
        topPanel.add(ComponentsCreator.createJLabel("IceRinkGame", 600, 50));

        /*JPanel icePanel = ComponentsCreator.createJPanel(600, 600, new GridLayout());
        icePanel.add(ComponentsCreator.createTextArea("", 600, 600));*/

        //TO ALLOCATE ELEMENTS RELATIVE TO THE PARENT CONTAINER YOU MUST SET PANEL LAYOUT TO NULL!!!
        JPanel buttonPanel = ComponentsCreator.createJPanel(100, 200, new GridLayout(12,1));
        buttonPanel.add(ComponentsCreator.createButton("START", 70, 35));


        JPanel widgetsPanel = ComponentsCreator.createJPanel(100, 600, new GridLayout(1, 1));
        widgetsPanel.validate();
        widgetsPanel.repaint();

        widgetsPanel.add(buttonPanel);




        add(topPanel, BorderLayout.NORTH);
        add(icePanel, BorderLayout.WEST);
        add(widgetsPanel, BorderLayout.EAST);



    }

}
