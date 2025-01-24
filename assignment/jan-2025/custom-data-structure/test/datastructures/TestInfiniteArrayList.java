package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestInfiniteArrayList {
    InfiniteArrayList arrayList;

    @BeforeEach
    void setUp() {
        arrayList = new InfiniteArrayList();
    }

    @Test
    public void testInfiniteList_isEmpty() {
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testInfiniteList_hasCapacityToStoreNewElement(){
        arrayList.add("hello");
        arrayList.add("world");
        assertFalse(arrayList.isEmpty());
        assertEquals(2, arrayList.size());
        arrayList.add("Belle");
        assertEquals(3, arrayList.size());
    }

    @Test
    public void testInfiniteList_storesElementInList(){
        assertFalse(arrayList.contains("Terve"));
        assertFalse(arrayList.contains("world"));
        arrayList.add("Terve");
        arrayList.add("world");
        assertTrue(arrayList.contains("Terve"));
        assertTrue(arrayList.contains("world"));
    }

    @Test
    public void testInfiniteList_removeElementFromList(){
        arrayList.add("Terve");
        arrayList.add("kaunis");
        arrayList.add("nainen");
        assertEquals(3, arrayList.size());
        assertTrue(arrayList.contains("nainen"));
        arrayList.remove("nainen");
        assertFalse(arrayList.contains("nainen"));
        assertEquals(2, arrayList.size());
    }

    @Test
    public void testInfiniteList_cantRemoveNonElementFromList(){
        arrayList.add("Terve");
        arrayList.add("kaunis");
        arrayList.add("nainen");
        assertEquals(3, arrayList.size());
        assertTrue(arrayList.contains("nainen"));
        arrayList.remove("Chairman");
        assertEquals(3, arrayList.size());

    }

    @Test
    public void testInfiniteList_canFetchElementFromList(){
        arrayList.add("Nigeria");
        arrayList.add("kaunis");
        arrayList.add("maa");
        assertEquals("kaunis", arrayList.get(1));
        assertEquals("Nigeria", arrayList.get(0));
    }

    @Test
    public void testInfiniteList_canClearAllElementsFromList(){
        arrayList.add("Nigeria");
        arrayList.add("kaunis");
        arrayList.add("Roosa");
        arrayList.add("poika");
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testInfiniteList_canReturnElementFromListAsArray(){
        arrayList.add("Nigeria");
        arrayList.add("kaunis");
        arrayList.add("maa");
        arrayList.add("Roosa");
        assertArrayEquals(new String[] {"Nigeria", "kaunis", "maa", "Roosa"}, arrayList.toArray());
        arrayList.remove("maa");
        assertArrayEquals(new String[] {"Nigeria", "kaunis", "Roosa"}, arrayList.toArray());
        arrayList.clear();
        assertArrayEquals(new String[] {}, arrayList.toArray());
    }

    @Test
    public void testInfiniteList_canRemoveAllOccurrencesOfElementFromList(){
        arrayList.add("Nigeria");
        arrayList.add("kaunis");
        arrayList.add("maa");
        arrayList.add("Nigeria");
        arrayList.add("Nigeria");
        arrayList.add("maa");

        assertEquals(6, arrayList.size());
        arrayList.removeAll("Nigeria");
        assertEquals(3, arrayList.size());
        assertArrayEquals(
                new String[] {"kaunis", "maa", "maa"},
                arrayList.toArray()
        );
    }

    @Test
    public void testInfiniteList_supportInsertionBetweenElements() {
        arrayList.add("Nigeria");
        arrayList.add("kaunis");
        arrayList.add("maa");
        arrayList.insert(0, "Ivory Coast");
        assertEquals(4, arrayList.size());
        assertEquals("Ivory Coast", arrayList.get(0));
        assertEquals("maa", arrayList.get(3));
    }




}
