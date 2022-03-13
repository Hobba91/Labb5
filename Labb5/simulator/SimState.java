package Labb5.simulator;

import java.util.Observable;

/** 
*@author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/

/** 
The generall state that will start and stop the simulation.
*/ 

public class SimState extends Observable {

    private boolean simStop; 

    /** 
    method to see if the simulation should continue or be stopped.
    return simStop, 
    */ 
    public boolean getSimStop (){
        return simStop;
    }
    /** 
    method that stops the simulation
    */
    public void SetSim(){
        simStop = true;
    }
    /** 
    method used to update variables when a new event takes place.
    @param event, the current event that is taking place.
    */
    public void update(Event event){
        setChanged();
        notifyObservers();
    }





}
    
