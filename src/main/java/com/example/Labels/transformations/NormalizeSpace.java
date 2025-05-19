package com.example.Labels.transformations;

public class NormalizeSpace implements TextTransformation{
    @Override
    public String transform(String text) {
        validateInput(text);
        // regex = 1 or more tabs
        text = text.replaceAll("\t+", " ");
        // regex = 2 or more spaces
        text = text.replaceAll(" {2,}", " ");
        return text;
    }
}
