package day00.ex01;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        boolean f = true;
        int del;
        int iter = 1;

        if (!scanner.hasNextInt())
        {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        int n = scanner.nextInt();
        if (n <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        for (del = 2; del < n; ++del, ++iter)
        {
            if (n % del == 0) {
                f = false;
                break;
            }
            else if (del * del > n)
                break;
        }
        System.out.printf("%b %d", f, iter);
        scanner.close();
    }
}
