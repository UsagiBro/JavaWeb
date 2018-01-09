package service.user;

import constants.ErrorMessages;
import dao.UserDao;
import dao.transaction.TransactionManager;
import entity.User;
import exception.DBException;
import exception.SuchUserExistsException;

public class MySqlUserService implements UserService {

    private TransactionManager transactionManager;
    private UserDao userDao;

    public MySqlUserService(TransactionManager transactionManager, UserDao userDao) {
        this.transactionManager = transactionManager;
        this.userDao = userDao;
    }

    @Override
    public boolean createUser(User user) throws SuchUserExistsException {
        if (transactionManager.processTransaction(() -> userDao.userExists(user))) {
            throw new SuchUserExistsException(ErrorMessages.USER_EXISTS);
        }
        return transactionManager.processTransaction(() -> userDao.createUser(user));
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) throws DBException {
        return transactionManager.processTransaction(() -> userDao.readUserByEmailAndPassword(email, password));
    }


}
