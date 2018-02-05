package com.fairylights;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Represents a collection of lights
 */
public class FairyLights {
    private List<Light> fairyLights; // List of Light Objects
    private static List<String> colourKey = new ArrayList<String>(); // Key of light colours
    private int n;
    Timer timer;
    // Default values
    private String sequence = "linear";
    String[] colours = new String[]{"Red","Green","White"};
    /**
     * @param n         number of lights
     * @param colours   list of colour of lights
     * @param sequence  sequence fairylights turn on and off
     */
    public FairyLights(int n, String[] colours, String sequence) {
        this.n = n;
        this.colours = colours;
        this.sequence = sequence;
        this.fairyLights = createFairyLights();
    }
    /**
     * @param n         number of lights
     * @param sequence  sequence fairylights turn on and off
     */
    public FairyLights(int n, String sequence) {
        this.n = n;
        this.sequence = sequence;
        this.fairyLights = createFairyLights();
    }
    /**
     * @param n         number of lights
     * @param colours   list of colour of lights
     */
    public FairyLights(int n, String[] colours) {
        this.n = n;
        this.colours = colours;
        this.fairyLights = createFairyLights();
    }
    /**
     * @param n         number of lights
     */
    public FairyLights(int n) {
        this.n = n;
        this.fairyLights = createFairyLights();
    }
    // Returns index of light colour
    private int indexColour(String colour) {
        int colourIndex;
        // Check if colour already known
        if(colourKey.contains(colour)){
            colourIndex = colourKey.indexOf(colour);
        // If new colour
        } else {
            colourKey.add(colour);
            colourIndex = colourKey.indexOf(colour);
        }
        return colourIndex;
    }
    // Return list of fairy lights
    private List<Light> createFairyLights(){
        List<Light> fairyLights = new ArrayList<Light>();
        int m = colours.length;
        for(int i = 0; i < this.n; i++ ){
            fairyLights.add(new Light(colours[i%m], indexColour(colours[i%m])));
        }
        return fairyLights;
    }
    // Start light sequence
    public void startLights() {
        List<Light> sortedFairyLights = new ArrayList<Light>();
        // Filter lights according to lighting sequence
        if(this.sequence.equals("even")) sortedFairyLights = filterLight(byEven());
        if(this.sequence.equals("odd")) sortedFairyLights = filterLight(byOdd());
        if(this.sequence.equals("same")) sortedFairyLights = groupBySame();
        if(this.sequence.equals("linear")) sortedFairyLights = fairyLights;
        printOutput(sortedFairyLights);

    }
    // Filter fairy lights according to condition
    private List<Light> filterLight(Predicate<Light> predicate) {
        return this.fairyLights.stream().filter(predicate).collect(Collectors.<Light> toList());
    }
    // Include only even indexed fairylights (Offset by 1 as count starts at 1)
    private static Predicate<Light> byEven() {
        return light -> light.index() % 2 == 1;
    }
    // Include only odd indexed fairylights
    private static Predicate<Light> byOdd() {
        return light -> light.index() % 2 == 0;
    }
    // Group fairylights by colour
    private List<Light> groupBySame() {
        this.fairyLights.sort(Comparator.comparing(Light::colourIndex));
        return fairyLights;
    }
    // Print fairylights output using a timer of 1s
    private void printOutput(List<Light> fairyLights) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new lightsOutput(fairyLights), 0, 1000);
    }
    class lightsOutput extends TimerTask {
        private List<Light> fairyLights;
        /**
         * @param fairylights   filtered fairylights
         */
        lightsOutput(List<Light> fairyLights){
            this.fairyLights = fairyLights;
        }
        public void run ()  {
            for (Light light : this.fairyLights) {
                try {
                    System.out.println(String.format("%s Light %s", light.colour(), "On"));
                    Thread.sleep(1000);
                    System.out.println(String.format("%s Light %s", light.colour(), "Off"));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.print(e);
                }
            }
        }
    }
}