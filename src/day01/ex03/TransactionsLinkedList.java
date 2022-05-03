package day01.ex03;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList{

    private TransactionNode head = null;
    private int iter = 0;
    @Override
    public void TransactionAdd(Transaction transaction) {
        TransactionNode node = new TransactionNode(transaction, head);
        head = node;
        ++iter;
    }

    @Override
    public void TransactionDelete(UUID id) throws TransactionNotFoundException{
        TransactionNode tmp = head;
        TransactionNode prev = head;
        for (int i = 0; tmp != null; tmp = tmp.getNext(), i++) {
            if (id.equals(tmp.getData().getIdentifier()))
            {
                if (i == 0)
                {
                    tmp = tmp.getNext();
                    head = tmp;
                    --iter;
                    return ;
                }
                if (tmp.getNext() == null)
                {
                    prev.setNext(null);
                    --iter;
                    return ;
                }
                prev.setNext(tmp.getNext());
                --iter;
                return ;
            }
            prev = tmp;
        }
        throw new TransactionNotFoundException("Not ID");
    }

    @Override
    public Transaction[] TransformInto() {
        TransactionNode tmp = head;
        Transaction[] transactions = new Transaction[iter];

        for (int i = 0; i < iter; ++i, tmp = tmp.getNext()) {
            transactions[i] = tmp.getData();
        }
        return transactions;
    }
}

class TransactionNode
{
    private Transaction data;
    private TransactionNode next;

    public TransactionNode(Transaction data, TransactionNode next) {
        this.data = data;
        this.next = next;
    }

    public Transaction getData() {
        return data;
    }

    public void setData(Transaction data) {
        this.data = data;
    }

    public TransactionNode getNext() {
        return next;
    }

    public void setNext(TransactionNode next) {
        this.next = next;
    }
}