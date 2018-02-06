package com.fairylights;

/**
 * Represents one fairy light
 * 
 */ 
public class Light {
    private String colour;
    private Boolean state;
    /**
    * @param colour        colour of light
    * @param state         on/off state of light
    */
    public Light(String colour) {
        setColour(colour);
        setState(false);
    }
    // Getter methods
    public String getColour(){return this.colour;};
    // Returns state of light
    public Boolean getState(){return this.state;};
    // Set Colour
    private void setColour(String colour){this.colour = colour;}
    // Set On/off state
    private void setState(Boolean state){this.state = state;}
    // Flip light state
    public void switchState(){
        setState(!getState());
    }
}