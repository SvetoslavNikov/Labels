package com.example.Labels.transformations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplaceTransformationTest {

    private ReplaceTransformation replaceTransformation;

    @BeforeEach
    void setUp() {
        replaceTransformation = new ReplaceTransformation("old", "new");
    }

    @Test
    void replacesTargetWithReplacement() {
        assertEquals("new world", replaceTransformation.transform("old world"));
    }

    @Test
    void replacesMultipleOccurrences() {
        assertEquals("new new world", replaceTransformation.transform("old old world"));
    }

    @Test
    void replacesTargetCaseInsensitive() {
        assertEquals("new World", replaceTransformation.transform("OlD World"));
        assertEquals("new world", replaceTransformation.transform("oLD world"));
    }

    @Test
    void noTargetFoundDoesNothing() {
        assertEquals("world", replaceTransformation.transform("world"));
    }

    @Test
    void emptyStringTargetThrowsIAExc() {
        assertThrows(IllegalArgumentException.class, () -> replaceTransformation.transform(""));
    }

    @Test
    void nullTargetInputThrowsIAExc() {
        assertThrows(IllegalArgumentException.class, () -> replaceTransformation.transform(null));
    }

    @Test
    void nullReplacementInputThrowsIAExc() {
        assertThrows(IllegalArgumentException.class, () -> new ReplaceTransformation("old", null));
    }
}
