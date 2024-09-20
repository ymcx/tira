package oy.interact.tira.factories;

import oy.interact.tira.model.Coder;
import oy.interact.tira.util.QueueInterface;
import oy.interact.tira.student.ArrayQueue;

public class ArrayQueueFactory {

	private ArrayQueueFactory() {
		// empty
	}

	public static QueueInterface<Integer> createIntegerQueue() {
		return new ArrayQueue<Integer>();
	}

	public static QueueInterface<Integer> createIntegerQueue(int capacity) {
		return new ArrayQueue<Integer>(capacity);
	}

	public static QueueInterface<String> createStringQueue() {
		return new ArrayQueue<String>();
	}

	public static QueueInterface<String> createStringQueue(int capacity) {
		return new ArrayQueue<String>(capacity);
	}

	public static QueueInterface<Coder> createCoderQueue() {
		return new ArrayQueue<Coder>();
	}
}
