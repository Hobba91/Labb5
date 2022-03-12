package Labb5.events;

import Labb5.simulator.Event;
import Labb5.state.StoreState;
import Labb5.simulator.EventQueue;
import Labb5.simulator.SimState;
import Labb5.state.Customer;

public class Arrival extends Event{
    private StoreState store;
    Customer customer;

    public Arrival(double time, StoreState store) {
        this.time = time;
        this.store = store;
        
    }

    @Override
    public void doMe(EventQueue queue, SimState state) {
        customer = store.createCustomer();
        store.setCurrentCustomer(customer);
        store.update(this);
        if(store.getOpen()){
            if(!store.isFull()){
                Event pickUp = new PickUp(store.getPickTime().next()+this.time,customer,this.store);
                queue.add(pickUp);
                store.incpeopleInStore();
            }else{
                store.incmissedCust();
            }
            Event arrival = new Arrival(store.getArrivalTime().next()+this.time,this.store);
            queue.add(arrival);
        }

       
    }

    @Override
    public double getTime() {
        return time;
    }

    @Override
    public String getName() {
        return "Ankomst";
    }

    public Customer getCustomer() {
        return this.customer;
    }

    



}