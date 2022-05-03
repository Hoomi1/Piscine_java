package day01.ex02;

public class Program {
    public static void main(String[] args) {
        UsersList ArrayList = new UsersArrayList();
        ArrayList.UserAdd("Bob", 100);
        ArrayList.UserAdd("Bos", 200);
        ArrayList.UserAdd("Bot", 300);
        ArrayList.UserAdd("Bog", 400);
        ArrayList.UserAdd("Bor", 500);

        System.out.println(ArrayList.UsersNum());
        for (int i = 0; i < ArrayList.UsersNum(); i++) {
            System.out.println(ArrayList.UserByIndex(i).getName());
        }

        System.out.println(ArrayList.UserById(4).getName());
    }
}
