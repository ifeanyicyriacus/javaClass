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

    @Test
    public void testMap_gettingValueByCorrectKey() {
        map.add("name", "Valentine");
        map.add("height", "180");
        assertEquals("Valentine", map.get("name"));
        assertEquals("180", map.get("height"));
        assertNull(map.get("state"));
    }

    @Test
    public void testMap_returnsNullGettingWithIncorrectKey() {
        assertNull(map.get("state"));
    }

    @Test
    public void testMap_overwritingKeyValueIsSupportedButNotDuplicateKey(){
        map.add("name", "Valentine");
        assertEquals("Valentine", map.get("name"));
        map.add("name", "Kevin");
        assertEquals("Kevin", map.get("name"));
        assertEquals(1, map.size());
    }

    @Test
    public void testMap_canReturnItsKeysAndValues() {
        map.add("name", "Valentine");
        map.add("height", "180");
        map.add("school", "Semicolon");
        assertArrayEquals(
                new String[] {"name", "height", "school"},
                map.keys());
        assertArrayEquals(
                new String[] {"Valentine", "180", "Semicolon"},
                map.values());
    }

    @Test
    public void testMap_keysAreCaseSensitive() {
        map.add("name", "Valentine");
        map.add("height", "180");
        map.add("Name", "Valentine");
        assertEquals(3, map.size());
    }

    @Test
    public void testMap_canRemoveElementByKey(){
        map.add("name", "Valentine");
        map.add("height", "180");
        map.add("school", "Semicolon");
        map.add("town", "Sabo");
        assertEquals(4, map.size());
        map.remove("name");
        map.remove("school");
        assertEquals(2, map.size());
        assertArrayEquals(
                new String[][] {
                        {"height", "180"},
                        {"town", "Sabo"}
                },
                map.items()
        );
    }

    @Test
    public void testMap_canNotRemoveElementUsingIncorrectKey(){
        assertEquals(0, map.size());
        map.add("name", "Valentine");
        map.add("height", "180");
        map.add("school", "Semicolon");
        map.add("town", "Sabo");
        map.remove("name");
        assertNull(map.get("name"));
        assertEquals(3, map.size());
        map.remove("university");
        assertEquals(3, map.size());
    }

    @Test
    public void testMap_canDisplayMapInJSONFormat() {
        map.add("name", "Valentine");
        map.add("height", "180");
        map.add("school", "Semicolon");
        map.add("town", "Sabo Yaba");
        assertEquals(
                """
                        {
                        \t"name": "Valentine",
                        \t"height": "180",
                        \t"school": "Semicolon",
                        \t"town": "Sabo Yaba",
                        }
                        """,
                map.toString());
    }


}
