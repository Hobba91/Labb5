package Labb5.simulator;

import java.util.NoSuchElementException;

public class EventQueue {
    private Object queue[] = new Object[1000];



    public boolean isEmpty() {
		if (queue.length <= 0) {
			return true;
		} else {
			return false;
		}
	}

    public Object first() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return queue[0];
		}
	}
    
}
