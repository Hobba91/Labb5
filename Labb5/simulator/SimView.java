package Labb5.simulator;

import java.util.Observable;
import java.util.Observer;
import Labb5.state.CashState; //kan behöva vara simstate

public class SimView  implements Observer{
    private State state;
    public SimView() {
        state.addObserver(this);

    }
    @Override
    public void update(Observable arg0, Object f)
}

  
