package Labb5.state;

import java.util.ArrayList;
import Labb5.state.ExponentialRandomStream;
import Labb5.state.UniformRandomStream;
import Labb5.simulator.SimState;

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
    private ArrayList<Integer>IDofCust = new <Integer>ArrayList();
    private boolean open = false;
    private int cashiers;
    private String currentID = "";
    private double currentTime = 0.0;
    private int totAmOfRegi;
    private ExponentialRandomStream arrivalTime;
    private UniformRandomStream pickTime;
    private UniformRandomStream payTime;
    private int custdone;
    

    

    public StoreState(int cashiers, int maxpeople, double lambda, double[] P, double[] K, long seed){
        this.totAmOfRegi = cashiers;
        this.maxpeople = maxpeople;
        this.lambda = lambda;
        this.P = P;
        this.K = K;
        this.seed = seed;
        this.arrivalTime = new ExponentialRandomStream(lambda, seed);
        this.pickTime = new UniformRandomStream(P[0], P[1], seed);
        this.payTime = new UniformRandomStream(K[0], K[1], seed);
     
    }

    //kollar om affären är öppen eller stängd.
    public boolean getOpen(){
      return open;
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
    public int getNextInLine(){
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
    public String getname(){
        return name;
    }
    //public int getIDofCust(int num){
    //    return IDofCust.get(num).getID();
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
        custdone++;
    }
    public void addinLine(int ID) {
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
    
    //Returnerar true om affären är full
    public boolean isFull(){
        return(peopleInStore>=maxpeople);
    }

}