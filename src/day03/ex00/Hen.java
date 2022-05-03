public class Hen implements Runnable{
    private String messenger;
    private int iter;

    public Hen(String messenger, int iter) {
        this.messenger = messenger;
        this.iter = iter;
    }

    @Override
    public void run() {
        for (int i = 0; i < iter; i++) {
            System.out.println(messenger);
        }
    }
}
