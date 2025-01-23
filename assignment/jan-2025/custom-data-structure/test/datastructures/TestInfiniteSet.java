package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInfiniteSet {
    InfiniteSet infiniteSet;

    @BeforeEach
    void setUp() {
        infiniteSet = new InfiniteSet();
    }

    @Test
    public void testInfiniteSet_doesNotSupportDuplicateElements() {
        infiniteSet.add("Apple");
        infiniteSet.add("Banana");
        infiniteSet.add("Apple");
        infiniteSet.add("Banana");
        assertEquals(2, infiniteSet.size);
    }
}
