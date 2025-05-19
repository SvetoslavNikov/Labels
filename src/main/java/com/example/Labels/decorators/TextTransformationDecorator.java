package com.example.Labels.decorators;


import com.example.Labels.labels.Label;
import com.example.Labels.transformations.TextTransformation;

public class TextTransformationDecorator extends LabelDecoratorBase{

    private TextTransformation textTransformation;

    public TextTransformationDecorator(Label label, TextTransformation textTransformation){
        super(label);
        this.textTransformation = textTransformation;
    }

    @Override
    public String getText() {
        return textTransformation.transform(label.getText());
    }
}


