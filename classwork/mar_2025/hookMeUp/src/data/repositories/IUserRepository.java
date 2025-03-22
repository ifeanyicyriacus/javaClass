package data.repositories;

import data.models.User;

import java.util.List;

public interface IUserRepository {
    long count();
    void delete(User user);
    void deleteAll();
    void deleteAll(List<User> users);
    void deleteAllById(List<Integer> ids);
    void deleteById(int id);
    boolean existsById(int id);
    List<User> findAll();
    List<User> findAllById(List<Integer> ids);
    User findById(int id);
    User save(User user);
    List<User> saveAll(List<User> users);
}
