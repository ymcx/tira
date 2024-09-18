package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class StackImplementation<E> implements StackInterface<E> {

    private Object [] itemArray;
    private int count = -1;
    private static final int DEFAULT_STACK_SIZE = 32;

    public StackImplementation() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
    }

    public StackImplementation(int capacity) {
        itemArray = new Object[capacity];
    }

    @Override
    public int capacity() {
        return itemArray.length;
    }

    private void resize() throws OutOfMemoryError {
        Object [] newItemArray = new Object[itemArray.length * 2];
        for (int i=0; i<=count; ++i) {
            newItemArray[i] = itemArray[i];
        }
        itemArray = newItemArray;
    }

    @Override
    public void push(E element) throws OutOfMemoryError, NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        if (itemArray.length <= count+1) {
            resize();
        }
        ++count;
        itemArray[count] = element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E pop() throws IllegalStateException {
        if (count < 0) {
            throw new IllegalStateException();
        }
        Object copy = itemArray[count];
        itemArray[count] = null;
        --count;
        return (E) copy;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() throws IllegalStateException {
        if (count < 0) {
            throw new IllegalStateException();
        }
        return (E) itemArray[count];
    }

    @Override
    public int size() {
        return count + 1;
    }

    @Override
    public boolean isEmpty() {
        return (count < 0);
    }

    @Override
    public void clear() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
        count = -1;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (count > -1) {
            for (int i=0; i<count; ++i) {
                str.append(itemArray[i]);
                str.append(", ");
            }
            str.append(itemArray[count]);
        }
        str.append("]");
        return str.toString();
    }
}
