package Labb5.simulator;

import java.util.Observable;
import java.util.Observer;
import Labb5.simulator.SimState;

/** 
class that helps keep track of the state
*@author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/


public class SimView  implements Observer{
    private SimState state;
    /** 
    adds a observer to a state.
    @param state, the current state that is to be observed.
    */
    public SimView(SimState state) {
        this.state = state;
        state.addObserver(this);

    }
    @Override
    public void update(Observable arg0, Object f){
        
    }
}

  
