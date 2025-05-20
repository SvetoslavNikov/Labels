package com.example.Labels.dependencyInjection;

import com.example.Labels.decorators.TextTransformationDecorator;
import com.example.Labels.labels.HelpLabel;
import com.example.Labels.labels.Label;
import com.example.Labels.labels.RichLabel;
import com.example.Labels.labels.SimpleLabel;
import com.example.Labels.proxy.ProxyLabel;
import com.example.Labels.transformations.TextTransformation;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Violates Single Responsibility and Open Closed...
public class LabelConfiguration {
    private Map<String, Label> labels;
    private Map<String, TextTransformation> transformations;

    public LabelConfiguration() {
        this.labels = new HashMap<>();
        this.transformations = new HashMap<>();
    }

    public void registerLabel(String name, Label label) {
        labels.put(name, label);
    }

    public void registerTransformation(String name, TextTransformation transformation) {
        transformations.put(name, transformation);
    }

    public Label getLabel(String name) {
        return labels.get(name);
    }

    public TextTransformation getTransformation(String name) {
        return transformations.get(name);
    }


    public Label createLabelInteractively() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select label type by typing the number 1-3:");
        System.out.println("1. Simple Label");
        System.out.println("2. Rich Label");
        System.out.println("3. Proxy Label");

        int labelType = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        Label baseLabel = null;

        switch (labelType) {
            case 1:
                System.out.println("Enter label text:");
                String text = scanner.nextLine();
                baseLabel = new SimpleLabel(text);
                break;

            case 2:
                System.out.println("Enter label text:");
                String richText = scanner.nextLine();

                System.out.println("Enter font name:");
                String font = scanner.nextLine();

                System.out.println("Enter font size:");
                int size = scanner.nextInt();
                scanner.nextLine(); // consume the newline

                System.out.println("Enter color (r,g,b):");
                String[] rgb = scanner.nextLine().split(",");
                Color color = new Color(
                        Integer.parseInt(rgb[0].trim()),
                        Integer.parseInt(rgb[1].trim()),
                        Integer.parseInt(rgb[2].trim())
                );

                baseLabel = new RichLabel(richText, font, size, color);
                break;

            case 3:
                System.out.println("Enter timeout requests:");
                int timeout = scanner.nextInt();
                scanner.nextLine(); // consume the newline

                baseLabel = new ProxyLabel(timeout);
                break;

            default:
                System.out.println("Invalid choice, creating a Simple Label");

                System.out.println("Enter label text:");
                String defaultText = scanner.nextLine();
                baseLabel = new SimpleLabel(defaultText);
        }

        System.out.println("Add help text? (y/n)");
        String addHelp = scanner.nextLine().toLowerCase();

        if (addHelp.equals("y") || addHelp.equals("yes")) {
            System.out.println("Enter help text:");
            String helpText = scanner.nextLine();
            baseLabel = new HelpLabel(baseLabel, helpText);
        }

        System.out.println("Add transformations? (y/n)");
        String addTransform = scanner.nextLine().toLowerCase();

        while (addTransform.equals("y") || addTransform.equals("yes")) {
            System.out.println("Available transformations:");
            for (String name : transformations.keySet()) {
                System.out.println(name);
            }

            System.out.println("Enter transformation name:");
            String transformationName = scanner.nextLine();

            TextTransformation transformation = transformations.get(transformationName);
            if (transformation != null) {
                baseLabel = new TextTransformationDecorator(baseLabel, transformation);
                System.out.println("Transformation added.");
            } else {
                System.out.println("Transformation not found.");
            }

            System.out.println("Add another transformation? (y/n)");
            addTransform = scanner.nextLine().toLowerCase();
        }

        return baseLabel;
    }
}