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
    }
}
