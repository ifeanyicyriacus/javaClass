package controllers;

import data.models.User;
import services.IUserService;
import services.UserService;

public class UserController {
    final private IUserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User register(String username, String password){
        return userService.register(username, password);
    }
}
