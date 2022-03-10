package Labb5.events;

import Labb5.main.RunSim;
import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.simulator.Simulator;
import Labb5.state.StoreState;
import Labb5.simulator.SimState;

public class Start extends Event{
   private StoreState store;

   public Start(){
           this.time = 0.0;
   }     

   public void doMe(EventQueue queue, SimState state) {
        this.store = (StoreState)state;
        Event arrival = new Arrival(store.getArrivalTime().next()+this.time);
        queue.add(arrival);
        
    }

    @Override
    public double getTime() {
        return time;
    }
    
}