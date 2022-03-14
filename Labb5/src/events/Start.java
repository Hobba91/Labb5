package Labb5.events;

import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.state.StoreState;
import Labb5.simulator.SimState;

/**
Class that starts everything. Will open the store and create new arrival event.
* @author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/
public class Start extends Event{
   private StoreState store;

    /**
    a constructor that sets the start time also adds a store.
    @param store, the store being used.
    */
   public Start(StoreState store){
           this.time = 0.0;
           this.store = store;

   }     

    /**
    starts the simulation
    @param queue, the eventqueue.
    @param state, the state being used.
    */
   public void doMe( EventQueue queue, SimState state) {
       store.setCurrentCustomer(null);
        store.update(this);
        store.SetOpen(true);
        Event arrival = new Arrival(store.getArrivalTime().next()+this.time,this.store);
        queue.add(arrival);
        
    }

    /**
    gives the time of the action
    @return returns the currnt time
    */
    @Override
    public double getTime() {
        return time;
    }
    /**
    gives the name of the class
    @return returns the name of the class
    */
    @Override
    public String getName() {
        return "Start";
    }

    
}