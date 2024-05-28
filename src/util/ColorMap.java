package util;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ColorMap {
    static Map<Integer, Color> colorMap = new HashMap<>();

    //todo: complete the method to add other color
    public static void InitialColorMap() {
        colorMap.put(2, Color.ORANGE);
        colorMap.put(4, Color.cyan);
        colorMap.put(8, Color.GREEN);
        colorMap.put(16, Color.MAGENTA);
        colorMap.put(32, Color.blue);
        colorMap.put(64, Color.CYAN);
        colorMap.put(128, Color.pink);
    }

    public static Color getColor(int i) {
        return colorMap.getOrDefault(i, Color.black);
    }
}
