package com.example.Labels.decorators;

import com.example.Labels.labels.Label;

public abstract class LabelDecoratorBase implements Label {
    protected Label label;

    public LabelDecoratorBase(Label label){
        this.label = label;
    }

    @Override
    public String getText() {
        return label.getText();
    }

    //here i tried a little diff implementation then the example?
    public static Label removeDecorator(Label label, Class<? extends LabelDecoratorBase> decoratorType) {

        //base case
        if(decoratorType.isInstance(label)){
            //by pass the decorator -> return the underlying label
            return ((LabelDecoratorBase) label).label;
        }

        //bypassing decorators with recursion
        if(LabelDecoratorBase.class.isInstance(label)){
            LabelDecoratorBase decorator = ((LabelDecoratorBase) label);
            decorator.label = LabelDecoratorBase.removeDecorator(decorator.label, decoratorType);

            //rebuild the decorator chain
            return decorator;
        }

        //terminal case
        //Bottom  reached -> label has no more decorators -> rebuild starts
        return label;
    }

    //TODO: define equals for each decorator
    public static Label removeDecoratorInstance(Label label, LabelDecoratorBase targetDecorator) {

        //base case
        if(targetDecorator.equals(label)){
            //by pass the decorator -> return the underlying label
            return ((LabelDecoratorBase) label).label;
        }

        //bypassing decorators with recursion
        if(LabelDecoratorBase.class.isInstance(label)){
            LabelDecoratorBase decorator = ((LabelDecoratorBase) label);
            decorator.label = LabelDecoratorBase.removeDecoratorInstance(decorator.label, targetDecorator);

            //rebuild the decorator chain
            return decorator;
        }

        //terminal case
        //Bottom  reached -> label has no more decorators -> rebuild starts
        return label;
    }



}
