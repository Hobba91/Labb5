package Labb5.events;

import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.state.StoreState;
import Labb5.simulator.SimState;

public class Start extends Event{
   private StoreState store;

   public Start(){
           this.time = 0.0;
   }     

   public void doMe(EventQueue queue, SimState state) {
        this.store = (StoreState)state;
        store.update(this);
        store.SetOpen(true);
        Event arrival = new Arrival(store.getArrivalTime().next()+this.time);
        queue.add(arrival);
        
    }

    @Override
    public double getTime() {
        return time;
    }

    @Override
    public String getName() {
        return "Start";
    }
    
}