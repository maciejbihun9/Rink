package main;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;


/**
 * Created by Maciek on 2016-12-20.
 */
public class IcePanel extends JPanel {

    //container for drawSurface
    private JLabel viewLabel;

    //surface for drawings
    private BufferedImage surface;

    private int width;

    private int height;

    public IcePanel(int width, int height, boolean containsBorders){
        this.height = height;
        this.width = width;
        surface = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        viewLabel = new JLabel(new ImageIcon(surface));
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        if(containsBorders){
            setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        }
        add(viewLabel);
    }

    public void drawOvals(){
        Graphics g = surface.getGraphics();
        g.setColor(Color.ORANGE);
        g.fillRect(0,0,width, height);
        g.setColor(Color.ORANGE);

        g.dispose();

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                drawRandomElement();
            }
        };
        Timer timer = new Timer(200, listener);
        timer.start();
    }

    private void drawRandomElement(){
        //bounderies
        int xBound = 10;
        int yBound = 10;

        int ovalWidth = 15;
        int ovalHeight = 15;
        Random random = new Random();
        int x = random.nextInt(width - xBound);
        int y = random.nextInt(height - yBound);
        System.out.println("x value : " + x);
        System.out.println("y value : " + y);

        drawOval(x, y, ovalWidth, ovalHeight);
    }

    private void drawOval(int x, int y, int width, int height){
        Graphics graphics = surface.getGraphics();
        graphics.setColor(Color.black);
        graphics.fillOval(x, y, width, height);
        graphics.drawOval(x, y, width, height);
        graphics.dispose();
        viewLabel.repaint();
    }



}
