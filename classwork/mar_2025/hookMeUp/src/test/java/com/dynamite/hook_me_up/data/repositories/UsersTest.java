package com.dynamite.hook_me_up.data.repositories;

import main.data.models.User;
import main.data.repositories.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void TestUserCanBeDeletedById() {
        assertEquals(0, users.count());
        User user1 = new User(1, "username1", "password1");
        User user2 = new User(2, "username2", "password2");
        users.save(user1);
        users.save(user2);
        assertEquals(2, users.count());
        users.deleteById(2);
        assertEquals(1, users.count());
        assertFalse(users.existsById(2));
        assertTrue(users.existsById(1));
    }

    @Test
    void thatSeveralUsersInAListCanBeDeletedFromTheDatabase() {
        List<User> newUserList = new ArrayList<>();
        assertEquals(0, users.count());
        newUserList.add(new User(1, "username1", "password1"));
        newUserList.add(new User(2, "username2", "password2"));
        newUserList.add(new User(3, "username3", "password3"));
        users.saveAll(newUserList);
        assertEquals(3, users.count());
        users.deleteAll(newUserList);
    }

    @Test
    void thatSavedUserCanBeFound() {
        List<User> newUserList = new ArrayList<>();
        assertEquals(0, users.count());
        newUserList.add(new User(1, "username1", "password1"));
        newUserList.add(new User(2, "username2", "password2"));
        newUserList.add(new User(3, "username3", "password3"));
        users.saveAll(newUserList);
        assertArrayEquals(newUserList.toArray(), users.findAll().toArray());
        assertEquals(3, users.count());
        assertEquals(newUserList.getFirst().getId(), users.findById(1).getId());
    }

    @Test
    void findAllByIdReturnsCorrectValue() {
        List<User> newUserList = new ArrayList<>();
        assertEquals(0, users.count());
        newUserList.add(new User(1, "username1", "password1"));
        newUserList.add(new User(2, "username2", "password2"));
        newUserList.add(new User(3, "username3", "password3"));
        users.saveAll(newUserList);
        assertEquals(3, users.count());
        List<Integer> savedUsersIds = Arrays.asList(1, 2, 3);
        assertArrayEquals(newUserList.toArray(), users.findAllById(savedUsersIds).toArray());

    }

}