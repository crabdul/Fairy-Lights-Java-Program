package com.fairylights;

import java.util.ArrayList;
import java.util.List;

/**
 * CliArgsParser parses command line arguments
 */
public class CliArgs{
    private ArrayList<Option> options;  
    /**
     * @param options    List of command line options
     */
    public CliArgs(String[] args){
        // Find options
        this.options = parseArgs(args);
    }
    // Parse command line arguments
    private ArrayList<Option> parseArgs(String[] args) {
        ArrayList<Option> options = new ArrayList<Option>();
        // Loop over arguments
        for (int i = 0; i < args.length; i++) {
            // Check if sequence specified
            if(args[i].equals("-sequence")){
                options.add(new Option("sequence",args[i+1]));
            }
            // Check if number specified
            if(args[i].equals("-number")){
                options.add(new Option("number",args[i+1]));
            }
            // Check if colours specified
            if(args[i].equals("-colours")){
                List<String> colours = new ArrayList<String>();
                int j = i+1;
                // Find all specified colours
                while(args[j].charAt(0) != '-'){
                    colours.add(args[j]);
                    j++;
                }
                options.add(new Option("colours",colours.toArray(new String[0])));
            }
        }
        return options;
    }
    // Returns whether option specified in command line
    public Boolean optionPresent(String optionName){
        for(Option option : options){
            if(optionName.equals(option.name())){
                return true;
            }
        }
        return false; 
    }
    // Returns option value
    public String optionValue(String optionName){
        String value = "";
        for(Option option : options){
            if(optionName.equals(option.name())){
                value = option.value();
            }
        }
        return value;
    }
    // Returns option values
    public String[] optionValues(String optionName){
        String[] values = new String[0];
        for(Option option : options){
            if(optionName.equals(option.name())){
                values = option.values();
            }
        }
        return values;
    }
}