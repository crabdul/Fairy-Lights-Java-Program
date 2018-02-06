package com.fairylights;

import java.util.HashMap;

/**
 * CliArgsParser parses command line arguments
 */
public class CommandLineParser{
    private HashMap<String,String> options;  
    /**
     * @param options    List of command line options
     */
    public CommandLineParser(String[] args){
        // Find options
        this.options = parseArgs(args);
    }
    // Parse command line arguments
    private HashMap<String,String> parseArgs(String[] args) {
        HashMap<String,String> options = new HashMap<String,String>();
        // Loop over arguments
        for (int i = 0; i < args.length; i++) {
            // Check if sequence specified
            if(args[i].equals("-sequence")){
                options.put("sequence", args[i+1]);
            }
            // Check if number specified
            if(args[i].equals("-n")){
                options.put("n", args[i+1]);
            }
        }
        return options;
    }
    // Returns whether option specified in command line
    public Boolean optionPresent(String option){
        return options.containsKey(option);
    }
    // Returns option value
    public String optionValue(String option){
        return options.get(option);
    }
}