package service.user;

import entity.User;
import exception.SuchUserExistsException;

public interface UserService {

    User createUser(User user) throws SuchUserExistsException;
}
