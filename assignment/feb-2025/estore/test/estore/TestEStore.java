package estore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestEStore {
    private EStore eStore;
    private ArrayList<User> users;
    @BeforeEach
    public void setUp() {
        eStore = new EStore();
        users = eStore.getUsers();
    }

    @Test
    public void testEStore_HasListOfUserWhenCreated(){
        assertNotNull(users);
        assertEquals(0, users.size());
    }

    @Test
    public void testEStore_UsersCouldBeBothSellerOrAdminAndCustomer(){
        Seller seller = new Seller();
        Customer customer = new Customer();
        assertNotNull(users);
        users.add(seller);
        users.add(customer);
        assertEquals(2, users.size());
    }
}
