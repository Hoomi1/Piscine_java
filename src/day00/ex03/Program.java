package day00.ex03;

import java.util.Scanner;
import java.lang.String;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iter = 0;
        long res = 0;
        while (scanner.hasNextLine() && iter != 18)
        {
            String str = scanner.next();
            if (str.equals("42"))
                break;

            if (!str.equals("Week") || !scanner.hasNextInt())
            {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            if (iter + 1 != scanner.nextInt())
            {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            int val = 9;
            long dig = 1;
            for (int i = 0; i < 5; ++i)
            {
                if (!scanner.hasNextInt())
                {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                int num = scanner.nextInt();
                if (num >= 1 && num <= 9)
                {
                    if (val > num)
                        val = num;
                }
                else
                {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
            }
            for (int k = 0; k < iter; k++) {
                dig *= 10;
            }
            dig *= val;
            res += dig;
            ++iter;
        }
        int i = 1;
        while (res != 0)
        {
            long num = 0;
            num = res % 10;
            res /= 10;
            System.out.print("Week ");
            System.out.print(i);
            System.out.print(" ");
            for (int j = 0; j < num; j++) {
                System.out.print("=");
            }
            System.out.println(">");
            ++i;
        }

        scanner.close();
    }
}
