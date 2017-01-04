package icepanelbusiness;

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

        //Create drawing area
        IcePanel icePanel = new IcePanel(600, 600, true);
        icePanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        icePanel.letSkatersOnRink();

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
        add(icePanel, BorderLayout.WEST);
        add(widgetsPanel, BorderLayout.EAST);

    }

}
