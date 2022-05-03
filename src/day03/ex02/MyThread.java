public class MyThread extends Thread{

    private int size;
    private int first;
    private int sum = 0;

    public MyThread(int first, int size) {
        this.size = size;
        this.first = first;
    }

    @Override
    public synchronized void run() {
        int f = first;
        for (;  first < size; first++) {
            sum += Programi.listInt.get(first);
            Programi.Sumsum += Programi.listInt.get(first);
        }
        System.out.println(getName() + ": " + "from " + f + " to " + (size - 1) + " sum is " + sum);
    }
}
