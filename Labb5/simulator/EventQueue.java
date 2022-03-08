package Labb5.simulator;

import java.util.NoSuchElementException;

public class EventQueue {
    public Event queue[] = new Event[1000];


	public void add(Event event) {
		queue[queue.length] = event;
	}

    public boolean isEmpty() {
		if (queue.length <= 0) {
			return true;
		} else {
			return false;
		}
	}

    public Event first() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return queue[0];
		}
	}
	public void removeFirst(){
		
	}
    
}
