package Labb5.simulator;

import java.util.NoSuchElementException;

/*
*@authors Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/

/*
The class that runs the simulation.
*/
public class Simulator {
    private SimState state;
    private EventQueue queue;
    /*
    Constructor that sets which queue and store to be used.
    @param queue, the eventqueue.
    @param state, the state that is being used.
    */
    public Simulator(EventQueue queue, SimState state){


        this.queue = queue;
        this.state = state;

    }
    

    /*
    method that runs the simulation, and will continue to execute events aslong as the variable
    SimStop is false.
    */
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
