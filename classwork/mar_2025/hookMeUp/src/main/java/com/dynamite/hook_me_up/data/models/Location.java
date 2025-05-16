package com.dynamite.hook_me_up.data.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@RequiredArgsConstructor
public class Location {
    @Id
    private String id;

    @Setter private String line1;
    @Setter private String line2;
    @Setter private String city;
    @Setter private String state;
    @Setter private String country;
}
