package com.dynamite.hook_me_up.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;

public class User {
    @Id
    private long id;

    @Setter @Getter private String  username;
    @Setter         private String  password;
    @Setter @Getter private Profile profile;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.profile  = new Profile();
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, username='%s', password='%s', profileId='%s']",
                id, username, password, profile.getId()
        );
    }
}
