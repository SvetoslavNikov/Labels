package com.example.Labels.transformations;

import java.util.regex.Pattern;

public class CensorTransformation implements TextTransformation{
    private String target; public CensorTransformation(String target){
        if(target == null || target.isEmpty()){
            throw new IllegalArgumentException("Invalid target! Target can't be null");
        }
        this.target = target;
    }

    @Override
    public String transform(String text) {
        validateInput(text);
        //This regex works like this:
        //(?i) makes the regex case-insensitive.
        //Pattern.quote(target) escapes special characters in the target
        return text.replaceAll("(?i)\\b" + Pattern.quote(target), "*".repeat(target.length()));
    }

}
