package com.civm;

import org.junit.jupiter.api.Test;

import static com.civm.Main.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MainTest {

    @Test
    void testBinaryAddition() {
        int actual = binaryAddition("10", "11");
        int expected = 101;
        assertEquals(expected, actual);
    }

    @Test
    void testBinaryToDecimal() {
        int actual = binaryToDecimal("10");
        int expected = 2;
        assertEquals(expected, actual);

        actual = binaryToDecimal("101");
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void testStringToInt() {
        int actual = stringToInt("11");
        int expected = 11;
        assertEquals(expected, actual);
    }

    @Test
    void testDecimalToBinary() {
        int actual = decimalToBinary(5);
        int expected = 101;
        assertEquals(expected, actual);
    }
}