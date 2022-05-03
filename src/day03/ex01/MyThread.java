//package day03.ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyThread {
    static String flag = "Hen";
    public static void main(String[] args) {
        if (args.length != 1)
        {
            System.out.println("Argument only can be one");
            System.exit(0);
        }
        String[] split = args[0].split("=");
        List<String> flag = Collections.synchronizedList(new ArrayList<>());
        int number = 0;
        if (!split[0].equals("--count"))
        {
            System.out.println("Invalid input");
            System.exit(0);
        }
        number = Integer.parseInt(split[1]);
        Thread thread2 = new Thread(new Print("Hen", number));
        Thread thread1 = new Thread(new Print("Egg", number));
        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
