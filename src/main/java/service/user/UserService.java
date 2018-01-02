package service.user;

import entity.User;
import exception.SuchUserExistsException;

public interface UserService {

    /**
     * Checks if user already exists in database, creates new if not
     * @param user entity o user to bew created
     * @return either old user if parameter user already exists in local storage, or inserted user if not
     * @throws SuchUserExistsException if user already exists in database
     */
    User createUser(User user) throws SuchUserExistsException;
}
