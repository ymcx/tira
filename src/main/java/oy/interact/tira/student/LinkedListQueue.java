package oy.interact.tira.student;

import oy.interact.tira.util.QueueInterface;

public class LinkedListQueue<E> implements QueueInterface<E> {
    private class Node<T> {
        T data = null;
        Node<T> next = null;
        //Node<T> previous = null;
        public Node(T data) {
           this.data = data;
        }
     }  
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public LinkedListQueue() {
    }
    public LinkedListQueue(int capacity) {
    }
    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }
    @Override
    public void enqueue(E element) throws OutOfMemoryError, NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        Node<E> newTail = new Node<E>(element);
        if (head != null) {
            //newTail.previous = tail;
            tail.next = newTail;
        }
        else {
            head = newTail;
        }
        tail = newTail;
        ++size;
    }
    @Override
    public E dequeue() throws IllegalStateException {
        if (head == null) {
            throw new IllegalStateException();
        }
        E copy = head.data;
        head = head.next;
        //head.previous = null;
        --size;
        return copy;
    }
    @Override
    public E element() throws IllegalStateException {
        if (head == null) {
            throw new IllegalStateException();
        }
        return head.data;
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
        tail = null;
        head = null;
        size = 0;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        if (head != null) {
            Node<E> cur = head;
            s.append(cur.data);
            cur = cur.next;
            while (cur != null) {
                s.append(", ");
                s.append(cur.data);
                cur = cur.next;
            }
        }
        s.append("]");
        return s.toString();
    }
}
