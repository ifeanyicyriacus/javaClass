package main.services;

import main.data.models.User;

public interface IUserService {

    User register(String username, String password);
}
