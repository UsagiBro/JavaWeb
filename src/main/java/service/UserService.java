package service;

import storage.entity.User;

import java.util.Map;

public interface UserService {

    boolean createUser(User user);

    Map<String, String> getErrors();
}
