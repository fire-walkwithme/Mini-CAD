
package com.miniCAD.Shapes;
import com.miniCAD.miniCAD.DrawVisitor;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public final class Circle extends Shape implements VisitableShape {

    private Point center;
    private int radius;
    private ArrayList<Point> pixels;

    public Circle(final Color in, final Color out, final Point c, final int r) {
        super(in, out);
        this.center = c;
        this.radius = r;
        pixels = new ArrayList<>();
    }

    public void addPoint(final Point newPoint) {
        pixels.add(newPoint);
    }

    @Override
    public void accept(final DrawVisitor drawVisitor) {
        drawVisitor.draw(this);
    }

    public int getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    public ArrayList<Point> getPixels() {
        return pixels;
    }
}
