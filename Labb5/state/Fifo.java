package Labb5.state;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import Labb5.state.Customer;

class FIFO {
    private int maxSize = 0;
    private double inLineTime = 0.0;
    ArrayList<Customer> queue = new ArrayList<Customer>();
    private int peopleInLineTotal = 0;

    //storleken på vår kö
    public int size(){
        return queue.size();
    }

    //storleken på hur stor kö maximalt har varit
    public int maxsize(){
        return maxSize;
    }

    //kollar om kön är tom
    public boolean isEmpty(){
        return queue.size() == 0;
    }

    //ger första objektet i kön
    public Customer first() {
        if (queue.size() == 0) {
            throw new NoSuchElementException("There is no element first in queue");
        }
        return queue.get(0);
    }

    //gör elementen i kön till en lång sträng
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
    
    //lägger till ett objekt och ändrar variabel maxsize
    public void add(Customer item) {
        queue.add(item);
        peopleInLineTotal++;
        if (queue.size() > maxSize) {
            maxSize = queue.size();
        }
    }

    //tar bort den försa io kön
    public void removeFirst() {
        if (queue.size() == 0) {
            throw new NoSuchElementException("There is no element to remove from queue");
        }
        queue.remove(0);
    }

    //ger tiden som kassorna har varit lediga
    public double getInLineTime() {
        return inLineTime;
    }
    public Customer getinline(){
        return queue;
    }

    //hur många som är i kö
    public int getPeopleInLineTotal() {
        return queue.size();
    }
    //tiden det tar gånger hur lång kön är.
    public void incinLineTime(double time) {
        inLineTime += (time * queue.size());
        
    }
}
