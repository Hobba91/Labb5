package Labb5.main;

//import Labb5.events.Stop;
//import Labb5.events.Start;
//import Labb5.events.Close;
import Labb5.simulator.*;
import Labb5.state.CashState;

public class RunSim {
    public static void main(String[] args){
        final int Cashier;
        final int MaxPeps

        //
        

        //Skapar en kö där vio sparar event och en state.
        EventQueue queue = new EventQueue;

        //Skapar en state
        State state = new State()
        
        //Skapar en simulator med state och queue
        Simulator simulator = new Simulator(queue, state);

        //skapar en view
        Simview view = new Simview()

        queue.addEvent(Start)
        queue.addEvent(Close)
        queue.addEvent(Stop)

        




        
    }
    
}
