package Labb5.events;

import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.simulator.SimState;
import Labb5.state.StoreState;
import Labb5.state.Customer;

public class Pay extends Event{
	StoreState store;
	Customer customer;

	public Pay(double time, Customer customer, StoreState store){
		this.time = time;
		this.customer = customer;
		this.store = store;
	}

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

	@Override
	public double getTime() {
		return time;
	}

	@Override
    public String getName() {
        return "Betalning";
    }

	public Customer getCustomer() {
        return this.customer;
    }
    
}