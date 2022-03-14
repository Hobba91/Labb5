package Labb5.events;

import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.simulator.SimState;
import Labb5.state.StoreState;

/**
Class that will stop the simulation after a set amount of time.
* @author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/
public class Stop extends Event{
    StoreState store;
    /**
    a constructor that sets the stop time and which store its "bound" to.
    @param time, the time the simulation ends.
    @param store, the store being used.
    */
    public Stop(double time, StoreState store){
        this.time = time;
        this.store = store;
    }

    /**
    creates a new Stop event, which stops the simulation.
    @param queue, the current eventqueue.
    @param state, the current state that is being "used".
    */
    @Override
    public void doMe(EventQueue queue, SimState state) {
        store.update(this);
        store.SetSim();
        
        
        
    }
    /**
    @return returns the current time
    */
    @Override
    public double getTime() {
        return time;
    }
    /**
    @return returns the name of the class.
    */
    @Override
    public String getName() {
        return "Stop";
    }
    
}