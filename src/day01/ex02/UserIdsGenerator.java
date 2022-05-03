package day01.ex02;

public class UserIdsGenerator {
    private int id = 0;
    private static final UserIdsGenerator instance = new UserIdsGenerator();

    private UserIdsGenerator() {}

    public static UserIdsGenerator getInstance()
    {
        return instance;
    }

    public int generateId()
    {
        return id++;
    }
}
