package main;

import tools.ComponentsCreator;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Maciek on 2016-12-20.
 */
public class TestFrame {

    private JFrame iceRinkFrame;

    public TestFrame(){
        iceRinkFrame = new JFrame();
        iceRinkFrame.setLayout(new BorderLayout());
        iceRinkFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeElements();
        iceRinkFrame.setResizable(false);
        //iceRinkFrame.setSize(new Dimension(600, 600));
        iceRinkFrame.pack();
        iceRinkFrame.setVisible(true);
        //set frame location into center
        iceRinkFrame.setLocationRelativeTo(null);
        //initialize frame elements in frame
    }

    private void initializeElements(){

        JPanel northPanel = ComponentsCreator.createJPanel(100, 100, new GridLayout());
        northPanel.add(ComponentsCreator.createButton("NorthButton1", 30, 30));
        northPanel.add(ComponentsCreator.createButton("NorthButton2", 30, 30));
        northPanel.add(ComponentsCreator.createButton("NorthButton3", 30, 30));

        JPanel southPanel = ComponentsCreator.createJPanel(100, 100, new GridLayout());
        southPanel.add(ComponentsCreator.createButton("SouthButton1", 30, 30));
        southPanel.add(ComponentsCreator.createButton("SouthButton2", 30, 30));
        southPanel.add(ComponentsCreator.createButton("SouthButton3", 30, 30));

        JPanel eastPanel = ComponentsCreator.createJPanel(300, 100, new GridLayout(3,1));
        eastPanel.add(ComponentsCreator.createButton("EastButton1", 30, 30));
        eastPanel.add(ComponentsCreator.createButton("EastButton2", 30, 30));
        eastPanel.add(ComponentsCreator.createButton("EastButton3", 30, 30));

        JPanel westPanel = ComponentsCreator.createJPanel(100, 100, new GridLayout(3,1));
        westPanel.add(ComponentsCreator.createButton("WestButton1", 30, 30));
        westPanel.add(ComponentsCreator.createButton("WestButton2", 30, 30));
        westPanel.add(ComponentsCreator.createButton("WestButton3", 30, 30));

        //center panel operations
        JPanel centerPanel = ComponentsCreator.createJPanel(100, 100, new GridLayout());
        centerPanel.add(ComponentsCreator.createButton("center1", 100, 100));
        centerPanel.add(ComponentsCreator.createButton("center2", 100, 100));
        centerPanel.add(ComponentsCreator.createButton("center3", 100, 100));

        iceRinkFrame.add(centerPanel, BorderLayout.CENTER);
        iceRinkFrame.add(northPanel, BorderLayout.NORTH);
        iceRinkFrame.add(southPanel, BorderLayout.SOUTH);
        iceRinkFrame.add(eastPanel, BorderLayout.EAST);
        iceRinkFrame.add(westPanel, BorderLayout.WEST);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestFrame();
            }
        });

    }

}
