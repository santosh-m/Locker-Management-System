package repository;

import model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository implements ITransactionRepository {

    private final List<Transaction> transactionList;

    public TransactionRepository(List<Transaction> transactionList) {
        this.transactionList = new ArrayList<>();
    }

    public Transaction saveTransaction(Transaction transaction){
        transactionList.add(transaction);
        return transaction;
    }

}
