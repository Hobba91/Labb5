package Labb5.events;

import Labb5.simulator.Event;
import Labb5.state.CashState;
import Labb5.simulator.EventQueue;

public class Arrival extends Event{

    public Arrival(double time) {
        this.time = time;
    }

    @Override
    public void doMe(EventQueue queue, double random) {
       
    }

    @Override
    public double getTime() {
        return 0;
    }

    



}