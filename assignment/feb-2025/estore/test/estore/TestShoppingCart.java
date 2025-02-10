package estore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestShoppingCart {
    ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void testShoppingCart_hasNoItems() {
        ArrayList<Item> items = shoppingCart.getItems();
        assertEquals(0, items.size());
    }
}
