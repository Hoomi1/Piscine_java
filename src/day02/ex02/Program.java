package day02.ex02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {
        if (args.length != 1)
        {
            System.out.println("One argument");
            System.exit(0);
        }
        String str = args[0];
        String[] path_start = str.split("=");
        if (!path_start[0].equals("--current-folder"))
        {
            System.out.println("Errors");
            System.exit(0);
        }
        String command = "";
        File file = new File(path_start[1]);
        if (!file.exists())
        {
            System.out.println("path does not exist!!!");
            System.exit(0);
        }
        System.out.println(path_start[1]);
        Scanner scanner = new Scanner(System.in);
        String start = path_start[1];
        while (!(command += scanner.nextLine()).equals("exit"))
        {
            String name_path = StartComand(command, start);
            command = "";
            start = "";
            start += name_path;
        }
    }

    static String StartComand(String command, String start)
    {
        String[] split = command.split(" ");
        switch (split[0])
        {
            case "ls":
                try {
                    Stream<Path> pathStream = Files.walk(Paths.get(start), 1);
                    List<Path> listFile = pathStream.collect(Collectors.toList());
                    for (Path p : listFile) {
                        char[] c = p.getFileName().toString().toCharArray();
                        if (!p.equals(Paths.get(start)) && c[0] != '.') {
                            System.out.println(p.getFileName() + " " + Files.size(p) + " KB");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "cd":
                File newfile = new File(start + "/" + split[1]);
                if (newfile.exists() && Files.isDirectory(Paths.get(newfile.toString())))
                {
                    Path strpath = Paths.get(newfile.toString());
                    start = strpath.normalize().toString();
                    System.out.println(start);
                    return start;
                }
                break;
            case "mv":
                if (split.length != 3)
                {
                    System.out.println("two arguments!!!");
                    return start;
                }
                Path pathstr1 = Paths.get(start + "/" + split[1]).normalize();
                Path pathstr2 = Paths.get(start + "/" + split[2]).normalize();
                if (Files.isRegularFile(pathstr1))
                {
                    if (Files.isDirectory(pathstr2))
                    {
                        pathstr2 = Paths.get(pathstr2 + "/" + pathstr1.getFileName());
                    }
                    try {
                        Files.move(pathstr1, pathstr2, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    System.out.println("Not file!!!");
                }

                break;
        }
        return start;
    }
}