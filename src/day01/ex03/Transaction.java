package day01.ex03;

import java.util.UUID;

public class Transaction
{
    private enum Transfer_category
    {
        debits,
        credits
    }
    private UUID Identifier;
    private User Recipient;
    private User Sender;
    private Integer Transfer_amount;
    private Transfer_category transfer_category;

    public Transaction(User recipient, User sender, Integer transfer_amount)
    {
        Identifier = UUID.randomUUID();
        Recipient = recipient;
        Sender = sender;
        Transfer_amount = transfer_amount;
        if (Sender.getBalance() >= transfer_amount) {
            if (transfer_amount > 0)
                setTransfer_category(Transfer_category.debits);
            else
                setTransfer_category(Transfer_category.credits);
        }
        else
        {
            System.out.println("No money");
            System.exit(0);
        }
    }

    public Transfer_category getTransfer_category() {
        return transfer_category;
    }

    public void setTransfer_category(Transfer_category transfer_category) {
        this.transfer_category = transfer_category;
    }

    public UUID getIdentifier()
    {
        return Identifier;
    }

    public void setIdentifier(UUID identifier)
    {
        Identifier = identifier;
    }

    public User getRecipient()
    {
        return Recipient;
    }

    public void setRecipient(User recipient)
    {
        Recipient = recipient;
    }

    public User getSender()
    {
        return Sender;
    }

    public void setSender(User sender)
    {
        Sender = sender;
    }

    public Integer getTransfer_amount()
    {
        return Transfer_amount;
    }

    public void setTransfer_amount(Integer transfer_amount)
    {
        Transfer_amount = transfer_amount;
    }

    @Override
    public String toString() {
        return "Transaction\n{" +
                "\n Recipient=" + Recipient.getName() +
                ",\n Sender=" + Sender.getName() +
                ",\n Transfer_amount=" + Transfer_amount +
                ",\n transfer_category=" + transfer_category +
                "\n BalanceRecipient=" + Recipient.getBalance() +
                "\n BalanceSender=" + Sender.getBalance() +
                "\n}";
    }


}
