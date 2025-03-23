package data.repositories;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsersTest {

    Users users;

    @BeforeEach
    void setUp() {
        users = new Users();
    }

    @Test
    void testAUserCanBeAdded() {
        assertEquals(0, users.count());
        User user1 = new User(1, "username1", "password1");
        User savedUser = users.save(user1);
        assertEquals(user1, savedUser);
        assertEquals(1, users.count());
    }

    @Test
    void testUserCanBeDeletedOneAtATime() {
        assertEquals(0, users.count());
        User user1 = new User(1, "username1", "password1");
        User user2 = new User(2, "username2", "password2");
        users.save(user1);
        users.save(user2);
        assertEquals(2, users.count());
        users.delete(user1);
        assertEquals(1, users.count());
        users.delete(user2);
        assertEquals(0, users.count());
    }

    @Test
    void testAllUsersCanBeDeletedAtOnce() {
        assertEquals(0, users.count());
        User user1 = new User(1, "username1", "password1");
        User user2 = new User(2, "username2", "password2");
        users.save(user1);
        users.save(user2);
        assertEquals(2, users.count());
        users.deleteAll();
        assertEquals(0, users.count());
    }

    @Test
    void testSeveralUsersCanBeDeletedAtOnceByTheirIds() {
        assertEquals(0, users.count());
        User user1 = new User(1, "username1", "password1");
        User user2 = new User(2, "username2", "password2");
        User user3 = new User(3, "username3", "password3");
        users.save(user1);
        users.save(user2);
        users.save(user3);
        assertEquals(3, users.count());
        List<Integer> userIds = Arrays.asList(1, 3);
        users.deleteAllById(userIds);
        assertEquals(1, users.count());
    }

    @Test
    void deleteById() {
    }

    @Test
    void existsById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findAllById() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void saveAll() {
    }
}