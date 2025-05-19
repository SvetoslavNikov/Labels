package com.example.Labels.transformations;

public class RightTrim implements TextTransformation{
    @Override
    public String transform(String text) {
        validateInput(text);
        return text.replaceAll("\\s+$","");
    }
}
