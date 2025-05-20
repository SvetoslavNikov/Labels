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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextTransformationDecorator)) return false;
        if (!super.equals(o)) return false;

        TextTransformationDecorator that = (TextTransformationDecorator) o;
        return textTransformation.equals(that.textTransformation);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + textTransformation.hashCode();
        return result;
    }

}


