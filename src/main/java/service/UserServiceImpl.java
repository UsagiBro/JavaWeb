package service;

import dao.UserDao;
import service.validator.UserValidator;
import service.validator.ValidationConstants;
import storage.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private Map<String, String> errors = new HashMap<String, String>();
    private UserDao userDao;
    private UserValidator userValidator;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
        userValidator = new UserValidator(errors);
    }

    @Override
    public boolean createUser(User user) {
        userValidator.validate(user);
        if (errors.isEmpty()) {
            if (!userDao.createUser(user)) {
                errors.put("email", ValidationConstants.USER_EXISTS);
                return true;
            }
        }
        return false;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

}
