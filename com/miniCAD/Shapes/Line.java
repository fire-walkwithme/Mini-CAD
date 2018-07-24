package com.miniCAD.Shapes;
import com.miniCAD.miniCAD.DrawVisitor;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public final class Line implements VisitableShape {

    private Color lineColor;
    private Point start, finish;
    private ArrayList<Point> pixels;

    public Line(final Point a, final Point b, final Color color) {
        this.start = a;
        this.finish = b;
        this.lineColor = color;
        this.pixels = new ArrayList<>();
    }

    public void addPoint(final Point newPoint) {
        pixels.add(newPoint);
    }


    @Override
    public void accept(final DrawVisitor drawVisitor) {
        drawVisitor.draw(this);

    }

    public Color getLineColor() {
        return lineColor;
    }

    public Point getStart() {
        return start;
    }

    public Point getFinish() {
        return finish;
    }

    public ArrayList<Point> getPixels() {
        return pixels;
    }
}
