package controllers;

import data.models.User;
import data.repositories.Users;
import services.UserService;

public class UserController {
    Users users;

    public UserController() {
//        i expected the controller to not initialise the users but to read from db
        users = new Users();
    }

    public User register(String username, String password){
        UserService userService = new UserService(users);
        return userService.register(username, password);
    }
}
