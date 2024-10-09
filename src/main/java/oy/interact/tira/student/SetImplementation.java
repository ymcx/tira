package oy.interact.tira.student;

import java.util.Iterator;
import java.util.function.Predicate;
import oy.interact.tira.util.SetInterface;

class ListIterator<T> implements Iterator<T> {
  private SetImplementation<T> s;
  private int cur = 0;
  public ListIterator(SetImplementation<T> s) {
    this.s = s;
  }
  
	@Override
	public boolean hasNext() {
    for (int i=cur; i<s.list.length; ++i) {
      if (s.list[i] != null) {
        return true;
      }
    }
    return false;
	}

	@Override
	public T next() {
    for (int i=cur; i<s.list.length; ++i) {
      if (s.list[i] != null) {
        cur = i+1;
        return s.list[i];
      }
    }
    return null;
	}
}

public class SetImplementation<E> implements SetInterface<E> {
  int size = 0;
  int collisions = 0;
  E[] list;
  int DEFAULT_SIZE = 100;

  @SuppressWarnings("unchecked")
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof SetImplementation)) {
      return false;
    }
  	SetImplementation<E> set = (SetImplementation<E>) obj;
  	return (set.count() == count() && isSubsetOf(set) && isSupersetOf(set));
  }

  @SuppressWarnings("unchecked")
  public SetImplementation() {
    list = (E[]) new Object[DEFAULT_SIZE];
  }
  
  @SuppressWarnings("unchecked")
  public SetImplementation(int capacity) {
    list = (E[]) new Object[capacity];
  }

	@Override
	public Iterator<E> iterator() {
	  return new ListIterator<E>(this);
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    collisions = 0;
    int newSize = list.length*2;
  	E[] newList = (E[]) new Object[newSize];
    for (int i=0; i<list.length; ++i) {
      if (list[i] != null) {
        int hash = getHash(list[i], newSize); 
        while (newList[hash] != null) {
          hash = (hash + 1) % newSize;
        }
        newList[hash] = list[i];
      }
    }
    list = newList;
  }

	@Override
	public boolean insert(E element) throws NullPointerException, OutOfMemoryError {
    if (element == null) {
      throw new NullPointerException();
    }
    if (list.length * 0.75 <= size) {
      resize();
    }
    int hash = getHash(element);
    if (list[hash] != null) {
      ++collisions;
    }
    while (list[hash] != null) {
      if (list[hash].equals(element)) {
        return false;
      }
      hash = (hash + 1) % list.length;
    }
    ++size;
    list[hash] = element;
    return true;
	}

	@Override
	public E remove(E element) throws NullPointerException {
    if (element == null) {
      throw new NullPointerException();
    }
    int hash = getHash(element);
    int next = 0;
    E copy = null;
    E copy2 = null;
    while (list[hash] != null) {
      if (!list[hash].equals(element)) {
        hash = (hash + 1) % list.length;
        continue;
      }
      --size;
      copy = list[hash];
      list[hash] = null;
      next = (hash + 1) % list.length;
      while (list[next] != null) {
        if (!list[next].equals( list[getHash(list[next])] )) {
          --size;
          copy2 = list[next];
          list[next] = null;
          insert(copy2);
        }
        next = (next + 1) % list.length;
      }
    }
    return copy;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
    list = (E[]) new Object[DEFAULT_SIZE];
    size = 0;
    collisions = 0;
	}

	@Override
	public boolean contains(E element) throws NullPointerException {
	  return (get(element) != null);
	}

	@Override
	public E contains(Predicate<E> predicate) {
	  for (int i=0; i<list.length; ++i) {
      if (list[i] != null && predicate.test(list[i])) {
        return list[i];
      }
	  }
	  return null;
	}

	@Override
	public E get(E element) throws NullPointerException {
    int hash = getHash(element);
	  while (list[hash] != null) {
      if (list[hash].equals(element)) {
        return list[hash];
      }
      hash = (hash + 1) % list.length;
	  }
	  return null;
	}

	@Override
	public boolean isEmpty() {
	  return (size == 0);
	}

	@Override
	public int count() {
	  return size;
	}

	@Override
	public int capacity() {
	  return list.length;
	}

	@Override
	public void toArray(E[] array) {
    System.out.println("Amount of collisions: ["+collisions+"]");
    for (int i=0, j=-1; i<list.length; ++i) {
      if (list[i] != null) {
        array[++j] = list[i];
      }
    }
	}

	private SetInterface<E> modify(SetInterface<E> first, SetInterface<E> second, boolean substracting, boolean union) throws OutOfMemoryError {
	  int newSize = (first.count() + second.count()) * 2;
  	SetImplementation<E> newList = new SetImplementation<>(newSize);
  	Iterator<E> i;
  	E next;
    for (i=first.iterator(), next=i.next(); next!=null; next=i.next()) {
      if (union || substracting ^ second.contains(next)) {
        newList.insert(next);
      }
    }
    for (i=second.iterator(), next=i.next(); union && next!=null; next=i.next()) {
      newList.insert(next);
    }
  	return newList;
	}

	private SetInterface<E> modify(SetInterface<E> first, Predicate<E> filter) {
	  int newSize = first.count() * 2;
  	SetImplementation<E> newList = new SetImplementation<>(newSize);
  	Iterator<E> i;
  	E next;
    for (i=first.iterator(), next=i.next(); next!=null; next=i.next()) {
      if (filter.test(next)) {
        newList.insert(next);
      }
    }
  	return newList;
	}

	private boolean check(SetInterface<E> first, SetInterface<E> second, boolean substracting) {
  	Iterator<E> i;
  	E next;
    for (i=first.iterator(), next=i.next(); next!=null; next=i.next()) {
      if (substracting ^ second.contains(next)) {
        return false;
      }
    }
    return true;
	}

	@Override
	public SetInterface<E> intersection(SetInterface<E> anotherSet) throws OutOfMemoryError {
	  return modify(this, anotherSet, false, false);
	}

	@Override
	public SetInterface<E> subtracting(SetInterface<E> anotherSet) throws OutOfMemoryError {
	  return modify(this, anotherSet, true, false);
	}

	@Override
	public SetInterface<E> union(SetInterface<E> anotherSet) throws OutOfMemoryError {
	  return modify(this, anotherSet, false, true);
	}

	@Override
	public SetInterface<E> symmetricDifference(SetInterface<E> anotherSet) throws OutOfMemoryError {
	  return modify(
	    modify(this, anotherSet, true, false),
	    modify(anotherSet, this, true, false),
	    false,
	    true
	  );
	}

	@Override
	public boolean isSubsetOf(SetInterface<E> anotherSet) {
	  return check(this, anotherSet, true);
	}

	@Override
	public boolean isSupersetOf(SetInterface<E> anotherSet) {
	  return check(anotherSet, this, true);
	}

	@Override
	public boolean isDisjoint(SetInterface<E> anotherSet) {
	  return check(this, anotherSet, false);
	}

	@Override
	public SetInterface<E> filter(Predicate<E> filter) throws OutOfMemoryError {
	  return modify(this, filter);
	}
	
  private int getHash(E element) {
    return getHash(element, list.length);
  }

  private int getHash(E element, int max) {
    return Math.abs(element.hashCode()) % max;
  }
}
