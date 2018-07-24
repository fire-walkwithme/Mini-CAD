package com.miniCAD.Algorithms;

import com.miniCAD.Shapes.Line;

import java.awt.Point;


public final class BresenhamLine {

    private BresenhamLine() { }
    public static void plot(final Line line) {
        int x1 = line.getStart().x;
        int y1 = line.getStart().y;
        int x2 = line.getFinish().x;
        int y2 = line.getFinish().y;
        int x = x1;
        int y = y1;
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int s1 = Integer.signum(x2 - x1);
        int s2 = Integer.signum(y2 - y1);

        boolean interchanged = false;

        if (dx < dy) {
            int aux = dx;
            dx = dy;
            dy = aux;
            interchanged = true;
        }

        int error = 2 * dy - dx;

        for (int i = 0; i <= dx; i++) {
            line.addPoint(new Point(x, y));

            while (error > 0) {
                if (interchanged) {
                    x = x + s1;
                } else {
                    y = y + s2;
                }

                error = error - 2 * dx;
            }

            if (interchanged) {
                y = y + s2;
            } else {
                x = x + s1;
            }

            error = error + 2 * dy;
        }
    }

    /*public static void plot(final Line line) {

        int x1 = line.getStart().x;
        int y1 = line.getStart().y;
        int x2 = line.getFinish().x;
        int y2 = line.getFinish().y;

        Color lineColor = line.getLineColor();
        int rgb = lineColor.getRGB();

       if ((x1 == x2) && (y1 == y2)) {
            line.addPoint(new Point(x1, y1));
            //bufferedImage.setRGB(x1, y1, rgb);

        } else {
            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);
            int error = dx - dy;

            int signX, signY;

            if (x1 < x2) {
                signX = 1;
            } else {
                signX = -1;
            }
            if (y1 < y2) {
                signY = 1;
            } else {
                signY = -1;
            }

            while ((x1 != x2) || (y1 != y2)) {

                int p = 2 * error;

                if (p > -dy) {
                    error = error - dy;
                    x1 = x1 + signX;
                }
                if (p < dx) {
                    error = error + dx;
                    y1 = y1 + signY;
                }
               //bufferedImage.setRGB(x1, y1, rgb);
                line.addPoint(new Point(x1, y1));
            }
        }

    }*/
}
