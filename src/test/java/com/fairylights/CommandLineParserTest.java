package com.fairylights;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CommandLineParserTest {
    @Test 
    public void testConstructor(){
        CommandLineParser clp = new CommandLineParser(new String[]{"-n","12"});
    }
    @Test 
    public void testOptionPresent(){
        CommandLineParser clp = new CommandLineParser(new String[]{"-n","12"});
        assertEquals(clp.optionPresent("n"), true);
    } 
    @Test 
    public void testOptionValue(){
        CommandLineParser clp = new CommandLineParser(new String[]{"-n","12","-sequence","even"});
        assertEquals(clp.optionValue("n"), "12");
        assertEquals(clp.optionValue("sequence"), "even");
    } 
}