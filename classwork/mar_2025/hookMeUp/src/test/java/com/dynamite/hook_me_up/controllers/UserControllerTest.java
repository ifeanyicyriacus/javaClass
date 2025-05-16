package com.dynamite.hook_me_up.controllers;

import main.controllers.UserController;
import main.data.models.User;
import main.data.repositories.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    Users users;
    UserService    userService;
    UserController userController;

    @BeforeEach
    void setUp() {
        users = new Users();
        userService = new UserService(users);
        userController = new UserController(userService);
    }

    @Test
    void thatAUserCanBeRegisteredSuccessfully() {
        assertEquals(0, users.count());
        User newRegisteredUser = userController.register("John", "Doe");
        assertNotNull(newRegisteredUser);
        assertEquals("John", newRegisteredUser.getUsername());
        assertEquals("Doe", newRegisteredUser.getPassword());
        assertEquals(1L, newRegisteredUser.getId());
        assertEquals(1, users.count());
    }
}