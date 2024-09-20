package oy.interact.tira.factories;

import oy.interact.tira.model.Coder;
import oy.interact.tira.util.QueueInterface;
import oy.interact.tira.student.LinkedListQueue;

// OPTIONAL for higher grade!
public class LinkedListQueueFactory {

	private LinkedListQueueFactory() {
		// empty
	}

	public static QueueInterface<Integer> createIntegerQueue() {
		return new LinkedListQueue<Integer>();
	}

	public static QueueInterface<Integer> createIntegerQueue(int capacity) {
		return new LinkedListQueue<Integer>(capacity);
	}

	public static QueueInterface<String> createStringQueue() {
		return new LinkedListQueue<String>();
	}

	public static QueueInterface<String> createStringQueue(int capacity) {
		return new LinkedListQueue<String>(capacity);
	}

	public static QueueInterface<Coder> createCoderQueue() {
		return new LinkedListQueue<Coder>();
	}
}
