package estore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestCustomer {
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer();
    }

    @Test
    public void testCustomer_hasShoppingCart() {
        ShoppingCart shoppingCart = customer.getShoppingCart();
        assertNotNull(shoppingCart);
    }

    @Test
    public void testCustomer_hasBillingsAndItsIsEmpty() {
        ArrayList<Billing> billings = customer.getBillings();
        assertNotNull(billings);
        assertEquals(0, billings.size());
    }
}
