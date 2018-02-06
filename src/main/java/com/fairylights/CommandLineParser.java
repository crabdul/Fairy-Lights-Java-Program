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
            try {
                // Check if sequence specified
                if(args[i].equals("-sequence") ){
                    options.put("sequence", args[i+1]);
                }
            } catch (Exception e) {
                System.out.println("Invalid sequence");
            }
                // Check if number specified
                if(args[i].equals("-n")){
                    try {
                        // Check if argument can be parsed into an integer
                        int temp = Integer.parseInt(args[i+1]);
                        options.put("n", args[i+1]);
                    } catch (Exception e) {
                        System.out.println("Invalid n");
                    }
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