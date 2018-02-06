package com.fairylights;

import java.util.Timer;

/**
 * Fairy Lights App
 * 
 * Java program to turn on/off a set of coloured lights in sequence. 
 * The number of lights are configurable on the command line. 
 * The default colour sequence is "red, green, white".
 * Each light should remain on for 1 second and then turn off.
 * sequence can be specified in the command line:
 * 
 * Sequence options specified after "-sequence":
 * - "even" - only even indexed lights turned on/off
 * - "odd" - only odd indexed lights turned on/off
 * - "same" - same coloured lights turned on/off consecutively
 * 
 *
 */
public class App {
    // private FairyLights fairyLights;
    public static void main( String[] args ) {
        try {    
            final FairyLights fairyLights;
            final Timer timer;
            String sequence = "linear"; // Default sequence

            // Parse Arguments
            CommandLineParser parser = new CommandLineParser(args);
            // Create fairy lights dependent on command line arguments
            if(parser.optionPresent("n") && parser.optionPresent("sequence")){
                fairyLights = new FairyLights(Integer.parseInt(parser.optionValue("n")));
                sequence = parser.optionValue("sequence");
            } else if(parser.optionPresent("n")) {
                fairyLights = new FairyLights(Integer.parseInt(parser.optionValue("n")));
                System.out.println(String.format("Default value for sequence (linear) used "));
            } else if(parser.optionPresent("sequence")) {
                fairyLights = new FairyLights();
                sequence = parser.optionValue("sequence");
                System.out.println(String.format("Default value for number of lights (%s) used ",fairyLights.getNumLights()));
            } else {
                fairyLights = new FairyLights();
                System.out.println(String.format("Default value for number of lights (%s) and sequence (linear) used ",fairyLights.getNumLights()));
            }
            // Start fairy lights
            timer = new Timer();
            timer.scheduleAtFixedRate(new LightController(fairyLights, sequence), 0, 1000);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
