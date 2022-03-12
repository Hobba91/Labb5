package Labb5.simulator;

import java.util.Observable;
import java.util.Observer;
import Labb5.simulator.SimState;
public class SimView  implements Observer{
    private SimState state;
    public SimView(SimState state) {
        this.state = state;
        state.addObserver(this);

    }
    @Override
    public void update(Observable arg0, Object f){
        
    }
}

  
