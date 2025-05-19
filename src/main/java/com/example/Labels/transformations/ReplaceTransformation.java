package com.example.Labels.transformations;

import java.util.regex.Pattern;

public class ReplaceTransformation implements TextTransformation{
    private String target;
    private String replacement;

    public ReplaceTransformation(String target, String replacement){
        if(target == null || target.isEmpty()){
            throw new IllegalArgumentException("Invalid target! Target can't be null");
        }
        if(replacement == null){
            throw new IllegalArgumentException("Invalid replacement! Replacement can't be null");
        }
        this.target = target;
        this.replacement = replacement;
    }

    @Override
    public String transform(String text) {
        validateInput(text);
        text = text.replaceAll("(?i)" + Pattern.quote(target), replacement); // (?i) makes it case-insensitive
        return text;
    }

}
