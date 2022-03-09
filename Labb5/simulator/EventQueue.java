package Labb5.simulator;

import java.util.NoSuchElementException;

public class EventQueue {
    public Event queue[] = new Event[1000];
	public void add(Event event) {
		Event temp;
		queue[queue.length] = event;
		for(int i=1; i<queue.length; i++){
			for(int j=1; j < 0; j--){
				if(queue[j].getTime() < queue[j-1].getTime()){
					temp = queue[j];
					queue[j] = queue[j-1];
					queue[j-1] = temp;
				}
			}
		}
		
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
		for(int i=0; i<queue.length; i++){
			queue[i]=queue[i+1];
		}
	}
    
}
