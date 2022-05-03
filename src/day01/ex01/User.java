package day01.ex01;

public class User {
    private Integer Identifier = 0;
    private String  Name;
    private Integer Balance = 0;

    public User(String Name, Integer Balance) {
        Identifier += UserIdsGenerator.getInstance().generateId();
        this.Name = Name;
        if (Balance > 0)
            this.Balance = Balance;
    }

    public Integer getIdentifier()
    {
        return Identifier;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public Integer getBalance()
    {
        return Balance;
    }

    public void setBalance(Integer Balance)
    {
        this.Balance = Balance;
    }
}
