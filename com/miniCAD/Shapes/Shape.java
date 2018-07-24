package com.miniCAD.Shapes;

import com.miniCAD.miniCAD.DrawVisitor;

import java.awt.Color;

public class Shape implements VisitableShape {
    private Color inner;
    private Color outline;

    Shape(final Color in, final Color out) {
        this.inner = in;
        this.outline = out;
    }

    @Override
    public void accept(final DrawVisitor drawVisitor) {

    }

    public final Color getInner() {
        return inner;
    }

    public final Color getOutline() {
        return outline;
    }
}
