package com.miniCAD.miniCAD;

import com.miniCAD.Algorithms.BoundaryFill;
import com.miniCAD.Algorithms.BresenhamCircle;
import com.miniCAD.Algorithms.BresenhamLine;
import com.miniCAD.Shapes.*;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Point;

import static com.miniCAD.Shapes.ShapeFactory.*;


public final class MiniCAD implements DrawVisitor {

    private static BufferedImage canvas;
    private Color background;


    public MiniCAD(final String[] canvasDescription) {

        int height = Integer.parseInt(canvasDescription[I1]);
        int width = Integer.parseInt(canvasDescription[I2]);
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        String color = canvasDescription[I3];
        int alpha = Integer.parseInt(canvasDescription[I4]);
        background = ShapeFactory.INSTANCE.hex2Rgb(color, alpha);
        setBackground(background.getRGB());
    }

    public void setBackground(final int backgroundRGB) {
        for (int i = 0; i < canvas.getWidth(); i++) {
            for (int j = 0; j < canvas.getHeight(); j++) {
                canvas.setRGB(i, j, backgroundRGB);
            }
        }
    }

    public static boolean checkPixel(final Point pixel) {
        if (pixel.x < 0 || pixel.y < 0 || pixel.x >= canvas.getWidth()
                || pixel.y >= canvas.getHeight()) {
            return false;
        }

        return true;
    }

    public static BufferedImage getCanvas() {
        return canvas;
    }

    @Override
    public void draw(final Circle circle) {

        BresenhamCircle.plot(circle);
        int outline = circle.getOutline().getRGB();
        for (Point i : circle.getPixels()) {
            if (checkPixel(i)) {
                canvas.setRGB(i.x, i.y, outline);
            }
        }
        BoundaryFill.flood(canvas, circle.getCenter(), circle.getOutline(), circle.getInner());
    }

    @Override
    public void draw(final Diamond diamond) {
        Point south = diamond.getSouth();
        Point north = diamond.getNorth();
        Point west = diamond.getWest();
        Point east = diamond.getEast();
        Point center = diamond.getCenter();
        Color outColor = diamond.getOutline();
        Color innerColor = diamond.getInner();

        Line line1 = new Line(south, west, outColor);
        line1.accept(this);
        Line line2 = new Line(west, north, outColor);
        line2.accept(this);
        Line line3 = new Line(north, east, outColor);
        line3.accept(this);
        Line line4 = new Line(east, south, outColor);
        line4.accept(this);

        BoundaryFill.flood(canvas, center, outColor, innerColor);

    }

    @Override
    public void draw(final Square square) {
        //plot the outline
        Color outline = square.getOutline();
        Line line1 = new Line(square.getLeftUpCorner(), square.getRightUpCorner(), outline);
        line1.accept(this);
        Line line2 = new Line(square.getRightUpCorner(), square.getRightDownCorner(), outline);
        line2.accept(this);
        Line line3 = new Line(square.getRightDownCorner(), square.getLeftDownCorner(), outline);
        line3.accept(this);
        Line line4 = new Line(square.getLeftDownCorner(), square.getLeftUpCorner(), outline);
        line4.accept(this);
        //paint
        for (int i = square.getLeftUpCorner().x + 1; i < square.getRightUpCorner().x; i++) {
            for (int j = square.getLeftUpCorner().y + 1; j < square.getRightDownCorner().y; j++) {
                Point newPoint = new Point(i, j);
                if (checkPixel(newPoint)) {
                    canvas.setRGB(newPoint.x, newPoint.y, square.getInner().getRGB());
                }
            }
        }


    }

    @Override
    public void draw(final Triangle triangle) {
        Color outline = triangle.getOutline();
        Color inner = triangle.getInner();
        Line line1 = new Line(triangle.getP1(), triangle.getP2(), outline);
        line1.accept(this);
        Line line2 = new Line(triangle.getP2(), triangle.getP3(), outline);
        line2.accept(this);
        Line line3 = new Line(triangle.getP3(), triangle.getP1(), outline);
        line3.accept(this);
        BoundaryFill.flood(canvas, triangle.getCentroid(), outline, inner);
    }

    @Override
    public void draw(final Polygon polygon) {
        Color outline = polygon.getOutline();
        Color inner = polygon.getInner();
        int size = polygon.getPoints().size();
        Line line;
        for (int i = 0; i < size - 1; i++) {
            line = new Line(polygon.getPoints().get(i), polygon.getPoints().get(i + 1), outline);
            line.accept(this);
        }

        line = new Line(polygon.getPoints().get(size - 1), polygon.getPoints().get(0), outline);
        line.accept(this);
        BoundaryFill.flood(canvas, polygon.getCentroid(), outline, inner);



    }

    @Override
    public void draw(final Rectangle rectangle) {
        //plot the outline
        Line line1 = new Line(rectangle.getLeftUpCorner(), rectangle.getRightUpCorner(),
                rectangle.getOutline());
        line1.accept(this);
        Line line2 = new Line(rectangle.getRightUpCorner(), rectangle.getRightDownCorner(),
                rectangle.getOutline());
        line2.accept(this);
        Line line3 = new Line(rectangle.getRightDownCorner(), rectangle.getLeftDownCorner(),
                rectangle.getOutline());
        line3.accept(this);
        Line line4 = new Line(rectangle.getLeftDownCorner(), rectangle.getLeftUpCorner(),
                rectangle.getOutline());
        line4.accept(this);
        //paint
        for (int i = rectangle.getLeftUpCorner().x + 1; i < rectangle.getRightUpCorner().x; i++) {
            for (int j = rectangle.getLeftUpCorner().y + 1;
                 j < rectangle.getRightDownCorner().y; j++) {
                Point newPoint = new Point(i, j);
                if (checkPixel(newPoint)) {
                    canvas.setRGB(newPoint.x, newPoint.y, rectangle.getInner().getRGB());
                }
            }
        }

    }

    @Override
    public void draw(final Line line) {
        BresenhamLine.plot(line);
        int lineColor = line.getLineColor().getRGB();
        for (Point i : line.getPixels()) {
            if (checkPixel(i)) {
                canvas.setRGB(i.x, i.y, lineColor);
            }
        }

    }
}
