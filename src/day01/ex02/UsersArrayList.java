package day01.ex02;

public class UsersArrayList implements UsersList {
    private int capacity = 10;
    private int size = 0;
    private User[] ArrayList = new User[capacity];

    @Override
    public void UserAdd(String Name, Integer Balance) {
        if (size == capacity - 1)
        {
            capacity += capacity / 2;
            User[] state = new User[capacity];

            for (int i = 0; i <= size; i++) {
                state[i] = ArrayList[i];
            }
            ArrayList = state;
        }
        ArrayList[size] = new User(Name, Balance);
        ++size;
    }

    @Override
    public User UserById(Integer id) throws UserNotFoundException{
        for (int i = 0; i < size; i++) {
            if (id.equals(ArrayList[i].getIdentifier()))
                return ArrayList[i];
        }
        throw new UserNotFoundException("Not ID");
    }

    @Override
    public User UserByIndex(int index) {
        return ArrayList[index];
    }

    @Override
    public int UsersNum() {
        return size;
    }
}
