package com.miniCAD.Algorithms;

import com.miniCAD.Shapes.Circle;

import java.awt.Point;
import java.awt.image.BufferedImage;

public final class BresenhamCircle {


    public static void plot(final Circle circle/*, BufferedImage bufferedImage*/) {
        int xc = circle.getCenter().x;
        int yc = circle.getCenter().y;
        int r = circle.getRadius();
        int x = 0, y = r;
        int d = 3 - 2 * r;
        while (y >= x) {
            circle.addPoint(new Point(xc + x, yc + y));
            circle.addPoint(new Point(xc - x, yc + y));
            circle.addPoint(new Point(xc + x, yc - y));
            circle.addPoint(new Point(xc - x, yc - y));
            circle.addPoint(new Point(xc + y, yc + x));
            circle.addPoint(new Point(xc - y, yc + x));
            circle.addPoint(new Point(xc + y, yc - x));
            circle.addPoint(new Point(xc - y, yc - x));

            /*bufferedImage.setRGB(xc + x, yc + y, color.getRGB());
            bufferedImage.setRGB(xc - x, yc + y, color.getRGB());
            bufferedImage.setRGB(xc + x, yc - y, color.getRGB());
            bufferedImage.setRGB(xc - x, yc - y, color.getRGB());
            bufferedImage.setRGB(xc + y, yc + x, color.getRGB());
            bufferedImage.setRGB(xc - y, yc + x, color.getRGB());
            bufferedImage.setRGB(xc + y, yc - x, color.getRGB());
            bufferedImage.setRGB(xc - y, yc - x, color.getRGB());*/
            x++;


            if (d > 0) {
                y--;
                d = d + 4 * (x - y) + 10;
            } else {
                d = d + 4 * x + 6;
            }
            circle.addPoint(new Point(xc + x, yc + y));
            circle.addPoint(new Point(xc - x, yc + y));
            circle.addPoint(new Point(xc + x, yc - y));
            circle.addPoint(new Point(xc - x, yc - y));
            circle.addPoint(new Point(xc + y, yc + x));
            circle.addPoint(new Point(xc - y, yc + x));
            circle.addPoint(new Point(xc + y, yc - x));
            circle.addPoint(new Point(xc - y, yc - x));
            /*bufferedImage.setRGB(xc + x, yc + y, color.getRGB());
            bufferedImage.setRGB(xc - x, yc + y, color.getRGB());
            bufferedImage.setRGB(xc + x, yc - y, color.getRGB());
            bufferedImage.setRGB(xc - x, yc - y, color.getRGB());
            bufferedImage.setRGB(xc + y, yc + x, color.getRGB());
            bufferedImage.setRGB(xc - y, yc + x, color.getRGB());
            bufferedImage.setRGB(xc + y, yc - x, color.getRGB());
            bufferedImage.setRGB(xc - y, yc - x, color.getRGB());*/

        }
    }
}
