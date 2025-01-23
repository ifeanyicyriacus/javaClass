package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInfiniteStack{
    InfiniteStack infiniteStack;

    @BeforeEach
    public void setUp(){
        infiniteStack = new InfiniteStack(5);
    }

    @Test
    public void testInfiniteStack_CanPushElementIntoStack(){
        infiniteStack.push("Hello");
        infiniteStack.push("World");
        infiniteStack.push("World");
        assertEquals(3, infiniteStack.size());
        assertEquals(2, infiniteStack.count("World"));
    }

    @Test
    public void testInfiniteStack_CanPopElementFromStack(){
        infiniteStack.push("Hello");
        infiniteStack.push("World");
        infiniteStack.push("World");
        assertEquals(3, infiniteStack.size());
        assertEquals(2, infiniteStack.count("World"));
        infiniteStack.pop();
        assertEquals(2, infiniteStack.size());
        assertEquals(1, infiniteStack.count("World"));
        infiniteStack.pop();
        assertEquals(1, infiniteStack.size());
        assertEquals(0, infiniteStack.count("World"));
    }

    @Test
    public void testInfiniteStack_CanPeekElementFromStack(){
        infiniteStack.push("Hello");
        infiniteStack.push("World");
        infiniteStack.push("Terve");
        assertEquals("Terve", infiniteStack.peek());
        assertEquals(3, infiniteStack.size());
    }

    @Test
    public void testPushXYZ_Pop_PushAB_Expect_XYAB(){
        infiniteStack.push("Hello");
        infiniteStack.push("World");
        infiniteStack.push("Wide");
        infiniteStack.pop();
        infiniteStack.push("Terve");
        infiniteStack.push("hyva");
        assertEquals(4, infiniteStack.size());
        assertArrayEquals(
                new String[] {"Hello", "World", "Terve", "hyva"},
                infiniteStack.toArray()
        );
    }
}
