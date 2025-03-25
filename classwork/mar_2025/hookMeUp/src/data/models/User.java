package data.models;

public class User {
    private final long     id;
    private       String  username;
    private       String  password;

    private Profile profile;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public User(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.profile = new Profile();
    }
}
