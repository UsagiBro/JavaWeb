package service.user;

import dao.UserDao;
import exception.SuchUserExistsException;
import constants.WebConstants;
import entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean createUser(User user) throws SuchUserExistsException {
        return userDao.createUser(user);
    }

    @Override
    public User getUserByEmailAndPassword(String login, String password) {
        return null;
    }

}
