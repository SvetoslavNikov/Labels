package com.example.Labels;


import com.example.Labels.decorators.TextTransformationDecorator;
import com.example.Labels.labels.Label;
import com.example.Labels.labels.SimpleLabel;
import com.example.Labels.transformations.Capitalize;
import com.example.Labels.transformations.CompositeTransformation;
import com.example.Labels.transformations.DecorateTransformation;
import com.example.Labels.transformations.TextTransformation;

import java.util.List;

public class Test {
    public static void main(String[] args){


        Label baselabel = new SimpleLabel("label");
        System.out.println("NO decorators: " + baselabel.getText());

        Label decorated = new TextTransformationDecorator(baselabel, new Capitalize());
        System.out.println("With decorators: " + decorated.getText());
        decorated = TextTransformationDecorator.removeDecorator(decorated, TextTransformationDecorator.class);

        decorated = new TextTransformationDecorator(decorated, new DecorateTransformation());
        System.out.println("With decorators: " + decorated.getText());


        List<TextTransformation> ls = List.of(new Capitalize()
                , new DecorateTransformation());
        CompositeTransformation ct = new CompositeTransformation();
        ct.addTransformation(ls.get(0));
        ct.addTransformation(ls.get(1));

        String result = ct.transform(baselabel.getText());
        System.out.println(result);


    }
}
