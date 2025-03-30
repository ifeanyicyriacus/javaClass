package main.data.models;

import java.time.LocalDate;

public class Profile {
    private String    name;
    private EGender   gender;
    private LocalDate dateOfBirth;
    private Location    location;
    private EHeight   height;
    private EWeight   weight;

    public Profile() {}
    public Profile(String name, EGender gender, LocalDate dateOfBirth,
                   EHeight height, EWeight weight) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.location = new Location();
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EWeight getWeight() {
        return weight;
    }

    public void setWeight(EWeight weight) {
        this.weight = weight;
    }

    public EHeight getHeight() {
        return height;
    }

    public void setHeight(EHeight height) {
        this.height = height;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

}
