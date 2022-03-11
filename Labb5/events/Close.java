package Labb5.events;

import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.simulator.SimState;
import Labb5.state.StoreState;

public class Close extends Event{
    StoreState store;

    public Close(double time) {
        this.time = time; 
    }

    @Override
    public void doMe(EventQueue queue, SimState state) {
        store = (StoreState) state;
        store.update(this);
        store.SetOpen(false); 
    }

    @Override
    public double getTime() {
        return time;
    }

    @Override
    public String getName() {
        return "Stänger";
    }
    
}