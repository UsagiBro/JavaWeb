package service.user;

import constants.WebConstants;
import dao.UserDao;
import dao.transaction.TransactionManager;
import entity.User;
import exception.DBException;
import exception.SuchUserExistsException;

import java.sql.SQLException;
import java.util.List;

public class UserServiceMySql implements UserService {

    private TransactionManager transactionManager;
    private UserDao userDao;

    public UserServiceMySql(TransactionManager transactionManager, UserDao userDao) {
        this.transactionManager = transactionManager;
        this.userDao = userDao;
    }

    @Override
    public boolean createUser(User user) throws SuchUserExistsException {
        List<User> users = transactionManager.processTransaction(() -> userDao.readAllUsers());
        if (users.contains(user)) {
            throw new SuchUserExistsException(WebConstants.USER_EXISTS);
        }
        transactionManager.processTransaction(() -> userDao.createUser(user));
        return userDao.createUser(user);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) throws DBException {
        return transactionManager.processTransaction(() -> userDao.readUserByEmailAndPassword(email, password));
    }


}
