package day01.ex00;

public class Program {

    public static void main(String[] args) {
        User user1 = new User("Alex", 500);
        User user2 = new User("Max", 1000);

        Transaction transaction = new Transaction(user2, user1, 600);
        System.out.println(transaction);
    }
}
