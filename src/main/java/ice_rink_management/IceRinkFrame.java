package ice_rink_management;

import ice_rink_management.IceRinkCoordinator;
import tools.ComponentsCreator;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Maciek on 2016-12-20.
 */
public class IceRinkFrame extends JFrame {

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

        //HANDLE ADDING NEW SKATERS ON THE ICE
        java.util.Timer iceRinkCoordinatorTimer = new java.util.Timer();
        iceRinkCoordinatorTimer.schedule(new IceRinkCoordinator(westPanel), 33, 667);

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
