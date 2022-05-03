import java.util.ArrayList;
import java.util.Random;

public class Programi {
    static ArrayList<Integer> listInt = new ArrayList<>();
    static int first = 0;
    static int last = 0;
    static int Sumsum = 0;
    public static void main(String[] args) {
        if (args.length != 2)
        {
            System.out.println("Arguments only can be two!!!");
            System.exit(0);
        }
        String[] arg1 = args[0].split("=");
        String[] arg2 = args[1].split("=");
        if (!arg1[0].equals("--arraySize") || !arg2[0].equals("--threadsCount"))
        {
            System.out.println("Invalid arguments!!!");
            System.exit(0);
        }
        int sizeArray = Integer.parseInt(arg1[1]);
        int countThread = Integer.parseInt(arg2[1]);
        if (sizeArray > 2000000 || countThread > sizeArray)
        {
            System.out.println("Invalid arguments!!!");
            System.exit(0);
        }
        Calculator calculator = new Calculator(sizeArray, countThread);
        calculator.SumCol();
        Thread[] threads = new Thread[countThread];
        Random random = new Random();
        int newSize = 0;
        for (int i = 0; i < sizeArray; i++) {
            listInt.add(random.nextInt(1000));
            newSize += listInt.get(i);
//            listInt.add(1);
        }
        System.out.println("Sum: " + newSize);
        for (int i = 0; i < countThread; i++) {
            sizeArray -= calculator.getMaxSize();
            if (sizeArray >= calculator.getMinSize())
            {
                threads[i] = new MyThread(last += first, last += calculator.getMaxSize());
            }
            else
                threads[i] = new MyThread(last += first, last += calculator.getMinSize());
            threads[i].start();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sum by threads: " + Sumsum);
    }
}
