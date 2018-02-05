package com.fairylights;

/**
 * Represents a command line argument
 */
public class Option {
    private String name;  
    private String value;
    private String[] values;
    /**
     * @param name      option name
     * @param value     option value
     */
    public Option(String name, String value){
        this.name = name;
        this.value = value;
    }
    /**
     * @param name      option name
     * @param values    option values
     */
    public Option(String name, String[] values){
        this.name = name;
        this.values = values;
    }
    // Getter methods
    public String name() {return this.name;};
    public String value() {return this.value;};
    public String[] values() {return this.values;};
}