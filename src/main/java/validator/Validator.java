package validator;

import exception.ValidationException;

public interface Validator<T> {

    void validate(T field) throws ValidationException;
}
