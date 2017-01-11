package tools;

import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Maciek on 2017-01-11.
 */
public class RoundedBorder implements Border {

    private int radius;


    public RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

}
