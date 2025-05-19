//package com.wiser.figures.TestingPatterns.Flyweight;
//
//import java.awt.Color;
//import java.util.*;
////The Flyweight pattern only saves memory when many objects can use the same few shared pieces.
////If everything is unique, it actually wastes memory.
//
///**
// * Improved Flyweight pattern demonstration with more controlled parameters
// * and better measurement techniques
// */
//public class OptimizedFlyweightDemo {
//    // A smaller number of objects to create but still sufficient to show differences
//    private static final int OBJECTS_TO_CREATE = 5_000_000;
//
//    // Very important: Limit the number of possible combinations to demonstrate flyweight benefits
//    private static final int POSSIBLE_FONT_STYLES = 10;
//    private static final int POSSIBLE_COLORS = 5;
//
//    private static final Random random = new Random(42); // Fixed seed for reproducibility
//
//    public static void main(String[] args) {
//        // Clean up before tests
//        System.gc();
//        System.gc();
//
//        System.out.println("Starting memory test with " + OBJECTS_TO_CREATE + " objects");
//        System.out.println("Possible combinations: " + POSSIBLE_FONT_STYLES + " styles × " +
//                POSSIBLE_COLORS + " colors = " + (POSSIBLE_FONT_STYLES * POSSIBLE_COLORS));
//
//        // Test without flyweight first
//        testWithoutFlyweight();
//
//        // Force garbage collection before next test
//        System.gc();
//        System.gc();
//
//        // Test with flyweight
//        testWithFlyweight();
//    }
//
//    private static void testWithoutFlyweight() {
//        long startMemory = getUsedMemory();
//        long startTime = System.currentTimeMillis();
//
//        // Create objects without flyweight pattern (each with its own style object)
//        List<TextCharacter> characters = new ArrayList<>(OBJECTS_TO_CREATE);
//        for (int i = 0; i < OBJECTS_TO_CREATE; i++) {
//            char c = (char) ('A' + random.nextInt(26));
//            int styleId = random.nextInt(POSSIBLE_FONT_STYLES);
//            int colorId = random.nextInt(POSSIBLE_COLORS);
//
//            // Create a new style object for each character
//            TextStyle style = new TextStyle(styleId, new Color(colorId * 50, colorId * 50, colorId * 50));
//            characters.add(new TextCharacter(c, style));
//        }
//
//        long endTime = System.currentTimeMillis();
//        long endMemory = getUsedMemory();
//
//        System.out.println("\nWithout Flyweight:");
//        System.out.println("Memory used: " + (endMemory - startMemory) + " MB");
//        System.out.println("Time taken: " + (endTime - startTime) + " ms");
//        System.out.println("Total objects: " + characters.size() + " characters + " +
//                characters.size() + " styles = " + (characters.size() * 2));
//    }
//
//    private static void testWithFlyweight() {
//        long startMemory = getUsedMemory();
//        long startTime = System.currentTimeMillis();
//
//        // Create a flyweight factory
//        TextStyleFactory styleFactory = new TextStyleFactory();
//
//        // Create objects with flyweight pattern (shared style objects)
//        List<FlyweightTextCharacter> characters = new ArrayList<>(OBJECTS_TO_CREATE);
//        for (int i = 0; i < OBJECTS_TO_CREATE; i++) {
//            char c = (char) ('A' + random.nextInt(26));
//            int styleId = random.nextInt(POSSIBLE_FONT_STYLES);
//            int colorId = random.nextInt(POSSIBLE_COLORS);
//
//            // Get a shared style object
//            TextStyle style = styleFactory.getTextStyle(styleId, new Color(colorId * 50, colorId * 50, colorId * 50));
//            characters.add(new FlyweightTextCharacter(c, style));
//        }
//
//        long endTime = System.currentTimeMillis();
//        long endMemory = getUsedMemory();
//
//        System.out.println("\nWith Flyweight:");
//        System.out.println("Memory used: " + (endMemory - startMemory) + " MB");
//        System.out.println("Time taken: " + (endTime - startTime) + " ms");
//        System.out.println("Total objects: " + characters.size() + " characters + " +
//                styleFactory.getStyleCount() + " styles = " +
//                (characters.size() + styleFactory.getStyleCount()));
//    }
//
//    private static long getUsedMemory() {
//        // Run garbage collection to get more accurate memory measurements
//        System.gc();
//        System.gc();
//
//        Runtime runtime = Runtime.getRuntime();
//        return (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
//    }
//}
//
///**
// * Class representing a character in text without flyweight pattern
// */
//class TextCharacter {
//    private final char character;
//    private final TextStyle style;  // Each character has its own style
//
//    public TextCharacter(char character, TextStyle style) {
//        this.character = character;
//        this.style = style;
//    }
//
//    // getters omitted for brevity
//}
//
///**
// * Class representing a character in text with flyweight pattern
// */
//class FlyweightTextCharacter {
//    private final char character;
//    private final TextStyle style;  // Reference to a shared style object
//
//    public FlyweightTextCharacter(char character, TextStyle style) {
//        this.character = character;
//        this.style = style;
//    }
//
//    // getters omitted for brevity
//}
//
///**
// * The flyweight object - contains the intrinsic state that can be shared
// */
//class TextStyle {
//    private final int styleId;
//    private final Color color;
//
//    public TextStyle(int styleId, Color color) {
//        this.styleId = styleId;
//        this.color = color;
//    }
//
//    // getters omitted for brevity
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TextStyle textStyle = (TextStyle) o;
//        return styleId == textStyle.styleId && Objects.equals(color, textStyle.color);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(styleId, color);
//    }
//}
//
///**
// * Factory for managing flyweight objects
// */
//class TextStyleFactory {
//    private final Map<Integer, TextStyle> styles = new HashMap<>();
//
//    public TextStyle getTextStyle(int styleId, Color color) {
//        // Simple hash for style lookup
//        int key = Objects.hash(styleId, color.getRGB());
//
//        if (!styles.containsKey(key)) {
//            styles.put(key, new TextStyle(styleId, color));
//        }
//
//        return styles.get(key);
//    }
//
//    public int getStyleCount() {
//        return styles.size();
//    }
//}
