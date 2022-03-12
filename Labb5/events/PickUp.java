package Labb5.events;

import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;
import Labb5.simulator.SimState;
import Labb5.state.Customer;
import Labb5.state.StoreState;

public class PickUp extends Event{
    private StoreState store;
    private Customer customer;

    public PickUp(double time, Customer customer,StoreState store){
        this.time = time;
        this.customer = customer;
        this.store = store;
    }

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

    @Override
    public double getTime() {
        return time;
    }

    @Override
    public String getName() {
        return "Plock";
    }

    public Customer getCustomer() {
        return this.customer;
    }
    
}