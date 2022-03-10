package Labb5.simulator;

import java.util.Observable;

/*
Class that 

*/ 

public class SimState extends Observable {

    private boolean simStop;  // är en "nödbroms" som stoppar simuleringen om den blir sann. 

    // En get metod för att kunna kolla om simuleringen ska stoppas.
    public boolean getSimStop (){
        return simStop;
    }
    // metod för att stoppa simuleringen.
    public void SetSim(){
        simStop = true;
    }
    //uppdaterar observers
    public void update(Event event){
        setChanged();
        notifyObservers();
    }





}
    
