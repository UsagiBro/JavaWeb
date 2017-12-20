package service;

import dao.UserDao;
import dao.UserDaoImpl;
import exception.IncorrectIdException;
import exception.ValidationException;
import service.validator.user_validator.UserValidator;
import storage.entity.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    UserValidator userValidator;

    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        userDao = userDaoImpl;
        userValidator = new UserValidator();
    }

    @Override
    public void createUser(Integer id, User user) throws ValidationException {
        userValidator.validate(user);

        userDao.createUser(id, user);
    }

    private void validateId(int id) throws IncorrectIdException {
        if (id < 0) {
            throw new IncorrectIdException("Incorrect id!");
        }
    }
}
