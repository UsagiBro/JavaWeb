package service.user;

import dao.UserDao;
import exception.SuchUserExistsException;
import constants.Constants;
import entity.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Checks if user already exists in database, creates new if not
     * @param user entity o user to bew created
     * @return either old user if parameter user already exists in local storage, or inserted user if not
     * @throws SuchUserExistsException if user already exists in database
     */
    @Override
    public User createUser(User user) throws SuchUserExistsException {
        if (userDao.userExists(user)) {
            throw new SuchUserExistsException(Constants.USER_EXISTS);
        }
        return userDao.createUser(user);
    }
}
