package com.example.Labels.transformations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapitalizeTest {

    private Capitalize capitalize;

    @BeforeEach
    void setUp() {
        capitalize = new Capitalize();
    }

    @Test
    void transformsLowercaseFirstLetter() {
        assertEquals("Hello", capitalize.transform("hello"));
    }

    @Test
    void leavesAlreadyUppercase() {
        assertEquals("Hello", capitalize.transform("Hello"));
    }

    @Test
    void singleLowercaseCharacter() {
        assertEquals("A", capitalize.transform("a"));
    }

    @Test
    void singleUppercaseCharacter() {
        assertEquals("A", capitalize.transform("A"));
    }

    @Test
    void SymbolCharacter() {
        assertEquals("\\:", capitalize.transform("\\:"));
        assertEquals("%~:", capitalize.transform("%~:"));
    }

    @Test
    void NumberCharacter(){
        assertEquals("123", capitalize.transform("123"));
    }

    @Test
    void nullInputThrowsIAExc() {
        assertThrows(IllegalArgumentException.class, () -> capitalize.transform(null));
    }

    @Test
    void emptyStringThrowsIAExc() {
        assertThrows(IllegalArgumentException.class,() -> { capitalize.transform("");});
    }
}
