package com.timbuchalka;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @Test
    public void everyNthChar() {
//        fail("This test has not been implemented");
        Utilities utils = new Utilities();
        char[] output = utils.everyNthChar(new  char[] {'h', 'e', 'l', 'l', 'o'}, 2);
//        assertEquals(new char[] { 'e', 'l'}, output); // assertEquals will fail as it check the same instance
        assertArrayEquals(new char[] { 'e', 'l'}, output);
        char[] output2 = utils.everyNthChar(new  char[] {'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @Test
    public void removePairs() {
//        fail("This test has not been implemented");
        Utilities util = new Utilities();
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertNull("Did not get null returned when argument passed was null", util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
    }

    @Test
    public void converter() {
        fail("This test has not been implemented");
    }

    @Test
    public void nullIfOddLength() {
//        fail("This test has not been implemented");
        Utilities util = new Utilities();
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }
}