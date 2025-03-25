package controllers;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    UserController userController;

    @BeforeEach
    void setUp() {
        userController = new UserController();

    }

    @Test
    void thatAUserCanBeRegisteredSuccessfully() {
        User newRegisteredUser = userController.register("John", "Doe");
        assertNotNull(newRegisteredUser);
        assertEquals("John", newRegisteredUser.getUsername());
        assertEquals("Doe", newRegisteredUser.getPassword());
        assertEquals(1l, newRegisteredUser.getId());
    }
}