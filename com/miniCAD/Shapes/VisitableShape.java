package com.miniCAD.Shapes;

import com.miniCAD.miniCAD.DrawVisitor;

public interface VisitableShape {
    void accept(DrawVisitor drawVisitor);
}
