package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestInfiniteStack{
    InfiniteStack stack;
    int           capacity = 5;

    @BeforeEach
    public void setUp(){
        stack = new InfiniteStack(capacity);
    }

    @Test
    public void testInfiniteStack_CanPushElementIntoStack(){
        stack.push("Hello");
        stack.push("World");
        stack.push("World");
        assertEquals(3, stack.size());
        assertEquals(2, stack.count("World"));
    }

    @Test
    public void testInfiniteStack_CanPopElementFromStack(){
        stack.push("Hello");
        stack.push("World");
        stack.push("World");
        assertEquals(3, stack.size());
        assertEquals(2, stack.count("World"));
        assertEquals("World", stack.pop());
        assertEquals(2, stack.size());
        assertEquals(1, stack.count("World"));
        assertEquals("World", stack.pop());
        assertEquals(1, stack.size());
        assertEquals(0, stack.count("World"));
    }

    @Test
    public void testInfiniteStack_CanPeekElementFromStack(){
        stack.push("Hello");
        stack.push("World");
        stack.push("Terve");
        assertEquals("Terve", stack.peek());
        assertEquals(3, stack.size());
    }

    @Test
    public void testPushXYZ_Pop_PushAB_Expect_XYAB(){
        stack.push("Hello");
        stack.push("World");
        stack.push("Wide");
        assertEquals("Wide", stack.pop());
        stack.push("Terve");
        stack.push("hyva");
        assertEquals(4, stack.size());
        assertArrayEquals(
                new String[] {"Hello", "World", "Terve", "hyva"},
                stack.toArray()
        );
    }

    @Test
    public void testInfiniteStack_throwRuntimeException_Expect_RuntimeException(){
        assertEquals(5, stack.capacity);
        assertEquals(0, stack.size());
        stack.push("Terve");
        stack.push("Hi");
        stack.push("Hyva");
        stack.push("Herra");
        stack.push("Pollonen");
        assertEquals(5, stack.size());
        assertThrowsExactly(RuntimeException.class, () -> stack.push("Hello"));
    }

    @Test
    public void testInfiniteStack_popReturnNullWhenEmpty(){
        assertTrue(stack.isEmpty());
        assertNull(stack.pop());
    }
}
