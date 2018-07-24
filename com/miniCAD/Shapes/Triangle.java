package com.miniCAD.Shapes;

import com.miniCAD.miniCAD.DrawVisitor;

import java.awt.Color;
import java.awt.Point;

public final class Triangle extends Shape implements VisitableShape {

    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle(final Color in, final Color out,
                    final Point a, final Point b, final Point c) {
        super(in, out);
        this.p1 = a;
        this.p2 = b;
        this.p3 = c;
    }

    @Override
    public void accept(final DrawVisitor drawVisitor) {
        drawVisitor.draw(this);
    }

    public Point getCentroid() {
        int x = (p1.x + p2.x + p3.x) / 3;
        int y = (p1.y + p2.y + p3.y) / 3;
        return new Point(x, y);

    }
    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }
}

