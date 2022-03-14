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
    boolean to see if store is open
    @return true if the store is open
    */
    public boolean getOpen(){
      return open;
    }
    /** 
    used to get the letter in the result
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
    boolean to know if store is open
    @param variable is true if you want to open store, false if close.
    */
    public void SetOpen (boolean newOpen){
        this.open = newOpen;
    }
    /** 
    get the maximum amount of people allowed in the store.
    @return The maximum amount of people allowed in store
    */
    public int getMaxPeople(){
        return maxpeople;    }
    /**  
    get the amount of cashiers in the store.
    @return amount of cashiers in store.
    */
    public int getCashiers(){
        return cashiers;
    }
    /** 
    gives the size of the customer queue.
    @return the size of the customer queue
    */
    public int getQueueLine(){
        return inLine.size();
    }
    /** 
    gives the total amount of registers in the store.
    @return the total amount of registers in the store.
    */
    public int gettotAmOfRegi(){
        return totAmOfRegi;
    }
    /** 
    gives the total amount of vacant registers.
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
    gives a String with all the customers in the queue.
    @return a String with all the customers in the queue.
    */
    public String getQueue(){
        return inLine.toString();
    }
    /** 
    gets the speed which customers arrive with.
    @return the speed which customers arrive.
    */
    public double getlambda(){
        return lambda;
    }
    /** 
    gets the minimum and maximum pay times.
    @return array with the minimum and maximum pay times.
    */
    public double[] getK(){
        return K;
    }
    /** 
    gets the minimum and maximum pick times.
    @return a array with the minimum and maximum pick times
    */
    public double[] getP(){
        return P;
    }
    /** 
    gets the seed that determines the "random" aspect.
    @return the seed witch determines the "random" aspect.
    */
    public long getSeed(){
        return seed;
    }
    /** 
    gets the first customer in the customer queue.
    @return the first "customer" in the queue.
    */
    public Customer getNextInLine(){
        return inLine.first();
    }
    /** 
    gets the current amount of people currently in the store.
    @return the current amount of people in the store.
    */
    public int getpeopleInStore(){
        return peopleInStore;
    }
    /** 
    gets the total amount of customers that have come to the store.
    @return the total amount of customers that have come to the store.
    */
    public int gettotalAmountOfCustomer(){
        return totalAmountOfCustomer;
    }
    /** 
    gets the amount of customers that have been missed
    @return the amount of customers that have been missed during the simulation.
    */
    public int getMissed(){
        return missedCust;
    }
    /** 
    gets the current queue time.
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
    gets the arrival time.
    @return the arrival time
    */ 
    public ExponentialRandomStream getArrivalTime(){
        return arrivalTime;
    }
      /** 
    gets the time it takes to pick something up.
    @return the pickup time
    */
    public UniformRandomStream getPickTime(){
        return pickTime;
    }
    /** 
    gets the time it takes to pay for something.
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
    gets the time since laste customer finished a purchase.
    @return the time since last customer finished paying.
    */
    public double getLastPayTime(){
        return this.lastPayTime;
    }
    /** 
    gets the current event thats taking place.
    @return currentEvent, the current event
    */
    public Event getCurrentEvent(){
        return currentEvent;
    }
    
    //Returnerar true om affären är full
    /** 
    see if the store is full or not.
    @return true if store is full false if not.
    */
    public boolean isFull(){
        return(peopleInStore>=maxpeople);
    }
    /** 
    gest the current amount of customers who are "done" shopping.
    @return the amount of customers who are "done" with their shopping.
    */
    public int getCustDone(){
        return custDone;
    }
    /**  
    gets the amount of time the cashiers have been vacant.
    @return The amount of time cashiers have been vacant.
    */
    public double getVacantTime(){
        return vacantTime;
    }
    /** 
    increases the vacant time
    @param time, The amount of time vacantime is increased by
    */
    public void incVacantTime(double time){
        vacantTime += time;
    }
    /** 
    creates a customer with help of customer factory
    @return returns a new customer.
    */
    public Customer createCustomer (){
        Customer customer = customerFactory.createCustomer();
        return customer;
    }
    /** 
    will get the amount in customer que
    @return the amount of customers in the customer queue.
    */
    public int getAmountOfCustQueue(){
        return amountOfCustQueue;
    }
    /** 
    increases the amount of customers in que
    increases the current amount of customers in the customer queue.
    */
    public void incAmountOfCustQueue(){
        amountOfCustQueue++;
    }
    /** 
    Sets the current customer
    @param The customer that is set
    updates the currentcustomer depending on the current customer that is being handled.
    */
    public void setCurrentCustomer(Customer customer){
        this.currentCustomer = customer;
    }
    /** 
    gets the current customer
    @return returns the current customer that is being "handled".
    */
    public Customer getCurrentCustomer(){
        return currentCustomer;
    }
    /** 
    gets the total amount of people in queue
    @return returns the total amount of people who have been in the queue.
    */
    public int getQueueAmount(){
        return inLine.getPeopleInLineTotal();
    }
    /** 
    calls Fifo for iDs of the customers
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