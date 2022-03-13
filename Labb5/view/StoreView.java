package Labb5.view;

import java.util.Observable;
import java.util.Observer;
import Labb5.state.StoreState;
import Labb5.simulator.SimView;
import Labb5.simulator.SimState;
import Labb5.events.Pay;
import Labb5.events.PickUp;
import Labb5.events.Start;
import Labb5.events.Arrival;
import Labb5.events.Close;
import Labb5.events.Stop;

/** 
*@author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/

public class StoreView extends SimView{
    private StoreState store;
    private Pay pay;
    private PickUp pickUp;
    private Arrival arrival;
    /** 
    a constructor that sets which state is to be printed.
    @param state.
    */
    public StoreView(SimState state){
        super(state);
        this.store = (StoreState)state;

    }
    /** 
    updates the simulation whenever a new event happens, and prints it out.
    @param arg0, 
    @param f, the current event
    */
    public void update(Observable arg0, Object f){
        printCurrentEvent();
        
    }

    /** 
    prints the initial parameters of the simulation.
    */
    public void printParametrar (){
        System.out.println("PARAMETRAR");
        System.out.println("=========");
        System.out.println("Antal kassor, N..........:" + store.gettotAmOfRegi());
        System.out.println("Max som ryms, M..........:" + store.getMaxPeople());
        System.out.println("Ankomshastighet, lambda..:" + store.getlambda());
        System.out.println("Plocktider, [P_min..Pmax]: [" + store.getP()[0] +".."+ store.getP()[1]+"]");
        System.out.println("Betaltider, [K_min..Kmax]: [" + store.getK()[0] +".."+ store.getK()[1]+"]");
        System.out.println("Frö, f...................:" + store.getSeed());
        System.out.println("\nFÖRLOPP");
        System.out.println("=======");
        System.out.println("Tid"+"\t"+"Händelse"+"\t"+"Kund"+"\t"+"?"+"\t"+"led"+"\t"+"ledT"+"\t"+"I"+"\t"+"$"+"\t"+":-("+"\t"+"köat"+"\t"+"köT"+"\t"+"köar"+"\t"+"[Kassakö..]");
    }
    /** 
    prints out the results of the simulation.
    */
    public void printResults (){ // (String.format("%.2f", (((store.getVacantTime()/store.gettotAmOfRegi())/(store.getLastPayTime()))*100))
        System.out.println("RESULTAT");
        System.out.println("========");
        System.out.println("\n1) Av " + (store.getCustDone()+store.getMissed()) + " handlade "+store.getCustDone()+ " medan " + store.getMissed() + " missades."); // lägg till antalet handlade.$
        System.out.println("\n2) Total tid "+store.gettotAmOfRegi() + " kassor varit lediga: "+(String.format("%.2f", store.getVacantTime()))+" te.");
        System.out.println("Genomsnittligt ledig kassatid: "+(String.format("%.2f", store.getVacantTime()/store.gettotAmOfRegi()))+" te (dvs "+(String.format("%.2f", (((store.getVacantTime()/store.gettotAmOfRegi())/(store.getLastPayTime()))*100)))+"% av tiden från öppning tills sista kunden"); 
        System.out.println("betalat)."); 
        System.out.println("\n3) Total tid "+ store.getAmountOfCustQueue() + " kunder tvingats köa: " + (String.format("%.2f", store.getQueueTime())) + " te.\nGenomsnittlig kötid: " + (String.format("%.2f", (store.getQueueTime() / store.getAmountOfCustQueue()))) + " te."); // te = tidsenheter.
    }
    /** 
    will print information everytime a new event is being executed. And prints all the variables connected to the simulation.
    */
    public void printCurrentEvent(){

        if(store.getCurrentEvent() instanceof Start){
            printParametrar();
            System.out.println((String.format("%.2f", store.getCurrentEvent().getTime()))+"\t"+store.getCurrentEvent().getName());
        }
        else if(store.getCurrentEvent() instanceof Close){
            System.out.println((String.format("%.2f", store.getCurrentEvent().getTime()))+"\t"+store.getCurrentEvent().getName()+"   \t---" +"\t"+store.getOpenString()+ "\t" + store.getVacantRegi()+"\t"+(String.format("%.2f", store.getVacantTime())) + "\t" + store.getpeopleInStore()+ "\t" + store.getCustDone()+ "\t" + store.getMissed()+"\t"+ store.getAmountOfCustQueue()+"\t"+(String.format("%.2f", store.getQueueTime()))+"\t"+store.getQueueAmount()+"\t"+toArrayString(store.getFifoId()));
        }
        else if(store.getCurrentEvent() instanceof Stop){
            System.out.println((String.format("%.2f", store.getCurrentEvent().getTime()))+"\t"+store.getCurrentEvent().getName());
            printResults();
        }
        else if(store.getCurrentEvent() instanceof Arrival){
            System.out.println((String.format("%.2f", store.getCurrentEvent().getTime()))+"\t"+store.getCurrentEvent().getName()+"  \t"+store.getCurrentCustomer().getID()+"\t"+store.getOpenString() + "\t" + store.getVacantRegi()+"\t"+(String.format("%.2f", store.getVacantTime()))+ "\t" + store.getpeopleInStore()+ "\t" + store.getCustDone()+ "\t" + store.getMissed()+"\t"+ store.getAmountOfCustQueue()+"\t"+(String.format("%.2f", store.getQueueTime()))+"\t"+store.getQueueAmount()+"\t"+toArrayString(store.getFifoId()));
        }
        else if(store.getCurrentEvent() instanceof Pay){
            System.out.println((String.format("%.2f", store.getCurrentEvent().getTime()))+"\t"+store.getCurrentEvent().getName()+"\t"+store.getCurrentCustomer().getID()+"\t"+store.getOpenString()+ "\t" + store.getVacantRegi()+"\t"+(String.format("%.2f", store.getVacantTime()))+ "\t" + store.getpeopleInStore()+ "\t" + store.getCustDone()+ "\t" + store.getMissed()+"\t"+ store.getAmountOfCustQueue()+"\t"+(String.format("%.2f", store.getQueueTime()))+"\t"+store.getQueueAmount()+"\t"+toArrayString(store.getFifoId()));
        }
        else if(store.getCurrentEvent() instanceof PickUp){
                System.out.println((String.format("%.2f", store.getCurrentEvent().getTime()))+"\t"+store.getCurrentEvent().getName()+"     \t"+store.getCurrentCustomer().getID()+"\t"+store.getOpenString()+ "\t" + store.getVacantRegi()+"\t"+(String.format("%.2f", store.getVacantTime()))+ "\t" + store.getpeopleInStore()+ "\t" + store.getCustDone()+ "\t" + store.getMissed()+"\t"+ store.getAmountOfCustQueue()+"\t"+(String.format("%.2f", store.getQueueTime()))+"\t"+store.getQueueAmount()+"\t"+toArrayString(store.getFifoId()));
        }
        
        
    }
    private String toArrayString (int[]array){
        String string = "[";
        for(int i=0; i<array.length;i++){
            if(i==0){
                string = string+array[i];
            } else{
                string = string+","+array[i];
            }
            
        }
        string = string +"]";
        return string;
    }
    
    

    //round(200.3456, 2); // returns 200.35
    // (Math.round(store.getCurrentEvent.getTime*100)/100)
    // (store.getCurrentEvent.getTime).toFixed(2);

    //double input = (store.getCurrentEvent().getTime());

	    // round half-up, no way control
	    // 1205.64
	//System.out.println(String.format("%.2f", input));

	    // 1205.64
	//System.out.format("salary : %.2f", input);

    //





}
