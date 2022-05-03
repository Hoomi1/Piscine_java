package edu.school21.numbers;

public class NumberWorker {

    public boolean isPrime(int number) {
        boolean f = true;
        int del;
        int iter = 1;

        if (number <= 1) {
            throw new IllegalNumberException("IllegalNumberException");
        }
        for (del = 2; del < number; ++del, ++iter)
        {
            if (number % del == 0) {
                f = false;
                break;
            }
            else if (del * del > number)
                break;
        }
        return f;
    }

    public int digitSum(int number)
    {
        int res = 0;
        for(int i = 0; i != number;) {
            res += number % 10;
            number /= 10;
        }
        return res;
    }
}

class  IllegalNumberException extends RuntimeException
{
    IllegalNumberException(String str)
    {
        super(str);
    }
}