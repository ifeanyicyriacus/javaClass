package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestInfiniteStack{
    InfiniteStack infiniteStack;
    int capacity = 5;

    @BeforeEach
    public void setUp(){
        infiniteStack = new InfiniteStack(capacity);
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

    @Test
    public void testInfiniteStack_throwRuntimeException_Expect_RuntimeException(){
        infiniteStack.push("Terve");
        infiniteStack.push("Hi");
        infiniteStack.push("Hyva");
        infiniteStack.push("Herra");
        infiniteStack.push("Pollonen");
        assertThrowsExactly(RuntimeException.class, () -> infiniteStack.push("Hello"));
    }

    @Test
    public void testInfiniteStack_popReturnNullWhenEmpty(){
        assertTrue(infiniteStack.isEmpty());
        assertNull(infiniteStack.pop());
    }
}
