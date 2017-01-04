package icepanelbusiness;

import concurrentComponenets.SkaterMover;
import main.Skater;
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

    public void letSkatersOnRink(){
        Graphics g = surface.getGraphics();
        g.setColor(Color.ORANGE);
        g.fillRect(0,0,width, height);
        g.setColor(Color.ORANGE);

        g.dispose();
        final IcePanel icePanel = this;
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //get new skater from the queue.
                //letSkaterOnTheIce(SkatersQueue.getClient());
                //drawRandomElement();
                Skater newSkater = SkatersQueue.getClient();
                SkaterMover skaterMover = new SkaterMover(newSkater, icePanel,  viewLabel);
                java.util.Timer skaterTimer = new java.util.Timer();
                skaterTimer.schedule(skaterMover, 200);

                /*drawSkater(newSkater);
                newSkater.moveOnTheIce();
                addToRinkList(newSkater);*/
            }
        };
        javax.swing.Timer timer = new javax.swing.Timer(2000, listener);
        timer.start();
    }

    private void drawNewSkater(int skaterWidth, int skaterHeight, double condition){

        //draw new skater in the middle right side of the rink.
        /*int x = 550;
        int y = 300;*/
        int xBound = 20;
        int yBound = 20;

        Random random = new Random();
        int x = random.nextInt(width - xBound);
        int y = random.nextInt(height - yBound);
        //drawOval(x, y, skaterWidth, skaterHeight);
    }

    /*private void drawRandomElement(){
        //bounderies
        int xBound = 20;
        int yBound = 20;

        int ovalWidth = 15;
        int ovalHeight = 15;
        Random random = new Random();
        int x = random.nextInt(width - xBound);
        int y = random.nextInt(height - yBound);
        drawOval(x, y, ovalWidth, ovalHeight);
    }*/

    private void drawOval(int x, int y, int width, int height, Skater skater){
        Graphics graphics = surface.getGraphics();
        graphics.setColor(Color.black);
        graphics.fillOval(x, y, width, height);
        graphics.drawOval(x, y, width, height);
        graphics.dispose();
        viewLabel.repaint();
    }

    public void drawSkater(Skater skater){
        Graphics graphics = surface.getGraphics();
        Graphics2D graphics2D = (Graphics2D) graphics.create();
        skater.paint(graphics2D);
        graphics2D.dispose();
        viewLabel.repaint();
    }

    /*protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Box box : boxes) {
            Graphics2D g2d = (Graphics2D) g.create();
            box.paint(g2d);
            g2d.dispose();
        }
    }*/



}
