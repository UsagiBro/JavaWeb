package dao.myslq;

import dao.DaoFactory;
import dao.UserDao;
import exception.DBStartupException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MySqlDaoFactory implements DaoFactory {

    private DataSource dataSource;

    public MySqlDaoFactory() throws DBStartupException {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/KKK");
        } catch (NamingException e) {
            throw new DBStartupException("Can't start database!", e);
        }
    }

    @Override
    public UserDao getUserDao() {
        return new UserDaoMysql();
    }
}
