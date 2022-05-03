//package day03.ex01;

public class Print implements Runnable{

    private String messenger;
    private int iter;

    public Print(String messenger, int iter)
    {
        this.messenger = messenger;
        this.iter = iter;
    }

    @Override
    public void run() {
        for (int i = 0; i < iter;) {
            synchronized (Print.class) {
                if (!MyThread.flag.equals(messenger))
                {
                    System.out.println(messenger);
                    MyThread.flag = messenger;
                    ++i;
                }
            }
        }

    }
}
