package Labb5.simulator;

import java.util.NoSuchElementException;

/** 
Class that will add and sort events based on the time they are set to occur.
*@author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/

public class EventQueue {
	
	/**
	creates a "node" that we will store our events in
	/**
	the storage of all que
	 */	
	private class Node {
        private Event event;
        private Node next;

        Node(Event event) {
            this.event = event;

        }

    }

    private Node head;
    private Node last;

    public EventQueue() {
        head = new Node(null);
        head.next = null;
        this.last = head;
    }
	
	/**
	// adds an event to the queue and sorts it autamatically
	*/
    public void add(Event event) {

        Node current = head;
        Node prev = null;
	// loopar igenom  alla våra 
        while (true) {
 
            if (current.next == null) {
                current.next = new Node(event);
                last = current.next;
                return;
            }

			//sätter detta event till det innan samt så blir nästa event current
            prev = current;
            current = current.next;

			// sparar tiden
            if (event.getTime() < current.event.getTime()) {
                prev.next = new Node(event);
                prev.next.next = current;
                return;
            }

        }

    }

	/**
	Gets the first event from our queue
	@return returns the first event.
	 */
    public Event first() {
        
        Event next = head.next.event;
        return next;
    }
	/**
	removes the first event from our que,
	 */
    public void removeFirst() {
        try {
            head.next = head.next.next;
        } catch (NullPointerException e) {
            return;
        }
    }
    
	/**
	checks to see if our queue is emtpy
	@return checks if the queue is empy
	 */
    public boolean isEmpty() {
        return head.next == last;
    }



	
    // ArrayList<Event> queue = new ArrayList<Event>();

	// /** 
	// method to add a event to the eventqueue.
    // @param event, adds a event to the eventqueue.
    // */
	// public void add(Event event) {
	// 	Event temp;
	// 	queue.add(event);
	// 	for(int i=1; i < queue.size(); i++){
	// 		for(int j=i; j > 0; j--){
	// 			if(queue.get(j).getTime() < queue.get(j-1).getTime()){
	// 				temp = queue.get(j);
	// 				queue.set(j,queue.get(j-1));
	// 				queue.set(j-1,temp);
	// 			}
	// 		}
	// 	}
	// }
	// /** 
	
    // @return returns true if queue is empty, otherwise false.
    // */
    // public boolean isEmpty() {
	// 	if (queue.size() <= 0) {
	// 		return true;
	// 	} else {
	// 		return false;
	// 	}
	// }

	// /** 
    
	// @return returns the first event in the eventqueue.
    // */
    // public Event first() throws NoSuchElementException {
	// 	if (isEmpty()) {
	// 		throw new NoSuchElementException();
	// 	} else {
	// 		return queue.get(0);
	// 	}
	// }
	// /** 
    // removes the first event in the eventqueue
    // */
	// public void removeFirst(){
	// 	//for(int i=0; i<queue.size(); i++){
	// 	//	queue.set(i, queue.get(i+1));
	// 	//}
	// 	queue.remove(0);
	// }
    
}
