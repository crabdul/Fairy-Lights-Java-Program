package com.fairylights;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class LightTest extends TestCase {
    /**
     * Test constructor for single option value
     */
    public void testConstructor() {
        String colour = "red";
        int colourIndex = 2;
        Light light = new Light(colour,colourIndex);
    }
    /**
     * Test Getter methods
     */
    public void testGetterMethods() {
        String colour = "red";
        int colourIndex = 0;
        Light light = new Light(colour,colourIndex);
        assertEquals(light.colour(), colour);
        assertEquals(light.colourIndex(), colourIndex);
    }
}

