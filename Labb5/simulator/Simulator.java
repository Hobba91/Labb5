package Labb5.simulator;

import Labb5.state.ExponentialRandomStream;
import Labb5.state.UniformRandomStream;
import Labb5.main.RunSim;
import Labb5.events.Start;

public class Simulator {
    private SimState state;
    private EventQueue queue;

    public Simulator(EventQueue queue, SimState state){


        this.queue = queue;
        this.state = state;

        
    }
    

    // loopar allting så länge SimStop är falsk.
    public void Run(){
        
        Event start = new Start();
        queue.add(start);

        ExponentialRandomStream randArrivialTime = new ExponentialRandomStream(RunSim.L,RunSim.SEED);
        UniformRandomStream randColletctionTime = new UniformRandomStream(RunSim.LOW_COLLECTION_TIME,RunSim.HIGH_COLLECTION_TIME,RunSim.SEED);
        UniformRandomStream randPaymentTime = new UniformRandomStream(RunSim.LOW_PAYMENT_TIME,RunSim.HIGH_PAYMENT_TIME,RunSim.SEED);

        while(state.getSimStop() != true){
            Event currentEvent = queue.first();
            queue.removeFirst();
            currentEvent.doMe(queue, randArrivialTime.next());
        }

    }
}
