package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestInfiniteList {
    InfiniteList infiniteList;

    @BeforeEach
    void setUp() {
        infiniteList = new InfiniteList();
    }

    @Test
    public void testInfiniteList_isEmpty() {
        assertTrue(infiniteList.isEmpty());
    }

    @Test
    public void testInfiniteList_hasCapacityToStoreNewElement(){
        infiniteList.add("hello");
        infiniteList.add("world");
        assertFalse(infiniteList.isEmpty());
        assertEquals(2, infiniteList.size());
        infiniteList.add("Belle");
        assertEquals(3, infiniteList.size());
    }

    @Test
    public void testInfiniteList_storesElementInList(){
        assertFalse(infiniteList.contains("Terve"));
        assertFalse(infiniteList.contains("world"));
        infiniteList.add("Terve");
        infiniteList.add("world");
        assertTrue(infiniteList.contains("Terve"));
        assertTrue(infiniteList.contains("world"));
    }

    @Test
    public void testInfiniteList_removeElementFromList(){
        infiniteList.add("Terve");
        infiniteList.add("kaunis");
        infiniteList.add("nainen");
        assertEquals(3, infiniteList.size());
        assertTrue(infiniteList.contains("nainen"));
        infiniteList.remove("nainen");
        assertFalse(infiniteList.contains("nainen"));
        assertEquals(2, infiniteList.size());
    }

    @Test
    public void testInfiniteList_cantRemoveNonElementFromList(){
        infiniteList.add("Terve");
        infiniteList.add("kaunis");
        infiniteList.add("nainen");
        assertEquals(3, infiniteList.size());
        assertTrue(infiniteList.contains("nainen"));
        infiniteList.remove("Chairman");
        assertEquals(3, infiniteList.size());

    }

    @Test
    public void testInfiniteList_canFetchElementFromList(){
        infiniteList.add("Nigeria");
        infiniteList.add("kaunis");
        infiniteList.add("maa");
        assertEquals("kaunis", infiniteList.get(1));
        assertEquals("Nigeria", infiniteList.get(0));
    }
}
