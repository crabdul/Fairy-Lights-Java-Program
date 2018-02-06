package com.fairylights;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FairyLightsTest {
    @Test 
    public void testConstructor(){
        int n = 2;
        FairyLights fl1 = new FairyLights();
        FairyLights fl2 = new FairyLights(n);
    }
    @Test 
    public void testGetNumLights(){
        int n = 5;
        FairyLights fl = new FairyLights(n);
        assertEquals(fl.getNumLights(), n);
    } 
}

