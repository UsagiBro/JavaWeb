package storage;

import storage.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    private Map<Integer, User> users;

    public UserStorage() {
        users = new HashMap<Integer, User>();
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void createUser(Integer id, User user) {
        users.put(id, user);
    }
}
