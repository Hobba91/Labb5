package Labb5.events;

import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.simulator.SimState;
import Labb5.state.StoreState;

/**
* @author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/

/**
Class that sets when the store should close.
*/
public class Close extends Event{
    StoreState store;
    /**
    a constructor that sets the close time also determines "which" store to bounded to.
    @param time, the close
    @param store, the store being used.
    */
    public Close(double time, StoreState store) {
        this.time = time; 
        this.store = store;
    }
    /**
    creates a new close event, which closes the store.
    @param queue, the current eventqueue.
    @param state, the current state that is being "used".
    */
    @Override
    public void doMe(EventQueue queue, SimState state) {
        store.setCurrentCustomer(null);
        store.update(this);
        store.SetOpen(false); 
    }
    /**
    @return returns the currnt time
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
        return "Stänger";
    }
    
}