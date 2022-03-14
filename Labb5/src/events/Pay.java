package Labb5.events;

import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.simulator.SimState;
import Labb5.state.StoreState;
import Labb5.state.Customer;

/** 
A class where customers will pay and marked as done after.
Will also remove customer and reduce the queue by one after a customer is done.
* @author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/
public class Pay extends Event{
	StoreState store;
	Customer customer;
    /** 
    a constructor that sets the time it takes to pay for something, also which customer and store is being "handled".
    @param time, the paytime.
    @param store, the store being used.
    */
	public Pay(double time, Customer customer, StoreState store){
		this.time = time;
		this.customer = customer;
		this.store = store;
	}
    /** 
    creates a new pay event. Which in turns checks things like if the queue is empty or not,
	otherwise it will go through the queue by creating more pay events.
    @param queue, the current eventqueue.
    @param state, the current state that is being "used".
    */
	@Override
	public void doMe(EventQueue queue, SimState state) {
		store.setCurrentCustomer(customer);
		store.update(this);
		store.decpeopleInStore();
		store.incVacantRegi();
		if(!store.Lineisempty()){
			Event pay = new Pay(store.getPayTime().next()+this.time, store.getNextInLine(), store);
            queue.add(pay);
			store.decVacantRegi();
			store.removefirstinLine();
		}

		



	}
    /** 
    @return  returns the currnt time
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
        return "Betalning";
    }
	/** 
    @return  returns the current customer that is being handled.
    */
	public Customer getCustomer() {
        return this.customer;
    }
    
}