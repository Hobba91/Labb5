package Labb5.events;

import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.state.StoreState;
import Labb5.simulator.SimState;
import Labb5.state.Customer;

/***
Class that creates a customer and adds it the store.
Also creates a new pickup event and adds it to the eventqueue.
@author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/
public class Arrival extends Event{
    private StoreState store;
    Customer customer;

    /***
    a constructor that sets the arrival time also determines "which" store to be bounded to.
    @param time, the arrivaltime
    @param store, the store being used.
    */
    public Arrival(double time, StoreState store) {
        this.time = time;
        this.store = store;
        
    }

    /**
    creates a new arrival event. Which in turns checks things like if the store is open, full. 
    and depending on the results might create a new event. 
    @param queue, the current eventqueue.
    @param state, the current state that is being "used".
    */
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
    /***
    gives the time of the action
    @return returns the currnt time
    */
    @Override
    public double getTime() {
        return time;
    }
    /***
    gives the name of the class
    @return returns the name of the class.
    */
    @Override
    public String getName() {
        return "Ankomst";
    }

    /**
    gives the customer thats being handled
    @return returns the current customer that is being handled.
    */
    public Customer getCustomer() {
        return this.customer;
    }

    



}