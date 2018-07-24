


import com.miniCAD.Shapes.Line;
import com.miniCAD.Shapes.ShapeFactory;
import com.miniCAD.miniCAD.MiniCAD;

import javax.imageio.ImageIO;
import java.awt.Point;
import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static com.miniCAD.Shapes.ShapeFactory.*;

public final class Main {

    private Main() { }





    public static void main(final String[] args) throws IOException {

        FileReader fileReader = new FileReader(args[0]);

        //parse the file
        Scanner scanner = new Scanner(fileReader);
        int noShapes = scanner.nextInt();
        scanner.nextLine();

        //initialize the canvas
        String[] canvasDescription = scanner.nextLine().split(" ");
        MiniCAD miniCAD = new MiniCAD(canvasDescription);
        //send each shape to factory

        for (int i = 0; i < noShapes - 1; i++) {
            String line = scanner.nextLine();
            String[] shapeDescription = line.split(" ");
            //no need to send a Line to factory
            if (shapeDescription[0].equals("LINE")) {

                int x1 = Integer.parseInt(shapeDescription[I1]);
                int y1 = Integer.parseInt(shapeDescription[I2]);
                int x2 = Integer.parseInt(shapeDescription[I3]);
                int y2 = Integer.parseInt(shapeDescription[I4]);

                String color = shapeDescription[I5];
                int alpha = Integer.parseInt(shapeDescription[I6]);
                Color inC = ShapeFactory.INSTANCE.hex2Rgb(color, alpha);
                Point start = new Point(x1, y1);
                Point finish = new Point(x2, y2);
                miniCAD.draw(new Line(start, finish, inC));


            } else {
                ShapeFactory.INSTANCE.createShape(shapeDescription).accept(miniCAD);
            }
        }



            ImageIO.write(miniCAD.getCanvas(), "png", new File("drawing.png"));


    }
}
