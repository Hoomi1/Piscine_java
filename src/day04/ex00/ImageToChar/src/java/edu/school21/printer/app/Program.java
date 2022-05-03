package edu.school21.printer.app;

import edu.school21.printer.logic.Print;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class Program {
    public static void main(String[] args) {
        if (args.length != 3)
        {
            System.out.println("Invalid arguments");
            System.out.println("-----------------");
            System.out.println("char_for_black char_for_white file_name.bmp");
            System.exit(0);
        }
        String black = args[0];
        String white = args[1];
        String file = args[2];
        File fileBmp = new File(file);
        BufferedImage image = null;
        try {
            image = ImageIO.read(fileBmp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (image.getWidth() <= 0 || image.getHeight() <= 0) {
            System.out.println("invalid picture");
            System.exit(0);
        }
        Print print = new Print(image.getHeight(), image.getWidth(), image);
        print.PrintPix(black, white);
    }
}
