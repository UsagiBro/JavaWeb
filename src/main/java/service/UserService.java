package service;

import exception.ValidationException;
import storage.entity.User;

public interface UserService {

    void createUser(Integer id, User user) throws ValidationException;
}
