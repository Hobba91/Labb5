package Labb5.simulator;

public class Simulator {
    private SimState state;
    private EventQueue queue;

    public Simulator(EventQueue queue, SimState state){


        this.queue = queue;
        this.state = state;
    }
    

    // loopar allting så länge SimStop är falsk.
    public void Run(){

        while(state.getSimStop() != true){
            Event currentEvent = queue.first();
            currentEvent.removeFirst();
            currentEvent.doMe();
        }

    }
}
