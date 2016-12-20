package main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Maciek on 2016-12-20.
 */
public class IcePanel extends JPanel {

    private Graphics graphics;

    public IcePanel(int width, int height, boolean containsBorders){
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        if(containsBorders){
            setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        graphics = g;

        g.setColor(Color.RED);
        g.drawRect(50, 50, 50, 50);
    }

    public void drawCircle(int x, int y, int width, int height, Color color){
        graphics.setColor(color);
        graphics.drawOval(x, y, width, height);
    }
}
