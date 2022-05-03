package edu.school21.printer.logic;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Parameters(separators = "=")
public class Args {
    @Parameter(names = "--white")
    private String arg1; // ИЗМЕНИТЬ ТИП
    @Parameter(names = "--black")
    private String arg2; // ИЗМЕНИТЬ ТИП

    public void run(String file)
    {
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
        print.PrintPix(arg1, arg2);
    }
}
