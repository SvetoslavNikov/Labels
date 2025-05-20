package com.example.Test.TestingPatterns.Flyweight;

import java.awt.*;
import java.util.*;
import java.util.List;

//HOW NOT TO USE
/*
Without Flyweight:
Memory used: 91 MB
Time taken: 206 ms

With Flyweight:
Memory used: 291 MB
Time taken: 770 ms

Memory saved: -200 MB
Time saved: -564 ms
 */
/**
 * Improved demonstration of the Flyweight pattern
 * This example uses character formatting for a text editor as a use case
 */
public class TextEditorFlyweight {
    private static final int CHARACTERS_TO_INSERT = 1_000_000;
    private static final Random random = new Random();

    public static void main(String[] args) {
        // Test without Flyweight
        long startTime = System.currentTimeMillis();
        TextEditorWithoutFlyweight editorWithout = new TextEditorWithoutFlyweight();
        createDocument(editorWithout);
        long memoryWithout = measureMemory();
        long timeWithout = System.currentTimeMillis() - startTime;

        // Test with Flyweight
        startTime = System.currentTimeMillis();
        TextEditorWithFlyweight editorWith = new TextEditorWithFlyweight();
        createDocument(editorWith);
        long memoryWith = measureMemory();
        long timeWith = System.currentTimeMillis() - startTime;

        // Print results
        System.out.println("Without Flyweight:");
        System.out.println("Memory used: " + memoryWithout + " MB");
        System.out.println("Time taken: " + timeWithout + " ms");

        System.out.println("\nWith Flyweight:");
        System.out.println("Memory used: " + memoryWith + " MB");
        System.out.println("Time taken: " + timeWith + " ms");

        System.out.println("\nMemory saved: " + (memoryWithout - memoryWith) + " MB");
        System.out.println("Time saved: " + (timeWithout - timeWith) + " ms");
    }

    private static void createDocument(TextEditor editor) {
        // Create a document with random characters and formatting
        for (int i = 0; i < CHARACTERS_TO_INSERT; i++) {
            char character = (char) ('a' + random.nextInt(26));
            boolean isBold = random.nextBoolean();
            boolean isItalic = random.nextBoolean();
            int fontSize = 8 + random.nextInt(12); // Fonts between 8 and 20
            Color color = new Color(
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256)
            );
            String fontFamily = getRandomFontFamily();

            editor.addCharacter(character, fontFamily, fontSize, color, isBold, isItalic);
        }
    }

    private static String getRandomFontFamily() {
        String[] fonts = {"Arial", "Times New Roman", "Courier", "Verdana", "Calibri"};
        return fonts[random.nextInt(fonts.length)];
    }

    private static long measureMemory() {
        Runtime runtime = Runtime.getRuntime();
        // Suggest garbage collection to get a cleaner reading
        System.gc();
        System.gc(); // Run twice to be more thorough
        return (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
    }
}


// Interface for text editors
interface TextEditor {
    void addCharacter(char character, String fontFamily, int fontSize, Color color, boolean isBold, boolean isItalic);
}

/**
 * Implementation without using Flyweight pattern
 * Each character has its own formatting objects
 */
class TextEditorWithoutFlyweight implements TextEditor {
    private final List<CharacterWithoutFlyweight> characters = new ArrayList<>();

    @Override
    public void addCharacter(char character, String fontFamily, int fontSize, Color color, boolean isBold, boolean isItalic) {
        characters.add(new CharacterWithoutFlyweight(character, fontFamily, fontSize, color, isBold, isItalic));
    }
}

class CharacterWithoutFlyweight {
    private final char character;
    private final CharacterFormat format; // Each character has its own format object

    public CharacterWithoutFlyweight(char character, String fontFamily, int fontSize, Color color, boolean isBold, boolean isItalic) {
        this.character = character;
        this.format = new CharacterFormat(fontFamily, fontSize, color, isBold, isItalic);
    }
}

/**
 * This class would be repeated for each character without Flyweight
 */
class CharacterFormat {
    private final String fontFamily;
    private final int fontSize;
    private final Color color;
    private final boolean isBold;
    private final boolean isItalic;

    public CharacterFormat(String fontFamily, int fontSize, Color color, boolean isBold, boolean isItalic) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.color = color;
        this.isBold = isBold;
        this.isItalic = isItalic;
    }
}

/**
 * Implementation using Flyweight pattern
 * Character formats are shared between characters
 */
class TextEditorWithFlyweight implements TextEditor {
    private final List<CharacterWithFlyweight> characters = new ArrayList<>();
    private final CharacterFormatFactory formatFactory = new CharacterFormatFactory();

    @Override
    public void addCharacter(char character, String fontFamily, int fontSize, Color color, boolean isBold, boolean isItalic) {
        CharacterFormat format = formatFactory.getFormat(fontFamily, fontSize, color, isBold, isItalic);
        characters.add(new CharacterWithFlyweight(character, format));
    }
}

class CharacterWithFlyweight {
    private final char character;
    private final CharacterFormat format; // Reference to a shared format object

    public CharacterWithFlyweight(char character, CharacterFormat format) {
        this.character = character;
        this.format = format;
    }
}

/**
 * Factory that manages the flyweight objects (character formats)
 */
class CharacterFormatFactory {
    private final Map<String, CharacterFormat> formats = new HashMap<>();

    public CharacterFormat getFormat(String fontFamily, int fontSize, Color color, boolean isBold, boolean isItalic) {
        // Create a key for the format combination
        String key = fontFamily + fontSize + color.getRGB() + isBold + isItalic;

        // Return existing format if it exists
        if (!formats.containsKey(key)) {
            formats.put(key, new CharacterFormat(fontFamily, fontSize, color, isBold, isItalic));
        }

        return formats.get(key);
    }
}






