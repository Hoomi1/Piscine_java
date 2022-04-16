package day00.ex03;

import java.util.Scanner;
import java.lang.String;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iter = 0;
        while (scanner.hasNextLine() && iter != 18)
        {
            String str = scanner.next();
            if (str.equals("42"))
                break;

            if (!str.equals("Week") || !scanner.hasNextInt())
            {
                System.err.println("Illegal Argument");
                System.exit(-1);
            }
            if (iter + 1 != scanner.nextInt())
            {
                System.err.println("Illegal Argument");
                System.exit(-1);
            }

            for (int i = 0; i < 5; ++i)
            {
                if (!scanner.hasNextInt())
                {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                int num = scanner.nextInt();
                long res = 0;
                int val = 1;
                if (num >= 1 && num <= 9)
                {
                    val *= 10;
                    res += num * val;
                }
                else
                {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
            }


        }
    }
}
