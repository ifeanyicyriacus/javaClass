package estore;

public abstract class User {
    private int age;
    private String emailAddress;
    private String name;
    private Address homeAddress;
    private String password;
    private String phone;

    public User (int age, String emailAddress, String name, Address homeAddress, String password, String phone) {
        this.age = age;
        this.emailAddress = emailAddress;
        this.name = name;
        this.homeAddress = homeAddress;
        this.password = password;
        this.phone = phone;
    }
}
