package Labb5.state;

import java.util.ArrayList;
import Labb5.state.ExponentialRandomStream;
import Labb5.state.UniformRandomStream;
import Labb5.simulator.SimState;
import Labb5.simulator.Event;
import Labb5.events.Arrival;
import Labb5.events.Pay;
import Labb5.events.Stop;

/** 
A class that keeps track of the store and all the different variables that is connected to it.
*@author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/

public class StoreState extends SimState{
    private CustomerFactory customerFactory;
    
    private int maxpeople;
    private double lambda;
    private long seed;
    private FIFO inLine = new FIFO();
    private int peopleInStore = 0;
    private int totalAmountOfCustomer = 0;
    private double[] P;
    private double[] K;
    private int missedCust = 0;
    private String name = "";
    private ArrayList<Integer>idOfCust = new <Integer>ArrayList();
    private boolean open = false;
    private int cashiers;
    private String currentID = "";
    private double currentTime = 0.0;
    private int totAmOfRegi;
    private int vacantRegi;
    private ExponentialRandomStream arrivalTime;
    private UniformRandomStream pickTime;
    private UniformRandomStream payTime;
    private int custDone = 0;
    private double vacantTime = 0;
    private int amountOfCustQueue = 0;
    private Event currentEvent;
    private Customer currentCustomer;
    private double LastTime = 0;
    private double queue = 0.0;
    private double lastPayTime;

    

    /** 
    @param cashiers, the amount of registers available in the store
    @param maxpeople, the max amount of people allowed in the store at once..
    @param lambda, the speed that customers arrive. 
    @param []P, the minium and maximum picktimes in array format.
    @param []K, the minimu and maximum pay times in array format.$
    @param seed, a seed that determines the "random" aspect.
    */

    public StoreState(int cashiers, int maxpeople, double lambda, double[] P, double[] K, long seed){
        this.totAmOfRegi = cashiers;
        this.vacantRegi = this.totAmOfRegi;
        this.maxpeople = maxpeople;
        this.lambda = lambda;
        this.P = P;
        this.K = K;
        this.seed = seed;
        this.arrivalTime = new ExponentialRandomStream(lambda, seed);
        this.pickTime = new UniformRandomStream(P[0], P[1], seed);
        this.payTime = new UniformRandomStream(K[0], K[1], seed);
        this.customerFactory = new CustomerFactory(0);
     
    }

    //kollar om affären är öppen eller stängd
    /** 
    @return true if the store is open
    */
    public boolean getOpen(){
      return open;
    }
    /** 
    @return Ö if open, S if closed
    */
    public String getOpenString(){
        if(getOpen()){
            return "Ö";
        }else{
            return "S";
        }
    }
    /** 
    @param variable is true if you want to open store, false if close.
    */
    public void SetOpen (boolean newOpen){
        this.open = newOpen;
    }
    /** 
    @return The maximum amount of people allowed in store
    */
    public int getMaxPeople(){
        return maxpeople;    }
    /**  
    @return amount of cashiers in store.
    */
    public int getCashiers(){
        return cashiers;
    }
    /** 
    @return the size of the customer queue
    */
    public int getQueueLine(){
        return inLine.size();
    }
    /** 
    @return the totalamount of registers in the store.
    */
    public int gettotAmOfRegi(){
        return totAmOfRegi;
    }
    /** 
    @return amount of vacant registers.
    */
    public int getVacantRegi(){
        return vacantRegi;
    }
    /** 
    increases the amount of vacant registers by one.
    */
    public void incVacantRegi(){
        this.vacantRegi++;
    }
    /** 
    decreases the amount of vacant registers by one.
    */
    public void decVacantRegi(){
        this.vacantRegi--;
    }
    /** 
    @return a String with all the customers in the queue.
    */
    public String getQueue(){
        return inLine.toString();
    }
    /** 
    @return the speed which customers arrive.
    */
    public double getlambda(){
        return lambda;
    }
    /** 
    @return array with the minimum and maximum pay times.
    */
    public double[] getK(){
        return K;
    }
    /** 
    @return a array with the minimum and maximum pick times
    */
    public double[] getP(){
        return P;
    }
    /** 
    @return the seed witch determines the "random" aspect.
    */
    public long getSeed(){
        return seed;
    }
    /** 
    @return the first "customer" in the queue.
    */
    public Customer getNextInLine(){
        return inLine.first();
    }
    /** 
    @return the current amount of people in the store.
    */
    public int getpeopleInStore(){
        return peopleInStore;
    }
    /** 
    @return the total amount of customers that have come to the store.
    */
    public int gettotalAmountOfCustomer(){
        return totalAmountOfCustomer;
    }
    /** 
    @return the amount of customers that have been missed during the simulation.
    */
    public int getMissed(){
        return missedCust;
    }
    /** 
    @return the current queue time..
    */
    public double getQueueTime(){
        return inLine.getInLineTime();
    }
    /** 
    increases the total amount of customers that have appeard by one.
    */
    public void inctotalAmountOfCustomer() {
        this.totalAmountOfCustomer++;
    }
     /** 
    increases the amount of people in the store by one.
    */
    public void incpeopleInStore() {
        this.peopleInStore++;
    }
     /** 
    increases the total amount of customers that have been missed
    */
    public void incmissedCust() {
        this.missedCust
        ++;
    }
     /** 
    increases the time people have been queing
    
    */
    public void incinLineTime(double time) {
        inLine.incinLineTime(time);
    }
     /** 
    decreases the amount of people in the store, also increases the amount of customers who are "done" shopping.
    */
    public void decpeopleInStore() {
        peopleInStore--;
        custDone++;
    }
     /** 
    adds a customer to the queue line.
    */
    public void addinLine(Customer ID) {
        inLine.add(ID);
    }
     /** 
    see if the queue line is empty or not.
    @return true if the customer queue is
    */
    public boolean Lineisempty() {
        return inLine.isEmpty();
    }
     /** 
    removes the customer first in line.
    */
    public void removefirstinLine(){
        inLine.removeFirst();
    }
     /**  
    @return the arrival time
    */ 
    public ExponentialRandomStream getArrivalTime(){
        return arrivalTime;
    }
      /** 
    @returnthe pickup time
    */
    public UniformRandomStream getPickTime(){
        return pickTime;
    }
    /** 
    @return the pay time
    */
    public UniformRandomStream getPayTime(){
        return payTime;
    }
    
    /** 
    updates variables that are connected to the current event being executed, also notifies 
    the observers.
    @param event, the event thats currently being executed.
    */
    public void update(Event event) {
        this.currentEvent = event;
        if(!(this.currentEvent instanceof Stop)){
            if(getOpen() == false && this.currentEvent instanceof Arrival){

            }else{
                vacantTime += (currentEvent.getTime()-LastTime)*getVacantRegi();
            }
            
        }
        incinLineTime(currentEvent.getTime()-LastTime);
        setChanged();
        notifyObservers();
        LastTime = this.currentEvent.getTime();

        if (this.currentEvent instanceof Pay){
            this.lastPayTime = this.currentEvent.getTime();
        }
    }
    /** 
    @return the time since last customer finished paying.
    */
    public double getLastPayTime(){
        return this.lastPayTime;
    }
    /** 
    @return currentEvent, the current event
    */
    public Event getCurrentEvent(){
        return currentEvent;
    }
    
    //Returnerar true om affären är full
    /** 
    @return true if store is full, false if not.
    */
    public boolean isFull(){
        return(peopleInStore>=maxpeople);
    }
    /** 
    @return the amount of customers who are "done" with their shopping.
    */
    public int getCustDone(){
        return custDone;
    }
    /**  
    @return The amount of time cashiers have been vacant.
    */
    public double getVacantTime(){
        return vacantTime;
    }
    /** 
    @param The amount of time vacantime is increased by
    increases the vacant time
    */
    public void incVacantTime(double time){
        vacantTime += time;
    }
    /** 
    @return returns a new customer.
    */
    public Customer createCustomer (){
        Customer customer = customerFactory.createCustomer();
        return customer;
    }
    /** 
    @return the amount of customers in the customer queue.
    */
    public int getAmountOfCustQueue(){
        return amountOfCustQueue;
    }
    /** 
    increases the current amount of customers in the customer queue.
    */
    public void incAmountOfCustQueue(){
        amountOfCustQueue++;
    }
    /** 
    @param The customer that is set
    updates the currentcustomer depending on the current customer that is being handled.
    */
    public void setCurrentCustomer(Customer customer){
        this.currentCustomer = customer;
    }
    /** 
    @return returns the current customer that is being "handled".
    */
    public Customer getCurrentCustomer(){
        return currentCustomer;
    }
    /** 
    @return returns the total amount of people who have been in the queue.
    */
    public int getQueueAmount(){
        return inLine.getPeopleInLineTotal();
    }
    /** 
    @return returns a array with all the customers who are standing in the queue line.
    */
    public int[] getFifoId(){
        int[] id= new int[inLine.size()];
        for(int i=0;i<inLine.size();i++){
            id[i] = inLine.getCustomer(i).getID();
        }
        return id;
    }


}