package day01.ex03;

public class Program {

    public static void main(String[] args) {
        User user1 = new User("Bob", 100);
        User user2 = new User("Bot", 100);

        Transaction transaction1 = new Transaction(user1, user2, 10);
        Transaction transaction2 = new Transaction(user2, user1, 20);
        Transaction transaction3 = new Transaction(user1, user2, 30);
        Transaction transaction4 = new Transaction(user2, user1, 40);
        Transaction transaction5 = new Transaction(user1, user2, 50);

        TransactionsLinkedList linkedList = new TransactionsLinkedList();
        linkedList.TransactionAdd(transaction1);
        linkedList.TransactionAdd(transaction2);
        linkedList.TransactionAdd(transaction3);
        linkedList.TransactionAdd(transaction4);
        linkedList.TransactionAdd(transaction5);

        linkedList.TransactionDelete(transaction1.getIdentifier());
        Transaction[] transactions = linkedList.TransformInto();

        for (int i = 0; i < transactions.length; i++) {
            System.out.println(transactions[i].toString());
        }
    }
}
