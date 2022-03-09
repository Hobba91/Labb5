package Labb5.main;

import java.util.random;

public class Optimize {

    public static void main(String[] args) {

    }

    private static StoreState method,(int cash, long seed) {

        //variables
        final double[] PICK_TIME = { LOW_COLLECTION_TIME, HIGH_COLLECTION_TIME};
        final double[] PAY_TIME = {LOW_PAYMENT_TIME, HIGH_COLLECTION_TIME};

        //creates a state refrence
        StoreState specificstate = new StoreState();

        
        EventQueue queue = new EventQueue();
        State state = new State();
        Simulator sim = new Simulator(queue, state)

        StartEvent startevent = new Startevent(specificstate, queue)



    }
    
}
