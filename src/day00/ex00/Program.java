package day00.ex00;

public class Program {
    public Program() {
    }

    public static void main(String[] args) {
        int n = 479598;
        int res = 0;
        //проверка на буквы????
        for(int i = 0; i != n; ++i) {
            res += n % 10;
            n /= 10;
        }

        System.out.println(res);
    }
}
