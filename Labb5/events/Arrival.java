package Labb5.events;

import Labb5.simulator.Event;
import Labb5.state.StoreState;
import Labb5.simulator.EventQueue;
import Labb5.simulator.SimState;

public class Arrival extends Event{
    private StoreState store;

    public Arrival(double time) {
        this.time = time;
    }

    @Override
    public void doMe(EventQueue queue, SimState state) {
        this.store = (StoreState)state;
        if(store.getOpen()){
            if(!store.isFull()){
                Event PickUp = new PickUp(store.getPickTime().next()+this.time);
            }else{
                store.incmissedCust();
            }
            Event arrival = new Arrival(store.getArrivalTime().next()+this.time);
            queue.add(arrival);
        }
       
    }

    @Override
    public double getTime() {
        return time;
    }

    



}