package com.fairylights;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for App.
 */
public class FairyLightsTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FairyLightsTest( String testName ){
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( FairyLightsTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testConstructor() {
        int n = 12;
        String[] colours = new String[]{"red","blue","green"};
        String sequence = "even";
        FairyLights fairyLights = new FairyLights(n,colours,sequence);
    }
}
