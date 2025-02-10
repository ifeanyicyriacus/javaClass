package estore;

import java.util.ArrayList;

public class Customer extends User {
    private ShoppingCart       shoppingCart = new ShoppingCart();
    private ArrayList<Billing> billings = new ArrayList<>();

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public ArrayList<Billing> getBillings() {
        return billings;
    }
}
