package com.ledger.geektrust.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void shouldCeilFloatToInt() {
        assertEquals(10, Util.cielFloat(9.32f));
    }

    @Test
    void shouldCeilDoubleToInt() {
        assertEquals(10, Util.cielDouble(9.32d));
    }

}