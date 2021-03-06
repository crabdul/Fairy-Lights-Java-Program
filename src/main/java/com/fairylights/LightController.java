package com.fairylights;

import java.util.TimerTask;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * LightController turns the lights on and off sequentially depending on the sequence specified
 */
class LightController extends TimerTask {
    private FairyLights fl;
    private String sequence;

    /**
     * @param fairylights   FairyLights Object 
     * @param sequence      light sequence order
     */
    LightController(FairyLights fairyLights, String sequence){
        this.fl = fairyLights;
        this.sequence = sequence;
    }
    public void run ()  {
        try {
            int start = 0;
            int increment = 1;
            switch(this.sequence){
                // Only turn on and off even indexed lights
                case "even":
                    if(this.fl.getNumLights() != 1){
                        start = 1;
                        increment = 2;
                    }
                    break;
                // Only turn on and off even indexed lights
                case "odd":
                    if(this.fl.getNumLights() != 1){
                        increment = 2;
                    }
                    break;
            }
            // Loop over lights switching their states
            for(int i = start; i < this.fl.getNumLights(); i = i + increment){
                getTime();
                fl.switchLightState(i);
                Thread.sleep(1000);
                getTime();
                fl.switchLightState(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.print(e);
        }
    }
    // Return TimeStamp
    private void getTime() {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ss");
        System.out.print(ft.format(date)+ ": ");
    }
}