package repository;

import model.Transaction;

public interface ITransactionRepository {

    Transaction saveTransaction(Transaction transaction);
}
