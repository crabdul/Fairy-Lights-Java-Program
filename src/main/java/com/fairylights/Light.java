package com.fairylights;

/**
 * Represents one fairy light
 * 
 */ 
public class Light {
    private static int count = 0;
    private int index;
    private String colour;
    private int colourIndex;
    /**
    * @param index         nth light
    * @param colour        colour of light
    * @param colourIndex   nth colour
    */
    public Light(String colour, int indexColour) {
        this.colour = colour;
        this.index = count;
        this.colourIndex = indexColour;
        count++;
    }

    // Getter methods
    public String colour(){return this.colour;};
    public int index(){return this.index;};
    public int colourIndex(){return this.colourIndex;};
    
}