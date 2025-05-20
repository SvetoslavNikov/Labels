package com.example.Labels.decorators;


import com.example.Labels.labels.Label;
import com.example.Labels.transformations.TextTransformation;

import java.util.List;
import java.util.Random;

//TODO: Ask if "different each time when invoked" means not repeating?
//      v1 - repeating
//      v2 - non repeating
//      should they stack?
public class RandomTransformationDecorator extends LabelDecoratorBase{
    private Label label;
    private List<TextTransformation> textTransformations;

    public RandomTransformationDecorator(Label label, List<TextTransformation> textTransformations){
        super(label);
        this.textTransformations = textTransformations;
    }

    //v1
    @Override
    public String getText() {
        int idx = new Random().nextInt(textTransformations.size());
        return textTransformations.get(idx).transform(label.getText());
    }

    //v2
//    @Override
//    public String getText() {
//        int idx = new Random().nextInt(textTransformations.size());
//        String result = textTransformations.get(idx).transform(label.getText());
//        textTransformations.remove(idx);
//        return result;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RandomTransformationDecorator)) return false;
        if (!super.equals(o)) return false;

        RandomTransformationDecorator that = (RandomTransformationDecorator) o;
        return textTransformations.equals(that.textTransformations);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + textTransformations.hashCode();
        return result;
    }

}
