package day01.ex01;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Alex", 500);
        System.out.println(user1.getIdentifier());
        User user2 = new User("Max", 500);
        System.out.println(user2.getIdentifier());
        User user3 = new User("Alice", 500);
        System.out.println(user3.getIdentifier());
    }
}
