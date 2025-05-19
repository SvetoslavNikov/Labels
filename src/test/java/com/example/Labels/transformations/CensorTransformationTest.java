package com.example.Labels.transformations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CensorTransformationTest {

    private CensorTransformation censor;

    @BeforeEach
    void setUp() {
        censor = new CensorTransformation("bad");
    }

    @Test
    void replacesSingleOccurrence() {
        assertEquals("This is a *** word.", censor.transform("This is a bad word."));
    }

    @Test
    void replacesMultipleOccurrences() {
        assertEquals(",***, *** *** *** *** ***", censor.transform(",Bad, baD bAd BAd bAD BAD"));
    }

    @Test
    void noMatchLeavesTextUnchanged() {
        assertEquals("This is b$a$d.", censor.transform("This is b$a$d."));
    }

    @Test
    void partialWordMatchNotAffected() {
        assertEquals("badge", censor.transform("badge"));
    }

    @Test
    void emptyInputThrowsIAExc() {
        assertThrows(IllegalArgumentException.class, () -> censor.transform(""));
    }

    @Test
    void nullInputThrowsIAExc() {
        assertThrows(IllegalArgumentException.class, () -> censor.transform(null));
    }
}
