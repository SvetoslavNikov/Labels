package com.example.Labels.transformations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeftTrimTest {

    private LeftTrim leftTrim;

    @BeforeEach
    void setUp() {
        leftTrim = new LeftTrim();
    }

    @Test
    void removesLeadingSpaces() {
        assertEquals("Text", leftTrim.transform("   Text"));
    }

    @Test
    void removesLeadingTabsAndSpaces() {
        assertEquals("Start", leftTrim.transform("\t  Start"));
    }

    @Test
    void leavesNoLeadingWhitespace() {
        assertEquals("Clean", leftTrim.transform("Clean"));
    }

    @Test
    void leavesTrailingWhitespaceUntouched() {
        assertEquals("Indented   ", leftTrim.transform("Indented   "));
    }

    @Test
    void allWhitespaceBecomesEmptyString() {
        assertEquals("", leftTrim.transform("     "));
    }

    @Test
    void emptyStringThrowsIAExc() {
        assertThrows(IllegalArgumentException.class, () -> leftTrim.transform(""));
    }

    @Test
    void nullInputThrowsIAExc() {
        assertThrows(IllegalArgumentException.class, () -> leftTrim.transform(null));
    }
}
