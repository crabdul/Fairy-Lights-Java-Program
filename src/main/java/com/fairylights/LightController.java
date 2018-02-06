package com.fairylights;

import java.util.TimerTask;

class LightController extends TimerTask {
    private FairyLights fl;
    private String sequence;
    /**
     * @param fairylights   filtered fairylights
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
                case "even":
                    start = 1;
                    increment = 2;
                    break;
                case "odd":
                    increment = 2;
                    break;
            }
            for(int i = start; i < fl.getNumLights(); i = i + increment){
                fl.switchLightState(i);
                Thread.sleep(1000);
                fl.switchLightState(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.print(e);
        }
    }
}