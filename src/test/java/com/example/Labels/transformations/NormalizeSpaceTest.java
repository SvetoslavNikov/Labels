package com.example.Labels.transformations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalizeSpaceTest {

    private NormalizeSpace normalizeSpace;

    @BeforeEach
    void setUp() {
        normalizeSpace = new NormalizeSpace();
    }

    @Test
    void replacesMultipleSpacesWithSingle() {
        assertEquals("This is a test", normalizeSpace.transform("This   is   a   test"));
    }

    @Test
    void replacesJustMultipleSpacesOrTabsWithSingle() {
        assertEquals(" ", normalizeSpace.transform("\t       \t"));
    }

    @Test
    void replacesTabsAndNewlinesWithSpace() {
        assertEquals("Line one\nLine two", normalizeSpace.transform("Line\tone\nLine\ttwo"));
    }

    @Test
    void singleSpacesAreUnaffected() {
        assertEquals("Just one space", normalizeSpace.transform("Just one space"));
    }

    @Test
    void leadingAndTrailingWhitespaceBecomesSingleSpaces() {
        assertEquals(" Hello ", normalizeSpace.transform("   Hello   "));
    }

    @Test
    void emptyStringThrowsIAExc() {
        assertThrows(IllegalArgumentException.class, () -> normalizeSpace.transform(""));
    }

    @Test
    void nullInputThrowsIAExc() {
        assertThrows(IllegalArgumentException.class, () -> normalizeSpace.transform(null));
    }
}
