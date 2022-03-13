package Labb5.simulator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/*
*@authors Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/

/*
Class that will add and sort events based on the time they are set to occur.
*/
public class EventQueue {
    ArrayList<Event> queue = new ArrayList<Event>();

	/*
	method to add a event to the eventqueue.
    @param event, adds a event to the eventqueue.
    */
	public void add(Event event) {
		Event temp;
		queue.add(event);
		for(int i=1; i < queue.size(); i++){
			for(int j=i; j > 0; j--){
				if(queue.get(j).getTime() < queue.get(j-1).getTime()){
					temp = queue.get(j);
					queue.set(j,queue.get(j-1));
					queue.set(j-1,temp);
				}
			}
		}
	}
	/*
	
    @return returns true if queue is empty, otherwise false.
    */
    public boolean isEmpty() {
		if (queue.size() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
    
	@return returns the first event in the eventqueue.
    */
    public Event first() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return queue.get(0);
		}
	}
	/*
    removes the first event in the eventqueue
    */
	public void removeFirst(){
		//for(int i=0; i<queue.size(); i++){
		//	queue.set(i, queue.get(i+1));
		//}
		queue.remove(0);
	}
    
}
