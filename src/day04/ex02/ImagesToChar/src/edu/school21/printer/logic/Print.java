package edu.school21.printer.logic;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.BColor;

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

    public void PrintPix(String white, String black)
    {
        ColoredPrinter cp = new ColoredPrinter.Builder(1, false).build();
        BColor colorWhite = BColor.valueOf(white);
        BColor colorBlack = BColor.valueOf(black);
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int colorPix = image.getRGB(j, i);
                if (colorPix != Color.BLACK.getRGB()) {
                    cp.setBackgroundColor(colorWhite);
                    cp.print("   ");
                }
                else
                {
                    cp.setBackgroundColor(colorBlack);
                    cp.print("   ");
                }
            }
            System.out.println();
        }
    }
}
