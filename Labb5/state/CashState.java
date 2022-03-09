package Labb5.state;

import java.util.Arraylist;
import Labb5.ExponentialRandomStream;
import Labb5.UniformRandomStream;
import Labb5.simulator.State;

public class CashState {
    
    boolean open = falsexstends State e
    
    private
    private
    private
    private
    private
    private
    private
    private


; // se if store is open

    //**boolean open = false; // se if store is open
    private int MAXPEOPLE;
    

    public Store (int CASHIERS,int MAXPEOPLE){
        this.CASHIERS = CASHIERS;
        this.MAXPEOPLE =MAXPEOPLE;   
        peopleInLine = new FIFO();
        peopleInLineTotal = 0;

    }

    //kollar om affären är öppen eller stängd.
    public boolean getOpen(){
     
}
       return open;
    }
    //sätt värdet på open variabeln. (stäng butiken eller öppna den.)
    public void setOpen (boolean newOpen){
        this.open = newopen;
    }
    public int getMaxPeople(){
        return this.MAXPEOPLE;
    }
    public int getCashiers(){
        return this.CASHIERS;
    }
    public FIFO getQueueLine(){
        return this.peopleInLineTotal;
    }
    public void addPeopleInLineTotal(){
        peopleInLineTotal++;
    }

