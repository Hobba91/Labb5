package Labb5.main;

import org.w3c.dom.events.EventException;

import Labb5.events.Start;
//import Labb5.events.Stop;
//import Labb5.events.Start;
//import Labb5.events.Close;
import Labb5.simulator.*;
import Labb5.state.CashState;

public class RunSim {
    public static final int M = 5;
    public static final double L = 1;
    public static final double LOW_COLLECTION_TIME = 0.5d;
    public static final double HIGH_COLLECTION_TIME = 1d;
    public static final double LOW_PAYMENT_TIME = 2d;
    public static final double HIGH_PAYMENT_TIME = 3d;
    public static final int SEED = 1234;
    public static final double END_TIME = 10.0d;
    public static final double STOP_TIME = 999.0d;


    public static void main(String[] args){
        //
        

        //Skapar en kö där vio sparar event och en state.
        EventQueue queue = new EventQueue();
        Event start = new Start(0);
        queue.add(start);


        //Skapar en state
        SimState state = new SimState(LOW_COLLECTION_TIME,HIGH_COLLECTION_TIME,LOW_PAYMENT_TIME,
                                      HIGH_PAYMENT_TIME,SEED,END_TIME,STOP_TIME);
        
        //Skapar en simulator med state och queue
        Simulator simulator = new Simulator(queue, state);

        //skapar en view
        SimView view = new SimView();

        queue.addEvent(Start(queue))
        queue.addEvent(Close)
        queue.addEvent(Stop)

        Simulator.run()

        




        
    }
    
}
