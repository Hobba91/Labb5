package Labb5.events;

import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.simulator.SimState;

public class Stop extends Event{
    SimState store;

    public Stop(double time){
        this.time = time;
    }

    @Override
    public void doMe(EventQueue queue, SimState state) {
        this.store = state;
        store.SetSim();
        
        
    }

    @Override
    public double getTime() {
        return time;
    }

    @Override
    public String getName() {
        return "Stop";
    }
    
}