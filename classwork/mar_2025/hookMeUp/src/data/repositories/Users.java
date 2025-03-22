package data.repositories;

import data.models.User;

import java.util.List;

public class Users implements IUserRepository{

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteAll(List<User> users) {

    }

    @Override
    public void deleteAllById(List<Integer> ids) {

    }

    @Override
    public void deleteById(int id) {

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
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> saveAll(List<User> users) {
        return List.of();
    }
}
