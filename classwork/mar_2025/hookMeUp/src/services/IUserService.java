package services;

import data.models.User;

public interface IUserService {

    User register(String username, String password);
}
