package service.user;

import entity.User;
import exception.DBException;
import exception.SuchUserExistsException;

public interface UserService {

    boolean createUser(User user) throws SuchUserExistsException;

    User getUserByEmailAndPassword(String email, String password) throws DBException;
}
