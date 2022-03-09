package Labb5.simulator;

import java.util.Observable;
import Labb5.state.CashState;

/*
Class that 

*/ 

public class SimState extends Observable {

    private int time; // variabel som håller koll på tiden.
    private boolean simStop;  // är en "nödbroms" som stoppar simuleringen om den blir sann. 

    private double LOW_COLLECTION_TIME;
    private double HIGH_COLLECTION_TIME;
    private double LOW_PAYMENT_TIME;
    private double HIGH_PAYMENT_TIME;
    private int SEED;
    private double END_TIME;
    private double STOP_TIME;
    private double CASHIERS;
    private double MAXPEOPLE;

    private CashState store;


    
    public SimState(double LOW_COLLECTION_TIME,double HIGH_COLLECTION_TIME,double LOW_PAYMENT_TIME,
                    double HIGH_PAYMENT_TIME,int SEED,double END_TIME,double STOP_TIME,int CASHIERS,int MAXPEOPLE){
        
        simStop = false;
        time = 0; // sätter så tiden börjar/startar på 0.


        
        this.LOW_COLLECTION_TIME = LOW_COLLECTION_TIME;
        this.HIGH_COLLECTION_TIME = HIGH_COLLECTION_TIME;
        this.LOW_PAYMENT_TIME = LOW_PAYMENT_TIME;
        this.HIGH_PAYMENT_TIME = HIGH_PAYMENT_TIME;
        this.SEED = SEED;
        this.END_TIME = END_TIME;
        this.STOP_TIME = STOP_TIME;
        this.CASHIERS = CASHIERS;
        this.MAXPEOPLE = MAXPEOPLE;
        
        //Skapar en ny "affär".
        store = store.Store(CASHIERS, MAXPEOPLE);
    }
    // En get metod för att kunna kolla om simuleringen ska stoppas.
    public boolean getSimStop (){
        return simStop;
    }
    // metod för att stoppa simuleringen.
    public void StopSim(){
        simStop = true;

    }


}
    
}
