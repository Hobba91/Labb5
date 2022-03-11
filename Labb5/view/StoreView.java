package Labb5.view;

import java.util.Observable;
import java.util.Observer;
import Labb5.state.StoreState;
import Labb5.simulator.SimView;
import Labb5.simulator.SimState;
import Labb5.events.Pay;

public class StoreView extends SimView{

    private StoreState store;
    private double LastTime = 0;
    private Pay pay;

    public void update(Observable arg0, Object f){
        printCurrentEvent();
        LastTime = store.getCurrentEvent().getTime();
        pay = (Pay)store.getCurrentEvent();
        
    }


    public void PrintView(SimState state){
        store = (StoreState)state;
    }
    public void printParametrar (){
        System.out.println("PARAMETRAR");
        System.out.println("=========");
        System.out.println("Antal kassor, N..........:" + store.gettotAmOfRegi());
        System.out.println("Max som ryms, M..........:" + store.getMaxPeople());
        System.out.println("Ankomshastighet, lambda..:" + store.getlambda());
        System.out.println("Plocktider, [P_min..Pmax]: [" + store.getP()[0] +".."+ store.getP()[1]);
        System.out.println("Betaltider, [K_min..Kmax]: [" + store.getK()[0] +".."+ store.getK()[1]);
        System.out.println("Frö, f...................:" + store.getSeed());
        System.out.println("\nFÖRLOPP");
        System.out.println("=======");
        System.out.println(" Tid   Händelse   Kund   ?   led   ledT   I   $   :-(   köat   köT   köar   [Kassakö..]");
    }
    public void printResults (){
        System.out.println("RESULTAT");
        System.out.println("========");
        System.out.println("\n1) Av " + store.gettotalAmountOfCustomer() + " handlade "+ "//handlande"  + " medans " + store.getMissed() + " missades."); // lägg till antalet handlade.$
        System.out.println("\n2) Total tid "); // lägg till variabler.
        System.out.println("\n3) Total tid "+ store.getAmountOfCustQueue() + " kunder tvingats köa: "); // te = tidsenheter.
    }
    public void printCurrentEvent(){
        System.out.println(store.getCurrentEvent().getTime()+" "+store.getCurrentEvent().getName()+" "+pay.getCustomer());
    }
    




}
