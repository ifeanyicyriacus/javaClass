package main.services;

import main.data.models.User;
import main.data.repositories.Users;
import main.exceptions.DuplicateUsernameException;

public class UserService implements IUserService {

    private final Users users;

    public UserService(Users users) {
        this.users = users;
    }

    @Override
    public User register(String username, String password) {
        if (isExists(username)) throw new DuplicateUsernameException("Username already exists");
        User newUser = new User(generateId(), username, password);
        return users.save(newUser);
    }

    private boolean isExists(String username) {
        return users.existsByUsername(username);
    }

    private long generateId() {
        return users.count() + 1;
    }
}
