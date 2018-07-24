package com.miniCAD.Shapes;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public final class ShapeFactory {
    //stupid constants just for the checkstyle's sake...
    public static final int I1 = 1;
    public static final int I2 = 2;
    public static final int I3 = 3;
    public static final int I4 = 4;
    public static final int I5 = 5;
    public static final int I6 = 6;
    public static final int I7 = 7;
    public static final int I8 = 8;
    public static final int I9 = 9;
    public static final int I10 = 10;

    public static final int BASE16 = 16;
    public static final int POS1 = 1;
    public static final int POS3 = 3;
    public static final int POS5 = 5;
    public static final int POS7 = 7;

    public static final ShapeFactory INSTANCE = new ShapeFactory();
    private ShapeFactory() { }

    public static Color hex2Rgb(final String color, final int alpha) {
        return new Color(
                Integer.valueOf(color.substring(POS1, POS3), BASE16),
                Integer.valueOf(color.substring(POS3, POS5), BASE16),
                Integer.valueOf(color.substring(POS5, POS7), BASE16), alpha);
    }

    public Shape createShape(final String[] shapeDescription) {
        String shapeName = shapeDescription[0];
        //parse shape individually
        switch (shapeName) {

            case "SQUARE":
                int xS = Integer.parseInt(shapeDescription[I1]);
                int yS = Integer.parseInt(shapeDescription[I2]);
                int edge = Integer.parseInt(shapeDescription[I3]);

                String outColorS = shapeDescription[I4];
                int alphaOutS = Integer.parseInt(shapeDescription[I5]);
                String inColorS = shapeDescription[I6];
                int alphaInS = Integer.parseInt(shapeDescription[I7]);
                Color inS = hex2Rgb(inColorS, alphaInS);
                Color outS = hex2Rgb(outColorS, alphaOutS);
                return new Square(inS, outS, new Point(xS, yS), edge);


            case "RECTANGLE":
                int xR = Integer.parseInt(shapeDescription[I1]);
                int yR = Integer.parseInt(shapeDescription[I2]);
                int height = Integer.parseInt(shapeDescription[I3]);
                int length = Integer.parseInt(shapeDescription[I4]);

                String outColorR = shapeDescription[I5];
                int alphaOutR = Integer.parseInt(shapeDescription[I6]);
                String inColorR = shapeDescription[I7];
                int alphaInR = Integer.parseInt(shapeDescription[I8]);
                Color inR = hex2Rgb(inColorR, alphaInR);
                Color outR = hex2Rgb(outColorR, alphaOutR);

                return new Rectangle(inR, outR, new Point(xR, yR), length, height);


            case "CIRCLE":
                int xC = Integer.parseInt(shapeDescription[I1]);
                int yC = Integer.parseInt(shapeDescription[I2]);
                int r = Integer.parseInt(shapeDescription[I3]);

                String outColorC = shapeDescription[I4];
                int alphaOutC = Integer.parseInt(shapeDescription[I5]);
                String inColorC = shapeDescription[I6];
                int alphaInC = Integer.parseInt(shapeDescription[I7]);
                Color inC = hex2Rgb(inColorC, alphaInC);
                Color outC = hex2Rgb(outColorC, alphaOutC);

                return new Circle(inC, outC, new Point(xC, yC), r);


            case "TRIANGLE":
                int x1 = Integer.parseInt(shapeDescription[I1]);
                int y1 = Integer.parseInt(shapeDescription[I2]);
                int x2 = Integer.parseInt(shapeDescription[I3]);
                int y2 = Integer.parseInt(shapeDescription[I4]);
                int x3 = Integer.parseInt(shapeDescription[I5]);
                int y3 = Integer.parseInt(shapeDescription[I6]);

                String outColorT = shapeDescription[I7];
                int alphaOutT = Integer.parseInt(shapeDescription[I8]);
                String inColorT = shapeDescription[I9];
                int alphaInT = Integer.parseInt(shapeDescription[I10]);
                Color inT = hex2Rgb(inColorT, alphaInT);
                Color outT = hex2Rgb(outColorT, alphaOutT);

                return new Triangle(inT, outT, new Point(x1, y1), new Point(x2, y2),
                        new Point(x3, y3));


            case "DIAMOND":
                int xD = Integer.parseInt(shapeDescription[I1]);
                int yD = Integer.parseInt(shapeDescription[I2]);
                int d1 = Integer.parseInt(shapeDescription[I3]);
                int d2 = Integer.parseInt(shapeDescription[I4]);

                String outColorD = shapeDescription[I5];
                int alphaOutD = Integer.parseInt(shapeDescription[I6]);
                String inColorD = shapeDescription[I7];
                int alphaInD = Integer.parseInt(shapeDescription[I8]);
                Color inD = hex2Rgb(inColorD, alphaInD);
                Color outD = hex2Rgb(outColorD, alphaOutD);

                return new Diamond(inD, outD, new Point(xD, yD), d1, d2);


            case "POLYGON":
                int noPoints = Integer.parseInt(shapeDescription[I1]);
                ArrayList<Point> points = new ArrayList<>();
                int i;
                for (i = 0; i < noPoints * 2; i += 2) {
                    int xP = Integer.parseInt(shapeDescription[i + 2]);
                    int yP = Integer.parseInt(shapeDescription[i + I3]);
                    points.add(new Point(xP, yP));
                }

                i += I2;

                String outColorP = shapeDescription[i];
                int alphaOutP = Integer.parseInt(shapeDescription[i + 1]);
                String inColorP = shapeDescription[i + I2];
                int alphaInP = Integer.parseInt(shapeDescription[i + I3]);

                Color inP = hex2Rgb(inColorP, alphaInP);
                Color outP = hex2Rgb(outColorP, alphaOutP);

                return new Polygon(inP, outP, points);



            default: return null;
        }
    }
}
