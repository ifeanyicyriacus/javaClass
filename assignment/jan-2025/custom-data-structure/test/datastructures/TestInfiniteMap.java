package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestInfiniteMap {
    InfiniteMap map;

    @BeforeEach
    void setUp() {
        map = new InfiniteMap();
    }

    @Test
    public void testMap_isEmpty() {
        assertTrue(map.isEmpty());
    }

    @Test
    public void testMap_initialCapacityAndSize() {
        assertEquals(2, map.capacity());
        assertEquals(0, map.size());
    }

    @Test
    public void testMap_addingToEmptyMap() {
        assertTrue(map.isEmpty());
        map.add("name", "Valentine");
        assertFalse(map.isEmpty());
        map.add("height", "180");
        map.add("state of origin", "Imo");
        assertEquals(3, map.size());
    }

//    @Test
//    public void testMap_
    //test overwrite key
    //test duplicate key not supported
    //test keys are case sensitive
//    find by index
    // get keys
    // get values

}
