package day01.ex03;

import java.util.UUID;

public interface TransactionsList {
    void TransactionAdd(Transaction transaction);
    void TransactionDelete(UUID id);
    Transaction[] TransformInto();
}
