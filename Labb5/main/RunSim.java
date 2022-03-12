package Labb5.main;

import org.w3c.dom.events.EventException;

import Labb5.events.Start;
import Labb5.events.Stop;
import Labb5.events.Start;
import Labb5.events.Close;
import Labb5.simulator.*;
import Labb5.state.StoreState;
import Labb5.simulator.Event;


public class RunSim {

    public static final int M = 5; //
    public static final double L = 1;       // kunder är kunder per tidsenhet (LAMBDA).
    public static final double LOW_COLLECTION_TIME = 0.5d; // min tiden det tar att plocka upp varor.
    public static final double HIGH_COLLECTION_TIME = 1d; // max tiden det tar att plocka upp varor.
    public static final double LOW_PAYMENT_TIME = 2d;   // min tiden det tar att betala i kassan.
    public static final double HIGH_PAYMENT_TIME = 3d; // max tiden det tar att betala i kassan.
    public static final int SEED = 1234;                // ett "frö" för att slumpa värden.
    public static final double END_TIME = 10.0d;   // 
    public static final double STOP_TIME = 999.0d; //

    public static final int CASHIERS = 5;   // Antalet kassor i simuleringen.
    public static final int MAXPEOPLE = 10; // Max antalet kunder som rymms i affären.


    public static void main(String[] args){
        //
        

        //Skapar en kö där vio sparar event och en state.
        EventQueue queue = new EventQueue();

        //Skapar en state
        SimState state = new SimState();

        //skapar en view
        SimView view = new SimView();

        //Skapar start,close och stop händelserna
        Event start = new Start();
        Event close = new Close(END_TIME);
        Event stop = new Stop(STOP_TIME);

        //Lägger int start,close och stop händelserna i händelsekön
        queue.add(close);
        queue.add(start);
        queue.add(stop);

        //Skapar en simulator med state och queue
        Simulator simulator = new Simulator(queue, state);


        




        
    }
    
}
