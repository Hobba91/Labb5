package Labb5.simulator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/** 
Class that will add and sort events based on the time they are set to occur.
**@author Simon, Gabriel, Elmer, Rasmus
*/
public class EventQueue {
    //ArrayList<Event> queue = new ArrayList<Event>();

	/** 
	method to add a event to the eventqueue.
    @param event, adds a event to the eventqueue.
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
		head = new Node (null, -1);
		head.next = null;
		this.last = head;
	}

	public void add(Event event) {
		Node current = head;
		Node prev = null;

		while (true){
			if()current.next == null){
				current.next == new Node(event);
				last = current.next;
				return ;
			}

			prev = current;
			current = current.next;

			if (event.getTimeStamp() < current.event.getTimeStamp()) {
				prev.next = new Node(event);
				prev.next.next = current;
				return;
			}
		}
	}

	public void first() throws NullPointerException{
		Event next = head.next.event;
		removeNext();
	}

// 	public void add(Event event) {
// 		Event temp;
// 		queue.add(event);
// 		for(int i=1; i < queue.size(); i++){
// 			for(int j=i; j > 0; j--){
// 				if(queue.get(j).getTime() < queue.get(j-1).getTime()){
// 					temp = queue.get(j);
// 					queue.set(j,queue.get(j-1));
// 					queue.set(j-1,temp);
// 				}
// 			}
// 		}
// 	}
// 	/** 
	
//     @return returns true if queue is empty, otherwise false.
//     */
//     public boolean isEmpty() {
// 		if (queue.size() <= 0) {
// 			return true;
// 		} else {
// 			return false;
// 		}
// 	}

// 	/** 
    
// 	@return returns the first event in the eventqueue.
//     */
//     public Event first() throws NoSuchElementException {
// 		if (isEmpty()) {
// 			throw new NoSuchElementException();
// 		} else {
// 			return queue.get(0);
// 		}
// 	}
// 	/** 
//     removes the first event in the eventqueue
//     */
// 	public void removeFirst(){
// 		//for(int i=0; i<queue.size(); i++){
// 		//	queue.set(i, queue.get(i+1));
// 		//}
// 		queue.remove(0);
// 	}
    
// }
