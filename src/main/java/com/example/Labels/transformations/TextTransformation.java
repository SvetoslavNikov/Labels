package com.example.Labels.transformations;

public interface TextTransformation {
    String transform(String text);
    default void validateInput(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Input in the transform method cannot be null or empty");
        }
    }
}

