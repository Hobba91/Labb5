package Labb5.events;

import Labb5.simulator.Event;
import Labb5.simulator.EventQueue;

public class Pay extends Event{
	StoreState store;

	@Override
	public void doMe(EventQueue queue, SimState state) {

		store = (StoreState) state; 
		store.getCashiers();

		



	}

	@Override
	public double getTime() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}