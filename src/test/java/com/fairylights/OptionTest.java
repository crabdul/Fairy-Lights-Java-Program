package com.fairylights;

import junit.framework.TestCase;

/**
 * Unit test for Option Class.
 */
public class OptionTest extends TestCase {
    /**
     * Test constructor for single option value
     */
    public void testConstructorSingleValue() {
        String name = "number";
        String value = "15";
        Option option = new Option(name,value);
    }
    /**
     * Test constructor for multiple option values
     */
    public void testConstructorMultipleValue() {
        String name = "colours";
        String[] value = new String[]{"red","blue","green"};
        Option option = new Option(name,value);
    }
    /**
     * Test Getter methods
     */
    public void testGetterMethods() {
        String name1 = "number";
        String value1 = "15";
        Option option1 = new Option(name1,value1);
        String name2 = "colours";
        String[] value2 = new String[]{"red","blue","green"};
        Option option2 = new Option(name2,value2);
        assertEquals(option1.name(), name1);
        assertEquals(option1.value(), value1);
        assertEquals(option2.name(), name2);
        assertEquals(option2.values(), value2);
    }
}
