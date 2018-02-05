package com.fairylights;

import junit.framework.TestCase;


/**
 * Unit test for CliArgsTest.
 */
public class CliArgsTest extends TestCase {

    public void testOptionParsed(){
        String[] args = new String[]{"-number","12","-sequence","even"};
        CliArgs cliArgs = new CliArgs(args);
        assertTrue(cliArgs.optionPresent("number"));
        assertTrue(cliArgs.optionPresent("sequence"));
        assertEquals(cliArgs.optionValue("number"), "12");
        assertEquals(cliArgs.optionValue("sequence"), "even");
    }
}
