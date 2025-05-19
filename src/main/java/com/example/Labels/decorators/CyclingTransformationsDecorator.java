package com.example.Labels.decorators;


import com.example.Labels.labels.Label;
import com.example.Labels.transformations.TextTransformation;

import java.util.List;

//TODO: Should decorators stack or just cycle?
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
}
