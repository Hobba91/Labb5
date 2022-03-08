package Labb5.events;

import Labb5.simulator.Event;
import Labb5.state.CashState;

public class Arrival extends Event{

    public Arrival(double time) {
        this.time = time;
    }

    @Override
    public void doMe() {
       
    }

    @Override
    public double getTime() {
        return 0;
    }

    



}