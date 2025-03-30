package main.controllers;

import main.data.models.User;
import main.services.IUserService;
import main.services.UserService;

public class UserController {
    final private IUserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User register(String username, String password){
        return userService.register(username, password);
    }
}
