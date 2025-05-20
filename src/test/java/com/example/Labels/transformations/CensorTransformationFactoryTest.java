package com.example.Labels.transformations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CensorTransformationFactoryTest{
    private CensorTransformationFactory ctfactory;

    @BeforeEach
    public void setCensorTransformationFactory(){
        ctfactory.clearCache();
    }

    @Test
    public void cachingStringsOf4OrLessChars(){
        TextTransformation t1 = ctfactory.createCensorTransformation(" ");
        TextTransformation t2 = ctfactory.createCensorTransformation("abc");
        TextTransformation t3 = ctfactory.createCensorTransformation("abcd");

        TextTransformation t11 = ctfactory.createCensorTransformation(" ");
        TextTransformation t22 = ctfactory.createCensorTransformation("abc");
        TextTransformation t33 = ctfactory.createCensorTransformation("abcd");
        assertSame(t1, t11);
        assertSame(t2, t22);
        assertSame(t3, t33);
    }

    @Test
    public void notCachingStringsAbove4Chars(){
        TextTransformation t1 = ctfactory.createCensorTransformation("abcde");
        TextTransformation t11 = ctfactory.createCensorTransformation("abcde");
        assertNotSame(t1, t11);
    }

    @Test
    public void nullInputThrowsIAExc(){
        assertThrows(IllegalArgumentException.class, () -> { ctfactory.createCensorTransformation(null);});
    }

    @Test
    public void emptyInputThrowsIAExc(){
        assertThrows(IllegalArgumentException.class, () -> { ctfactory.createCensorTransformation("");});
    }
}
