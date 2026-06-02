package com.timbuchalka;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @Test
    public void everyNthChar() {
        fail("This test has not been implemented");
    }

    @Test
    public void removePairs() {
//        fail("This test has not been implemented");
        Utilities util = new Utilities();
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
    }

    @Test
    public void converter() {
        fail("This test has not been implemented");
    }

    @Test
    public void nullIfOddLength() {
        fail("This test has not been implemented");
    }
}