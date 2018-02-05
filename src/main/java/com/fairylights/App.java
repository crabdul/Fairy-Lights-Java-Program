package com.fairylights;

/**
 * Fairy Lights App
 * 
 * Java program to turn on/off a set of coloured lights in sequence. 
 * The number of lights are configurable on the command line. 
 * The default colour sequence is "red, green, white".
 * Each light should remain on for 1 second and then turn off.
 * Colours and sequence can be specified in the command line:
 * 
 * Sequence options specified after "-sequence":
 * - "even" - only even indexed lights turned on/off
 * - "odd" - only odd indexed lights turned on/off
 * - "same" - same coloured lights turned on/off consecutively
 * 
 * Colour options specified after "-colours" with space between arguments
 * e.g. -colours red orange blue
 *
 */
public class App {
    public static void main( String[] args ) {
        try {    
            // Parse Command Line Arguments
            CliArgs cliArgs = new CliArgs(args);
            // Create fairy lights
            FairyLights fairylights = createLights(cliArgs);
            // Start fairy lights
            fairylights.startLights();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    // Returns FairyLights Object created with command line arguments
    private static FairyLights createLights(CliArgs cliArgs) {
        int n = Integer.parseInt(cliArgs.optionValue("number")); // number of fairy lights
        FairyLights fairyLights;
        // Optional arguments: Colours and Sequence specified
        if(cliArgs.optionPresent("colours") && cliArgs.optionPresent("sequence")){
            fairyLights = new FairyLights(n,cliArgs.optionValues("colours"),cliArgs.optionValue("sequence"));
        // Only colours specified
        } else if(cliArgs.optionPresent("colours")) {
            fairyLights = new FairyLights(n,cliArgs.optionValues("colours"));
        // Only sequence specified
        } else if(cliArgs.optionPresent("sequence")) {
            fairyLights = new FairyLights(n,cliArgs.optionValue("sequence"));
        // No optional arguments specified
        } else {
            fairyLights = new FairyLights(n);
        }
        return fairyLights;
    }
}
