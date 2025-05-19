package com.example.Labels.transformations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RightTrimTest {

    private RightTrim rightTrim;

    @BeforeEach
    void setUp() {
        rightTrim = new RightTrim();
    }

    @Test
    void removesTrailingSpaces() {
        assertEquals("Hello", rightTrim.transform("Hello   "));
    }

    @Test
    void removesTrailingTabsAndSpaces() {
        assertEquals("End", rightTrim.transform("End \t  "));
    }

    @Test
    void leavesNoTrailingWhitespace() {
        assertEquals("Clean", rightTrim.transform("Clean"));
    }

    @Test
    void leavesLeadingWhitespaceUntouched() {
        assertEquals("  Indented", rightTrim.transform("  Indented   "));
    }

    @Test
    void allWhitespaceBecomesEmptyString() {
        assertEquals("", rightTrim.transform("     "));
    }

    @Test
    void emptyStringThrowsIAExc() {
        assertThrows(IllegalArgumentException.class, () -> rightTrim.transform(""));
    }

    @Test
    void nullInputThrowsIAExc() {
        assertThrows(IllegalArgumentException.class, () -> rightTrim.transform(null));
    }
}
