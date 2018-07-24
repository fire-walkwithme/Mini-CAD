package com.miniCAD.Shapes;

import com.miniCAD.miniCAD.DrawVisitor;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public final class Polygon extends Shape implements VisitableShape {

    private ArrayList<Point> points;

    public Polygon(final Color in, final Color out, final ArrayList<Point> pts) {
        super(in, out);
        this.points = pts;
    }

    @Override
    public void accept(final DrawVisitor drawVisitor) {
        drawVisitor.draw(this);
    }

    public Point getCentroid() {
        int x = 0;
        int y = 0;
        for (Point i : points) {
            x += i.x;
            y += i.y;
        }

        x = x / points.size();
        y = y / points.size();

        return new Point(x, y);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}
