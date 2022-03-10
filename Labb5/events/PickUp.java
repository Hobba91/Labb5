package Labb5.events;

import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.simulator.SimState;
import Labb5.state.StoreState;

public class PickUp extends Event{
    private StoreState store;

    public PickUp(double time){
        this.time = time;
    }

    @Override
    public void doMe(EventQueue queue, SimState state) {
        this.store = (StoreState)state;
        
        
    }

    @Override
    public double getTime() {
        return time;
    }
    
}