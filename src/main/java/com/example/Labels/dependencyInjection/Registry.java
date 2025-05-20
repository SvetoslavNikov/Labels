package com.example.Labels.dependencyInjection;

import com.example.Labels.transformations.TextTransformation;
import java.util.HashMap;

/**
    Add every transformation in the Registry with static block in each one?

    static {
        Registry.registerTransformation("capitalize", new Capitalize());
    }

    Create Factories for every label?

    public interface LabelFactory {
        Label create(Scanner console);
    }

    And we add them in the Registry with static block in each one?

    public class SimpleLabelFactory implements LabelFactory {
     static {
        Registry.registerLabelFactory("simple", new SimpleLabelFactory());
    }

 **/

/*
public class Registry {
    private static final Map<String, LabelFactory>  labelFactories = new HashMap<>();
    private static final Map<String, TextTransformation> transformations = new HashMap<>();

    public static void registerLabelFactory(String key, LabelFactory factory) {
        labelFactories.put(key, factory);
    }

    public static LabelFactory getLabelFactory(String key) {
        return labelFactories.get(key);
    }

    public static void registerTransformation(String key, TextTransformation t) {
        transformations.put(key, t);
    }

    public static TextTransformation getTransformation(String key) {
        return transformations.get(key);
    }
}
 */

