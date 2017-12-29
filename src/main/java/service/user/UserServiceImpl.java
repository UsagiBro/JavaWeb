package service.user;

import dao.UserDao;
import exception.SuchUserExistsException;
import constants.WebConstants;
import entity.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User createUser(User user) throws SuchUserExistsException {
        if (userDao.userExists(user)) {
            throw new SuchUserExistsException(WebConstants.USER_EXISTS);
        }
        return userDao.createUser(user);
    }

}
