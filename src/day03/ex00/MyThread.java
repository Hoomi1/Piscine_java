public class MyThread {
    public static void main(String[] args) {
        if (args.length != 1)
        {
            System.out.println("Argument only can be one");
            System.exit(0);
        }
        String[] split = args[0].split("=");
        int number = 0;
        if (!split[0].equals("--count"))
        {
            System.out.println("Invalid input");
            System.exit(0);
        }
        number = Integer.parseInt(split[1]);
        Thread thread1 = new Thread(new Egg("Egg", number));
        Thread thread2 = new Thread(new Hen("Hen", number));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Human");
        }
    }
}
