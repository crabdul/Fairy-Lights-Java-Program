package com.fairylights;

import java.util.ArrayList;

/**
 * Represents a collection of lights
 */
public class FairyLights {
    private ArrayList<Light> lightsArr; // List of Light Objects
    String[] lightColours; // Colour of lights DEFAULT: red, white, blue
    private int n; // Number of lights DEFAULT: n
    /**
     * @param n         number of lights
     */
    public FairyLights(int n) {
        lightsArr = new ArrayList<Light>();
        setLightColours(new String[]{"Red","White","Blue"});
        setNumLights(n);
        createLightsArr("linear");
    }
    public FairyLights() {
        lightsArr = new ArrayList<Light>();
        setLightColours(new String[]{"Red","White","Blue"});
        setNumLights(15);
        createLightsArr("linear");
    }
    // Switch Light state in light array
    public void switchLightState(int i){
        this.lightsArr.get(i).switchState();
        getLightStatus(i);
    }

    private void createLightsArr(String sequence) {
        for(int i = 0; i < n; i++){
            this.lightsArr.add(new Light(calculateColour(i)));
        }
    }
    // Returns colour of the Light Object
    private String calculateColour(int i) {
        return this.lightColours[i % this.lightColours.length];
    }
    // Setter methods 
    private void setNumLights(int n){
        this.n = n;
    }
    // Setter methods 
    private void setLightColours(String[] lightColours){
        this.lightColours = lightColours;
    }
    // Get number of lights
    public int getNumLights(){
        return this.lightsArr.size();
    }
    // Get light state 
    private String getLightState(int i){
        return this.lightsArr.get(i).getState() ? "On" : "Off";
    }
    private String getLightColour(int i){
        return this.lightsArr.get(i).getColour();
    }
    // Print Current Light State
    private void getLightStatus(int i){
        System.out.println(String.format("%s Light %s", getLightColour(i), getLightState(i)));
    }
    
}