package service.user;

import dao.UserDao;
import service.validator.UserValidator;
import constants.Constants;
import storage.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private Map<String, String> errors = new HashMap<>();
    private UserDao userDao;
    private UserValidator userValidator;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
        userValidator = new UserValidator();
    }

    @Override
    public boolean createUser(User user) {
        userValidator.validate(user);
        errors.putAll(userValidator.getErrors());
        if (errors.isEmpty()) {
            if (userDao.createUser(user)) {
                return true;
            }
            errors.put(Constants.USER_EXISTS_KEY, Constants.USER_EXISTS);
        }
        return false;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

}
