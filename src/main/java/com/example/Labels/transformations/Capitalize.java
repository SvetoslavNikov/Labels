package com.example.Labels.transformations;

public class Capitalize implements TextTransformation{
    @Override
    public String transform(String text) {
        validateInput(text);
        if(text == null || text.isEmpty()){
            throw new IllegalArgumentException("Wrong input! Null or empty String.");
        }
        if(text.charAt(0) >= 'a' && text.charAt(0) <= 'z'){
            text = Character.toUpperCase(text.charAt(0))+text.substring(1);
        }
        return text;
    }
}
