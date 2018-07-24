package com.miniCAD.Shapes;

import com.miniCAD.miniCAD.DrawVisitor;

import java.awt.Point;
import java.awt.Color;


public final class Diamond extends Shape implements VisitableShape {

    private Point center;
    private int horizontalD;
    private int verticalD;

    public Diamond(final Color in, final Color out, final Point c, final int d1, final int d2) {
        super(in, out);
        this.center = c;
        this.horizontalD = d1;
        this.verticalD = d2;
    }

    @Override
    public void accept(final DrawVisitor drawVisitor) {
      drawVisitor.draw(this);
    }

    public int getSemiDiagonal(final int diagonal) {
        if (diagonal % 2 == 1) {
            return Math.round(diagonal / 2);
        } else {
            return diagonal / 2;
        }

    }

    public Point getNorth() {
        int x = center.x;
        int y = center.y - getSemiDiagonal(verticalD);
        return new Point(x, y);
    }

    public Point getSouth() {
        int x = center.x;
        int y = center.y + getSemiDiagonal(verticalD);
        return new Point(x, y);
    }

    public Point getWest() {
        int x = center.x + getSemiDiagonal(horizontalD);
        int y = center.y;
        return new Point(x, y);
    }

    public Point getEast() {
        int x = center.x - getSemiDiagonal(horizontalD);
        int y = center.y;
        return new Point(x, y);

    }

    public Point getCenter() {
        return center;
    }

    public int getHorizontalD() {
        return horizontalD;
    }

    public int getVerticalD() {
        return verticalD;
    }
}
