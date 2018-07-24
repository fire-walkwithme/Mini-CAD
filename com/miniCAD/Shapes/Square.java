package com.miniCAD.Shapes;

import com.miniCAD.miniCAD.DrawVisitor;

import java.awt.Point;
import java.awt.Color;

public final class Square extends Shape implements VisitableShape {

    private Point leftUpCorner;
    private int length;

    public Square(final Color in, final Color out, final Point p, final int l) {
        super(in, out);
        this.leftUpCorner = p;
        this.length = l;
    }

    @Override
    public void accept(final DrawVisitor drawVisitor) {
        drawVisitor.draw(this);
    }

    public int getLength() {
        return length;
    }

    public Point getLeftUpCorner() {
        return leftUpCorner;
    }

    public Point getLeftDownCorner() {
        int x = leftUpCorner.x;
        int y = leftUpCorner.y + length - 1;
        return new Point(x, y);

    }

    public Point getRightUpCorner() {
        int x = leftUpCorner.x + length - 1;
        int y = leftUpCorner.y;
        return new Point(x, y);
    }

    public Point getRightDownCorner() {
        int x = leftUpCorner.x + length - 1;
        int y = leftUpCorner.y + length - 1;
        return new Point(x, y);

    }


}
