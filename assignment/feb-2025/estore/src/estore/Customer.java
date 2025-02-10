package estore;

import java.util.ArrayList;

public class Customer extends User {
    private ShoppingCart       shoppingCart;
    private ArrayList<Billing> billings;

    public Customer(ShoppingCart shoppingCart, ArrayList<Billing> billings, int age, String emailAddress,
                    String name, Address homeAddress, String password, String phone) {
        super(age, emailAddress, name, homeAddress, password, phone);
        this.shoppingCart = shoppingCart;
        this.billings = billings;
    }
}
