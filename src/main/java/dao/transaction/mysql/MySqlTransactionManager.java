package dao.transaction.mysql;

import dao.ConnectionHolder;
import dao.transaction.TransactionManager;
import dao.transaction.TransactionOperation;
import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MySqlTransactionManager implements TransactionManager {

    private DataSource dataSource;
    private static final Logger LOG = Logger.getLogger(MySqlTransactionManager.class);

    public MySqlTransactionManager() {
        init();
    }

    @Override
    public void init() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/KKK");
        } catch (NamingException e) {
            LOG.error(e.getMessage());
            System.err.println("Can't get datasource");
        }
    }

    @Override
    public <T> T processTransaction(TransactionOperation<T> operation) {
        T res = null;
        Connection con = null;

        try {
            con = dataSource.getConnection();
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            ConnectionHolder.setConnection(con);

            res = operation.performOperation();

            con.commit();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            rollback(con);
        } finally {
            closeConnection(con);
        }
        return res;
    }

    @Override
    public void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            System.err.println("Can't close connection!");
        }
    }

    @Override
    public void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException e) {
                LOG.error(e.getMessage());
                System.err.println("Can't rollback transaction!");
            }
        }
    }
}
