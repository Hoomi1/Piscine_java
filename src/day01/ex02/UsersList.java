package day01.ex02;


public interface UsersList {
    void UserAdd(String Name, Integer Balance);
    User UserById(Integer id);
    User UserByIndex(int index);
    int UsersNum();
}
