package com.example.Labels.transformations;

public class DecorateTransformation implements TextTransformation{

    @Override
    public String transform(String text) {
        validateInput(text);
        return "-={ " + text.trim() + " }=-";
    }
}
