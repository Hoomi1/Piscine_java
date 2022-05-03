package day00.ex02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long prime;
        int iter_cof = 0;
        while ((prime = scanner.nextLong()) != 42)
        {
            boolean f = true;
            int res = 0;
            for(int i = 0; i != prime;) {
                res += prime % 10;
                prime /= 10;
            }
            if (res <= 1)
                continue;
            for (int del = 2; del < res; ++del)
            {
                if (res % del == 0) {
                    f = false;
                    break;
                }
                else if (del * del > res)
                    break;
            }
            if (f)
                ++iter_cof;
        }
        System.out.print("Count is coffee-request - " + iter_cof);
        scanner.close();
    }
}
