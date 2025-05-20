package com.example.Labels.labels;

public class SimpleLabel implements Label {
    public String value;
    public SimpleLabel(String value){
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        this.value=value;
    }

    public String getText(){
        return value;
    }
}
