package Labb5.state;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import Labb5.state.Customer;

/** 
Class that represents the customer queue.
*@author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/


class FIFO {
    private int maxSize = 0;
    private double inLineTime = 0.0;
    ArrayList<Customer> queue = new ArrayList<Customer>();
    private int peopleInLineTotal = 0;

    /** 
    gives the current size of the que
    @return returns the current size of the queue.
    */
    public int size(){
        return queue.size();
    }

    /** 
    gives the maximum size of the customer que
    @return maxSize, returns the maxsize of the customer queue.
    */
    public int maxsize(){
        return maxSize;
    }

    /** 
    checks to se if the list is empty
    @return returns true if customer queue is empty, false if not.
    */
    public boolean isEmpty(){
        return queue.size() == 0;
    }

    /** 
    gives the Id of the first customer in que
    @return returns the first customer in the customer queue.
    */
    public Customer first() {
        if (queue.size() == 0) {
            throw new NoSuchElementException("There is no element first in queue");
        }
        return queue.get(0);
    }
    /** 
    gives a customer in a specific position
    @param n, get customer in postition n
    @return returns the customer in location n if it exists.
    */
    public Customer getCustomer(int n) {
        if (queue.size() == 0) {
            throw new NoSuchElementException("There is no element first in queue");
        }
        return queue.get(n);
    }

    /** 
    puts all the customers in a string
    @return string, takes all the customers in the queue and turn them into a single string.
    */
    public String toString() {
        String string = "[";
        for (int ele = 0; ele < queue.size(); ele++) {
            string += String.valueOf(queue.get(ele));
            if (ele < queue.size()-1){
                string +=", ";
            }
        }
        string += "]";
        return string;
    }
    
    /** 
    adds a customer and increases the size of the customer queue.
    */
    public void add(Customer item) {
        queue.add(item);
        peopleInLineTotal++;
        if (queue.size() > maxSize) {
            maxSize = queue.size();
        }
    }

    /** 
    removes the first customer in the customer queue.
    */
    public void removeFirst() {
        if (queue.size() == 0) {
            throw new NoSuchElementException("There is no element to remove from queue");
        }
        queue.remove(0);
    }

    /** 
    gives the amount of time a register has been free
    @return inLineTime, returns the time that the registers have been free or vacant.
    */
    public double getInLineTime() {
        return inLineTime;
    }

    /** 
    gives the amount of people in the que
    @return returns the amount of customers in the queue.
    */
    public int getPeopleInLineTotal() {
        return queue.size();
    }
    /** 
    @param time, determines how long the queue is, depending on the amount of people.
    */
    public void incinLineTime(double time) {
        inLineTime += (time * queue.size());
        
    }
}
