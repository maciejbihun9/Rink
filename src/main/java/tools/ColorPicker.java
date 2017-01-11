package tools;

import java.awt.*;
import java.util.Random;

/**
 * Created by Maciek on 2017-01-08.
 */
public class ColorPicker {

    private static Color [] COLORS = {Color.GRAY, Color.GREEN, Color.YELLOW, Color.LIGHT_GRAY, Color.CYAN};

    public static Color pickColor(){
        int max = COLORS.length;
        Random random = new Random();
        int rand = random.nextInt(max - 1);
        return COLORS[rand];
    }

}
