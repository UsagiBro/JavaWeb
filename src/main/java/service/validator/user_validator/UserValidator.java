package service.validator.user_validator;

import exception.ValidationException;
import service.validator.Validator;
import storage.entity.User;

public class UserValidator implements Validator<User> {

    private UserPasswordValidator userPasswordValidator = new UserPasswordValidator();
    private UserNameValidator userNameValidator = new UserNameValidator();
    private UserEmailValidator userEmailValidator = new UserEmailValidator();


    @Override
    public void validate(User user) throws ValidationException {
        userEmailValidator.validate(user.getEmail());
        userNameValidator.validate(user.getName());
        userNameValidator.validate(user.getSurname());
        userPasswordValidator.validate(user.getPassword());
    }
}
