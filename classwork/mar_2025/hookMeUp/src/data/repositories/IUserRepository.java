package data.repositories;

import data.models.User;

import java.util.List;

public interface IUserRepository {
    long count();
    void delete(User user);
    void deleteAll();
    void deleteAll(List<User> users);
    void deleteAllById(List<Integer> ids);
    void deleteById(long id);
    boolean existsById(long id);
    List<User> findAll();
    List<User> findAllById(List<Integer> ids);
    User findById(long id);
    User save(User user);
    List<User> saveAll(List<User> users);
    boolean existsByUsername(String username);
}
