package icepanelbusiness;

import model.Skater;
import model.SkatersQueue;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by Maciek on 2016-12-20.
 */
public class IcePanel extends JPanel {

    private static final int iceRinkCapacity = 25;

    private static final Lock iceRinkLock = new ReentrantLock();

    private static List<Skater> skatersOnTheIce = new ArrayList<Skater>();

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

    public static void addToRinkList(Skater skater){
        synchronized(iceRinkLock){
            skatersOnTheIce.add(skater);
        }
    }

    public static Skater getSkaterById(int skaterId){
        synchronized(iceRinkLock){
            return skatersOnTheIce.get(skaterId);
        }
    }

    public void letSkatersOnRink() {
        Graphics g = surface.getGraphics();
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.ORANGE);

        g.dispose();

    }



}
