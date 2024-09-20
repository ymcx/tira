package oy.interact.tira.student;

import oy.interact.tira.util.QueueInterface;

public class ArrayQueue<E> implements QueueInterface<E> {
    private Object [] list;
    private static int DEFAULT_CAPACITY = 32;
    private int tail = 0;
    private int head = 0;
    private int size = 0;
    public ArrayQueue() {
        list = new Object[DEFAULT_CAPACITY];
    }
    public ArrayQueue(int capacity) {
        list = new Object[capacity];
    }
    @Override
    public int capacity() {
        return list.length;
    }
    private void resize() {
        Object [] newList = new Object[capacity()*2];
        for (int i=0; i<size; ++i) {
            newList[i] = list[(i+head)%capacity()];
        }
        head = 0;
        tail = size;
        list = newList;
    }
    @Override
    public void enqueue(E element) throws OutOfMemoryError, NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        if (tail == capacity()) {
            tail = 0;
        }
        if (list[tail] != null) {
            resize();
        }
        list[tail] = element;
        ++tail;
        ++size;
    }
    @SuppressWarnings("unchecked")
    @Override
    public E dequeue() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException();
        }
        Object copy = list[head];
        list[head] = null;
        head = (head+1)%capacity();
        --size;
        if (size == 0) {
            head = 0;
            tail = 0;
        }
        return (E) copy;
    }
    @SuppressWarnings("unchecked")
    @Override
    public E element() throws IllegalStateException {
        if (list[head] == null) {
            throw new IllegalStateException();
        }
        return (E) list[head];
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
    @Override
    public void clear() {
        list = new Object[DEFAULT_CAPACITY];
        tail = 0;
        head = 0;
        size = 0;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        if (size >= 1) {
            for (int i=0; i<size-1; ++i) {
                s.append(list[(i+head)%capacity()]);
                s.append(", ");
            }
            s.append(list[tail-1]);
        }
        s.append("]");
        return s.toString();
    }
}
