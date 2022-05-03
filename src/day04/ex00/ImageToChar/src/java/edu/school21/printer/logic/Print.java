package edu.school21.printer.logic;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Print {
    private int height;
    private int width;
    private BufferedImage image;
    public Print(int height, int width, BufferedImage image) {
        this.height = height;
        this.width = width;
        this.image = image;
    }

    public void PrintPix(String black, String white)
    {
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int colorPix = image.getRGB(j, i);
                if (colorPix != Color.BLACK.getRGB())
                    System.out.print(white);
                else
                    System.out.print(black);
            }
            System.out.println();
        }
    }
}
