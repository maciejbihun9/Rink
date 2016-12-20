package tools;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Maciek on 2016-12-20.
 */
public class ComponentsCreator {

    public static JPanel createJPanel(int width, int height, LayoutManager panelLayout){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(panelLayout);
        //create space between panels
        jPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setComponentDimensions(jPanel, width, height);

        return jPanel;
    }

    /*
    Note that width and height won't work if we use layout in out panel or frame.
     */
    public static JTextArea createTextArea(String startText, int width, int height){
        JTextArea textArea = new JTextArea(startText);
        return textArea;
    }

    public static JButton createButton(String buttonName, int width, int height){
        JButton jButton = new JButton(buttonName);
        //jButton.setBounds(10, 10, width, height);
        setComponentDimensions(jButton, width, height);
        return jButton;
    }

    public static JLabel createJLabel(String labelName, int width, int height){
        JLabel jLabel = new JLabel(labelName);
        //jLabel.setBounds(10, 10, width, height);
        //setComponentDimensions(jLabel, width, height);
        return jLabel;
    }

    private static void setComponentDimensions(Component component, int width, int height){
        component.setPreferredSize(new Dimension(width, height));
        component.setMaximumSize(new Dimension(width, height));
        component.setMinimumSize(new Dimension(width, height));
    }

}
