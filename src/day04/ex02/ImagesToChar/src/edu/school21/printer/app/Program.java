package edu.school21.printer.app;

import com.beust.jcommander.JCommander;
import edu.school21.printer.logic.Args;


public class Program {
    public static void main(String[] args) {

        Args arguments = new Args();
        JCommander.
                newBuilder().
                addObject(arguments).
                build().
                parse(args);
        String file = "./src/resources/image.bmp";
        arguments.run(file);

    }
}