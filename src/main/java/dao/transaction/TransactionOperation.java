package dao.transaction;

public interface TransactionOperation<T> {
    T performOperation();
}
