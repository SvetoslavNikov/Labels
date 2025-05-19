package com.example.Labels.transformations;

import java.util.HashMap;
import java.util.Map;

public class CensorTransformationFactory {
    private static final Map<String, CensorTransformation> flyweights = new HashMap<>();

    public static TextTransformation createCensorTransformation(String wordToCensor) {
        if(wordToCensor == null || wordToCensor.isEmpty()){
            throw new IllegalArgumentException("Word to censor can't be NULL or EMPTY");
        }
        if (wordToCensor.length() <= 4) {
            return flyweights.computeIfAbsent(wordToCensor, word -> new CensorTransformation(word));
        }
        else {
            return new CensorTransformation(wordToCensor);
        }
    }

    public static void clearCache(){
        flyweights.clear();
    }
}
