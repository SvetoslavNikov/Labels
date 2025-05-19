package com.example.Labels.transformations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecorateTransformationTest {

    private DecorateTransformation decorateTransformation;

    @BeforeEach
    void setUp() {
        decorateTransformation = new DecorateTransformation();
    }

    @Test
    void addsDecorationToText() {
        assertEquals("-={ Hello World }=-", decorateTransformation.transform("Hello World"));
    }

    @Test
    void EmptyStringThrowsIAExc() {
        assertThrows(IllegalArgumentException.class, () -> decorateTransformation.transform(""));
    }

    @Test
    void NullInputThrowsIAExc() {
        assertThrows(IllegalArgumentException.class, () -> decorateTransformation.transform(null));
    }

    @Test
    void trimsInputBeforeDecoration() {
        assertEquals("-={ Trimmed text }=-", decorateTransformation.transform("  Trimmed text  "));
    }

    @Test
    void handlesWhitespaceOnlyInput() {
        assertEquals("-={  }=-", decorateTransformation.transform("   "));
    }
}
