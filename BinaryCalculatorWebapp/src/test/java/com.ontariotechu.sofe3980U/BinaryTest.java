package com.ontariotechu.sofe3980U;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTest {

    /**
     * Tests if the constructor correctly initializes a binary number.
     * Should remove leading zeros and default to "0" for invalid inputs.
     */
    @Test
    public void testConstructor() {
        assertEquals("101", new Binary("000101").getValue()); // Removes leading zeros
        assertEquals("0", new Binary("").getValue()); // Empty string should default to "0"
        assertEquals("1101", new Binary("1101").getValue()); // Valid input remains unchanged
        assertEquals("0", new Binary("abc").getValue()); // Invalid input defaults to "0"
    }

    /**
     * Tests the getValue() method to ensure it returns the correct binary string.
     */
    @Test
    public void testGetValue() {
        Binary bin = new Binary("1100");
        assertEquals("1100", bin.getValue());
    }

    /**
     * Tests the addition of two binary numbers.
     * 101 (5) + 110 (6) = 1011 (11)
     */
    @Test
    public void testAddition() {
        Binary result = Binary.add(new Binary("101"), new Binary("110"));
        assertEquals("1011", result.getValue());
    }

    /**
     * Tests multiplication of two binary numbers.
     * 10 (2) * 11 (3) = 110 (6)
     */
    @Test
    public void testMultiplication() {
        Binary result = Binary.multiply(new Binary("10"), new Binary("11"));
        assertEquals("110", result.getValue());
    }

    /**
     * Tests the bitwise AND operation.
     * 1101 (13) & 1011 (11) = 1001 (9)
     */
    @Test
    public void testBitwiseAnd() {
        Binary result = Binary.and(new Binary("1101"), new Binary("1011"));
        assertEquals("1001", result.getValue());
    }

    /**
     * Tests the bitwise OR operation.
     * 1101 (13) | 1011 (11) = 1111 (15)
     */
    @Test
    public void testBitwiseOr() {
        Binary result = Binary.or(new Binary("1101"), new Binary("1011"));
        assertEquals("1111", result.getValue());
    }
}
