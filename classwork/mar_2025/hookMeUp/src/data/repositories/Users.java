package data.repositories;

import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class Users implements IUserRepository{

    List<User> users = new ArrayList<User>();
    
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

    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    public void deleteById(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public boolean existsById(int id) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public List<User> findAllById(List<Integer> ids) {
        return List.of();
    }

    @Override
    public User findById(int id) {
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
        return List.of();
    }
}
