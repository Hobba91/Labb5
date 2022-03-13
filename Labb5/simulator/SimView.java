package Labb5.simulator;

import java.util.Observable;
import java.util.Observer;
import Labb5.simulator.SimState;

/** 
*@author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/

/** 
class that helps keep track of the state
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

  
