package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInfiniteList {
    InfiniteList list;

    @BeforeEach
    void setUp() {
        list = new InfiniteList();
    }

    @Test
    public void testInfiniteList_supportReplacement() {
        list.add("Nigeria");
        assertEquals("Nigeria", list.get(0));
        list.add("kaunis");
        list.add("maa");
        list.replace(0, "Ivory Coast");
        assertEquals("Ivory Coast", list.get(0));
    }
}
