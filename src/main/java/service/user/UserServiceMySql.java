package service.user;

import constants.WebConstants;
import dao.UserDao;
import dao.transaction.TransactionManager;
import entity.User;
import exception.DBException;
import exception.SuchUserExistsException;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class UserServiceMySql implements UserService {

    private TransactionManager transactionManager;
    private UserDao userDao;

    public UserServiceMySql(TransactionManager transactionManager, UserDao userDao) {
        this.transactionManager = transactionManager;
        this.userDao = userDao;
    }

    @Override
    public boolean createUser(User user) throws SuchUserExistsException {
        if (transactionManager.processTransaction(() -> userDao.userExists(user))) {
            throw new SuchUserExistsException(WebConstants.USER_EXISTS);
        }
        return transactionManager.processTransaction(() -> userDao.createUser(user));
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) throws DBException {
        return transactionManager.processTransaction(() -> userDao.readUserByEmailAndPassword(email, password));
    }


}
