package services;

import data.repositories.Users;
import exceptions.DuplicateUsernameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    Users users;
    UserService userService;
    @BeforeEach
    void setUp() {
        users = new Users();
        userService = new UserService(users);
    }

    @Test
    void thatRegisteringNewUserIncreasesUsersCount() {
        assertEquals(0, users.count());
        userService.register("username", "password");
        assertEquals(1L, users.count());
    }

    @Test
    void thatRegisteringExistingUserThrowsDuplicateUsernameException() {
        userService.register("username", "password");
        assertEquals(1L, users.count());
        assertThrows(DuplicateUsernameException.class, () -> userService.register("username", "different password"));
        assertEquals(1L, users.count());
    }
}