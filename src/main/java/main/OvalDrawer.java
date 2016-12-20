package main;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

/**
 * Created by Maciek on 2016-12-20.
 */
public class OvalDrawer extends TimerTask {

    private IcePanel icePanel;

    private static volatile int drawCounter = 0;

    public OvalDrawer(IcePanel icePanel){
        this.icePanel = icePanel;
    }

    public void run() {
        this.drawCircle(drawCounter, drawCounter, drawCounter, drawCounter, Color.RED);
    }

    private synchronized void drawCircle(int x, int y, int width, int height, Color color){
        icePanel.drawCircle(x, y, width, height, color);
        drawCounter++;
        System.out.println("Circle " + drawCounter + " drawed!!!");
    }
}
