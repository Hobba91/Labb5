package Labb5.events;

import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.simulator.SimState;
import Labb5.state.Customer;
import Labb5.state.StoreState;

/**
Class that will create a new Pay event if queue is empty, or add customer to queue.
* @author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/

public class PickUp extends Event{
    private StoreState store;
    private Customer customer;
    /**
    a constructor that sets the time it takes to pick up something, also which customer and store is being "handled".
    @param time, the pickup time.
    @param store, the store being used.
    */
    public PickUp(double time, Customer customer,StoreState store){
        this.time = time;
        this.customer = customer;
        this.store = store;
    }
    /**
    creates a new pickup event, which in turn creates a new pay event if a register is available.
    @param queue, the current eventqueue.
    @param state, the current state that is being "used".
    */
    @Override
    public void doMe(EventQueue queue, SimState state) {
        store.setCurrentCustomer(customer);
        store.update(this);
        if(store.getVacantRegi()>0){
            Event pay = new Pay(store.getPayTime().next()+this.time, customer, this.store);
            queue.add(pay);
            store.decVacantRegi();
        }else{
            store.incAmountOfCustQueue();
            store.addinLine(customer);
        }
        
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
        return "Plock";
    }
	/**
    @return the current customer that is being handled.
    */
    public Customer getCustomer() {
        return this.customer;
    }
    
}