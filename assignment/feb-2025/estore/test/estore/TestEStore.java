package estore;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestEStore {


    @Test
    public void testEStore_HasListOfUserWhenCreated(){
        EStore eStore = new EStore();
        ArrayList<User> users = eStore.getUsers();
        assertNotNull(users);
        assertEquals(0, users.size());
    }
}
