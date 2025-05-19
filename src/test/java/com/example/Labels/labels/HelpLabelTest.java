package com.example.Labels.labels;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HelpLabelTest{
    private HelpLabel helpLabel;

    @Test
    public void nullHelpTextInputThrowsIAExc(){
        assertThrows(IllegalArgumentException.class, () -> {
            helpLabel = new HelpLabel(new SimpleLabel("text"), null);
        });
    }

    @Test
    public void nullLabelInputThrowsIAExc(){
        assertThrows(IllegalArgumentException.class, () -> {
            helpLabel = new HelpLabel(null, "helpText");
        });
    }

    @Test
    public void normalBehaaivior(){
        helpLabel = new HelpLabel(new SimpleLabel("text"), "helpText");
        assertEquals("helpText", helpLabel.getHelpText());
    }

    /*
    null label
    null helptext
    empty helptext

    test HelpTextMethod
    one way to test it is to test it for every implementation of the Label Interface but that is kinda stupid
    cus every implementation has diff methods and constructors. Maybe i just test the extensiveness of HelLabel
    with the Bridge  pattern cus that is the main purpose of it
     */
}
