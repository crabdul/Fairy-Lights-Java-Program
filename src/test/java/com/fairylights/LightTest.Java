package com.fairylights;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LightTest {
    @Test 
    public void testConstructor(){
        Light light = new Light("red");
    }
    @Test 
    public void testGetColour(){
        String colour = "red";
        Light light = new Light(colour);
        assertEquals(light.getColour(), colour);
    } 
    @Test 
    public void testSwitchState(){
        String colour = "red";
        Light light = new Light(colour);
        light.switchState();
        assertEquals(light.getState(), true);
    } 
}