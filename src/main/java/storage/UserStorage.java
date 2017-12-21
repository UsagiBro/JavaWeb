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

    public boolean createUser(User user) {
        if (!users.containsValue(user)) {
            users.put(users.size(), user);
            return true;
        } else {
            return false;
        }
    }
}
