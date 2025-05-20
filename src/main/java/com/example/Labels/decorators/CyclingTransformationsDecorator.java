package com.example.Labels.decorators;


import com.example.Labels.labels.Label;
import com.example.Labels.transformations.TextTransformation;

import java.util.List;

public class CyclingTransformationsDecorator extends LabelDecoratorBase{
    private Label label;
    private List<TextTransformation> textTransformations;
    private int nextTransformationID;

    public CyclingTransformationsDecorator(Label label, List<TextTransformation> textTransformations){
        super(label);
        this.textTransformations = textTransformations;
        this.nextTransformationID = textTransformations.size();
    }


    @Override
    public String getText() {
        if(nextTransformationID > textTransformations.size()){
            nextTransformationID = 0;
        }
        String result = textTransformations.get(nextTransformationID).transform(label.getText());
        nextTransformationID ++;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CyclingTransformationsDecorator)) return false;
        if (!super.equals(o)) return false;

        CyclingTransformationsDecorator that = (CyclingTransformationsDecorator) o;
        return textTransformations.equals(that.textTransformations);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + textTransformations.hashCode();
        return result;
    }

}
