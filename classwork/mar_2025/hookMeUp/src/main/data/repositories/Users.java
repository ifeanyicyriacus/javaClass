package main.data.repositories;

import main.data.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users implements IUserRepository{

    private final List<User> users = new ArrayList<>();
    
    @Override
    public long count() {
        return users.size();
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

    @Override
    public void deleteAll() {
        users.clear();
    }

    @Override
    public void deleteAll(List<User> users) {
        this.users.removeAll(users);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    public void deleteById(long id) {
        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public boolean existsById(long id) {
        return users.stream().anyMatch(user -> user.getId() == id);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public List<User> findAllById(List<Integer> ids) {
        return ids.stream()
                .map(this::findById)
                .collect(Collectors.toList());
    }

    @Override
    public User findById(long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public List<User> saveAll(List<User> users) {
        return users.stream().map(this::save).collect(Collectors.toList());
    }

    @Override
    public boolean existsByUsername(String username) {
        return users.stream()
                .anyMatch(user -> user.getUsername().equalsIgnoreCase(username));
    }
}
