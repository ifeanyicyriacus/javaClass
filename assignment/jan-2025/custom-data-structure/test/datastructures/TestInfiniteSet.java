package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInfiniteSet {
    InfiniteSet set;

    @BeforeEach
    void setUp() {
        set = new InfiniteSet();
    }

    @Test
    public void testInfiniteSet_doesNotSupportDuplicateElements() {
        set.add("Apple");
        set.add("Banana");
        set.add("Apple");
        set.add("Banana");
        assertEquals(2, set.size);
        assertEquals(1, set.count("Apple"));
    }

    @Test
    public void testInfiniteSet_canAddElementsIntoSet() {
        String[] duplicates = {"Apple", "Banana", "Apple", "Guava", "Banana", "Apple" };
        set.add(duplicates);
        assertEquals(3, set.size);
        assertEquals(1, set.count("Apple"));
        assertEquals(1, set.count("Banana"));
        assertEquals(0, set.count("Pineapple"));
    }
}
