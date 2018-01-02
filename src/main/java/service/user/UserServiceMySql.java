package service.user;

import constants.WebConstants;
import dao.UserDao;
import dao.transaction.TransactionManager;
import dao.transaction.TransactionOperation;
import entity.User;
import exception.SuchUserExistsException;

public class UserServiceMySql implements UserService {

    private TransactionManager transactionManager;
    private UserDao userDao;

    public UserServiceMySql(TransactionManager transactionManager, UserDao userDao) {
        this.transactionManager = transactionManager;
        this.userDao = userDao;
    }

    @Override
    public User createUser(User user) throws SuchUserExistsException {

        if (userDao.userExists(user)) {
            throw new SuchUserExistsException(WebConstants.USER_EXISTS);
        }
        transactionManager.processTransaction(() -> userDao.createUser(user) );
        return userDao.createUser(user);
    }
}
