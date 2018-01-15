package dao.user.local_storage.storage;

import entity.User;

import java.util.*;

public class UserStorage {

    private Map<String, User> users;

    public UserStorage() {
        users = new HashMap<>();
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public boolean createUser(User user) {
        if (Objects.isNull(users.put(UUID.randomUUID().toString(), user))) {
            return true;
        }
        return false;
    }

    public boolean contains(User user) {
        return users.containsValue(user);
    }
}
