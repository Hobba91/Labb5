package Labb5.state;

import java.util.ArrayList;
import Labb5.state.ExponentialRandomStream;
import Labb5.state.UniformRandomStream;
import Labb5.simulator.SimState;
import Labb5.simulator.Event;

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

    //kollar om affären är öppen eller stängd.
    public boolean getOpen(){
      return open;
    }
    public String getOpenString(){
        if(getOpen()){
            return "Ö";
        }else{
            return "S";
        }
    }
    //sätt värdet på open variabeln. (stäng butiken eller öppna den.)
    public void SetOpen (boolean newOpen){
        this.open = newOpen;
    }
    //få fram hur måtotAmOfRegisoner som rymms i affären.
    public int getMaxPeople(){
        return maxpeople;    }
    // få mängden kassor.
    public int getCashiers(){
        return cashiers;
    }
    public int getQueueLine(){
        return inLine.size();
    }
    public int gettotAmOfRegi(){
        return totAmOfRegi;
    }
    public int getVacantRegi(){
        return vacantRegi;
    }
    public void incVacantRegi(){
        this.vacantRegi++;
    }
    public void decVacantRegi(){
        this.vacantRegi--;
    }
    public String getQueue(){
        return inLine.toString();
    }
    public double getlambda(){
        return lambda;
    }
    public double[] getK(){
        return K;
    }
    public double[] getP(){
        return P;
    }
    public long getSeed(){
        return seed;
    }
    public Customer getNextInLine(){
        return inLine.first();
    }
    public int getpeopleInStore(){
        return peopleInStore;
    }
    public int gettotalAmountOfCustomer(){
        return totalAmountOfCustomer;
    }
    public int getMissed(){
        return missedCust;
    }
    public double getQueueTime(){
        return inLine.getInLineTime();
    }
     //public int getIDofCust(int num){
    ////    return IDofCust.get(num).getID();
    //}

    public void setname(String nam){
       this.name = nam;
    }

    public void setIDofCust(String ident) {
        this.currentID = ident;
    }
    public void setcurrentTime(double time){
        this.currentTime = time;
    }
    public void inctotalAmountOfCustomer() {
        this.totalAmountOfCustomer++;
    }
    public void incpeopleInStore() {
        this.peopleInStore++;
    }
    public void incmissedCust() {
        this.missedCust++;
    }
    public void incinLineTime(double time) {
        inLine.incinLineTime(time);
    }
    public void decpeopleInStore() {
        peopleInStore--;
        custDone++;
    }
    public void addinLine(Customer ID) {
        inLine.add(ID);
    }
    public boolean Lineisempty() {
        return inLine.isEmpty();
    }
    public void removefirstinLine(){
        inLine.removeFirst();
    }
    
    public ExponentialRandomStream getArrivalTime(){
        return arrivalTime;
    }

    public UniformRandomStream getPickTime(){
        return pickTime;
    }

    public UniformRandomStream getPayTime(){
        return payTime;
    }
    
    public void update(Event event) {
        this.currentEvent = event;
        vacantTime += (currentEvent.getTime()-LastTime)*getVacantRegi();
        incinLineTime(currentEvent.getTime()-LastTime);
        setChanged();
        notifyObservers();
        LastTime = this.currentEvent.getTime();
    }

    public Event getCurrentEvent(){
        return currentEvent;
    }
    
    //Returnerar true om affären är full
    public boolean isFull(){
        return(peopleInStore>=maxpeople);
    }

    public int getCustDone(){
        return custDone;
    }

    public double getVacantTime(){
        return vacantTime;
    }

    public void incVacantTime(double time){
        vacantTime += time;
    }

    public Customer createCustomer (){
        Customer customer = customerFactory.createCustomer();
        return customer;
    }

    public int getAmountOfCustQueue(){
        return amountOfCustQueue;
    }

    public void incAmountOfCustQueue(){
        amountOfCustQueue++;
    }

    public void setCurrentCustomer(Customer customer){
        this.currentCustomer = customer;
    }

    public Customer getCurrentCustomer(){
        return currentCustomer;
    }

    public int getQueueAmount(){
        return inLine.getPeopleInLineTotal();
    }

    public int[] getFifoId(){
        int[] id= new int[inLine.size()];
        for(int i=0;i<inLine.size();i++){
            id[i] = inLine.getCustomer(i).getID();
        }
        return id;
    }


}