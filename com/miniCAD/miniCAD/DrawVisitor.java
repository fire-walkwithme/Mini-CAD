package com.miniCAD.miniCAD;

import com.miniCAD.Shapes.*;


public interface DrawVisitor {
    void draw(Rectangle rectangle);
    void draw(Circle circle);
    void draw(Square square);
    void draw(Triangle triangle);
    void draw(Diamond diamond);
    void draw(Polygon polygon);
    void draw(Line line);
}
