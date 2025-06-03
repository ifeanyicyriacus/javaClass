package filestorage;

public class UserDto {

    private String firstName;
    private String lastName;

    public UserDto(User user) {
        firstName = user.getFirstName();
        lastName = user.getLastName();
    }

    @Override
    public String toString() {
        return "["+firstName + " " + lastName+"]\n";
    }
}
