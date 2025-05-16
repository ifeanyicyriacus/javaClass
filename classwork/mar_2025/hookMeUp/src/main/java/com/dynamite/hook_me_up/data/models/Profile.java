package com.dynamite.hook_me_up.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
public class Profile {
    @Id private String id;

    @Setter private String    name;
    @Setter private EGender   gender;
    @Setter private LocalDate dateOfBirth;
    @Setter private Location  location;
    @Setter private EHeight   height;
    @Setter private EWeight   weight;
}
