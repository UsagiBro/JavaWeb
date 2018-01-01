package dao.local_storage.storage;

import entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserStorage {

    private Map<String, User> users;

    public UserStorage() {
        users = new HashMap<>();
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public User createUser(User user) {
           return users.put(UUID.randomUUID().toString(), user);
    }

    public boolean contains(User user) {
        return users.containsValue(user);
    }
}
