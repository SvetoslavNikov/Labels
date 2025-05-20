package com.example.Labels.labels;

//TODO: So here idk if i should implement the Label interface.
// (canonical bridge pattern does not)
public class HelpLabel implements Label{
    private Label label;
    private String helpText;

    public HelpLabel(Label label, String helpText){
        if (label == null || helpText == null) {
            throw new IllegalArgumentException("Label and helpText cannot be null");
        }
        this.label = label;
        this.helpText = helpText;
    }

    public String getText(){
        return label.getText();
    }

    public String getHelpText(){
        return this.helpText;
    }

}
