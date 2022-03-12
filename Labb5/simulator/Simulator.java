package Labb5.simulator;

import java.util.NoSuchElementException;

public class Simulator {
    private SimState state;
    private EventQueue queue;

    public Simulator(EventQueue queue, SimState state){


        this.queue = queue;
        this.state = state;
        Run();

    }
    

    // loopar allting så länge SimStop är falsk.
    public void Run(){
        while(state.getSimStop() != true){
            try{
                Event currentEvent = queue.first();
                queue.removeFirst();
                currentEvent.doMe(queue, state);
            }catch(NoSuchElementException error){
                break;
            }
            
        }

    }
}
