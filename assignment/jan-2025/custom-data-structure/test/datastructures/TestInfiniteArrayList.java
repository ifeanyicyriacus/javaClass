package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestInfiniteArrayList {
    InfiniteArrayList infiniteArrayList;

    @BeforeEach
    void setUp() {
        infiniteArrayList = new InfiniteArrayList();
    }

    @Test
    public void testInfiniteList_isEmpty() {
        assertTrue(infiniteArrayList.isEmpty());
    }

    @Test
    public void testInfiniteList_hasCapacityToStoreNewElement(){
        infiniteArrayList.add("hello");
        infiniteArrayList.add("world");
        assertFalse(infiniteArrayList.isEmpty());
        assertEquals(2, infiniteArrayList.size());
        infiniteArrayList.add("Belle");
        assertEquals(3, infiniteArrayList.size());
    }

    @Test
    public void testInfiniteList_storesElementInList(){
        assertFalse(infiniteArrayList.contains("Terve"));
        assertFalse(infiniteArrayList.contains("world"));
        infiniteArrayList.add("Terve");
        infiniteArrayList.add("world");
        assertTrue(infiniteArrayList.contains("Terve"));
        assertTrue(infiniteArrayList.contains("world"));
    }

    @Test
    public void testInfiniteList_removeElementFromList(){
        infiniteArrayList.add("Terve");
        infiniteArrayList.add("kaunis");
        infiniteArrayList.add("nainen");
        assertEquals(3, infiniteArrayList.size());
        assertTrue(infiniteArrayList.contains("nainen"));
        infiniteArrayList.remove("nainen");
        assertFalse(infiniteArrayList.contains("nainen"));
        assertEquals(2, infiniteArrayList.size());
    }

    @Test
    public void testInfiniteList_cantRemoveNonElementFromList(){
        infiniteArrayList.add("Terve");
        infiniteArrayList.add("kaunis");
        infiniteArrayList.add("nainen");
        assertEquals(3, infiniteArrayList.size());
        assertTrue(infiniteArrayList.contains("nainen"));
        infiniteArrayList.remove("Chairman");
        assertEquals(3, infiniteArrayList.size());

    }

    @Test
    public void testInfiniteList_canFetchElementFromList(){
        infiniteArrayList.add("Nigeria");
        infiniteArrayList.add("kaunis");
        infiniteArrayList.add("maa");
        assertEquals("kaunis", infiniteArrayList.get(1));
        assertEquals("Nigeria", infiniteArrayList.get(0));
    }

    @Test
    public void testInfiniteList_canClearAllElementsFromList(){
        infiniteArrayList.add("Nigeria");
        infiniteArrayList.add("kaunis");
        infiniteArrayList.add("Roosa");
        infiniteArrayList.add("poika");
        infiniteArrayList.clear();
        assertEquals(0, infiniteArrayList.size());
    }

    @Test
    public void testInfiniteList_canReturnElementFromListAsArray(){
        infiniteArrayList.add("Nigeria");
        infiniteArrayList.add("kaunis");
        infiniteArrayList.add("maa");
        infiniteArrayList.add("Roosa");
        assertArrayEquals(new String[] {"Nigeria", "kaunis", "maa", "Roosa"}, infiniteArrayList.toArray());
        infiniteArrayList.remove("maa");
        assertArrayEquals(new String[] {"Nigeria", "kaunis", "Roosa"}, infiniteArrayList.toArray());
        infiniteArrayList.clear();
        assertArrayEquals(new String[] {}, infiniteArrayList.toArray());
    }

    @Test
    public void testInfiniteList_canRemoveAllOccurrencesOfElementFromList(){
        infiniteArrayList.add("Nigeria");
        infiniteArrayList.add("kaunis");
        infiniteArrayList.add("maa");
        infiniteArrayList.add("Nigeria");
        infiniteArrayList.add("Nigeria");
        infiniteArrayList.add("maa");

        assertEquals(6, infiniteArrayList.size());
        infiniteArrayList.removeAll("Nigeria");
        assertEquals(3, infiniteArrayList.size());
        assertArrayEquals(
                new String[] {"kaunis", "maa", "maa"},
                infiniteArrayList.toArray()
        );
    }

    @Test
    public void testInfiniteList_supportInsertionBetweenElements() {
        infiniteArrayList.add("Nigeria");
        infiniteArrayList.add("kaunis");
        infiniteArrayList.add("maa");
        infiniteArrayList.insert(0, "Ivory Coast");
        assertEquals(4, infiniteArrayList.size());
        assertEquals("Ivory Coast", infiniteArrayList.get(0));
        assertEquals("maa", infiniteArrayList.get(3));
    }
}
