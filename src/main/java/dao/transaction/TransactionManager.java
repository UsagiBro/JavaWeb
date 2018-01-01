package dao.transaction;

import java.sql.Connection;

public interface TransactionManager {

    void init();

    <T> T processTransaction(TransactionOperation<T> operation);

    void closeConnection(Connection con);

    void rollback(Connection con);
}
