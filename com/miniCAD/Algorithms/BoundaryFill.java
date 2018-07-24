package com.miniCAD.Algorithms;
import com.miniCAD.miniCAD.MiniCAD;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;


public class BoundaryFill {


    public static final int checkColor(final int x, final int y, final int fill) {
        if (MiniCAD.checkPixel(new Point(x, y))) {
            if (MiniCAD.getCanvas().getRGB(x, y) == fill) {
                return fill;
            }
        }
        return 0;
    }



    public static final void flood(BufferedImage image, final Point center,
                                   final Color outlineColor, final Color fillColor) {

        //Stack<Point> points = new Stack<>();
        LinkedList<Point> points = new LinkedList<>();
        int outline = outlineColor.getRGB();
        int fill = fillColor.getRGB();
        points.add(center);

        while (!points.isEmpty()) {
            Point currentPoint = points.remove();
            int x = currentPoint.x;
            int y = currentPoint.y;

            if (MiniCAD.checkPixel(new Point(x, y))) {

                int current = image.getRGB(x, y);
                if ((current != outline) && (current != fill)) {

                        image.setRGB(x, y, fill);
                    if (checkColor(x + 1, y, fill) != fill) {
                            points.add(new Point(x + 1, y));
                        }

                    if (checkColor(x - 1, y, fill) != fill) {
                        points.add(new Point(x - 1, y));
                    }
                    if (checkColor(x, y + 1, fill) != fill) {
                        points.add(new Point(x, y + 1));
                    }
                    if (checkColor(x, y - 1, fill) != fill) {
                        points.add(new Point(x, y - 1));
                    }

                }

            }
        }

    }
}
