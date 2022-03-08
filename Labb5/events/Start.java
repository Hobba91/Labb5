package Labb5.events;

import Labb5.main.RunSim;
import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.simulator.Simulator;

public class Start extends Event{
    
    //Gör så att start utförs vid tiden starten av programmet
    //public double time = 0.0;

    public Start(double time) {
        this.time = 0.0;
    }

    @Override
    public EventQueue doMe() {
        Event arrival = new Arrival(8);
        
    }

    @Override
    public double getTime() {
        return time;
    }
    
}