package Labb5.events;

import Labb5.main.RunSim;
import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.simulator.Simulator;

public class Start extends Event{
    
    //Gör så att start utförs vid tiden starten av programmet
    //public double time = 0.0;

    public Start() {
        this.time = 0.0;
    }

    @Override
    public void doMe(EventQueue queue, double random) {
        Event arrival = new Arrival(random);
        queue.add(arrival);
        
    }

    @Override
    public double getTime() {
        return time;
    }
    
}