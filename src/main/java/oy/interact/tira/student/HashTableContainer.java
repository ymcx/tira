package oy.interact.tira.student;

import oy.interact.tira.util.TIRAKeyedContainer;
import oy.interact.tira.util.Pair;
import java.util.function.Predicate;

public class HashTableContainer<K extends Comparable<K>,V> implements TIRAKeyedContainer<K,V> {
  private int size = 0;
  private int collisions = 0;
  private Pair<K, V>[] list;
  private int DEFAULT_SIZE = 100;

  @SuppressWarnings("unchecked")
  public HashTableContainer() {
    list = new Pair[DEFAULT_SIZE];
  }
  
  @SuppressWarnings("unchecked")
  private void resize() {
    collisions = 0;
    int newSize = list.length*2;
    Pair<K, V>[] newList = new Pair[newSize];
    for (int i=0; i<list.length; ++i) {
      if (list[i] != null && !list[i].isRemoved()) {
        int hash = getHash(list[i].getKey(), newSize); 
        while (newList[hash] != null) {
          hash = (hash + 1) % newSize;
        }
        newList[hash] = list[i];
      }
    }
    list = newList;
  }
  
  @Override
  public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
    if (key == null || value == null) {
      throw new IllegalArgumentException();
    }
    if (list.length * 0.75 <= size) {
      resize();
    }
    int hash = getHash(key);
    if (list[hash] != null && !list[hash].isRemoved()) {
      ++collisions;
    }
    while (list[hash] != null && !list[hash].isRemoved()) {
      if (list[hash].getKey().equals(key)) {
        --size;
        break;
      }
      hash = (hash + 1) % list.length;
    }
    ++size;
    list[hash] = new Pair<K, V>(key, value);
  }
  
  @Override
  public V get(K key) throws IllegalArgumentException {
    if (key == null) {
      throw new IllegalArgumentException();
    }
    int hash = getHash(key);
    while (list[hash] != null) {
      if (!list[hash].isRemoved() && list[hash].getKey().equals(key)) {
        return list[hash].getValue();
      }
      hash = (hash + 1) % list.length;
    }
    return null;
  }
  
  @Override
  public V remove(K key) throws IllegalArgumentException {
    if (key == null) {
      throw new IllegalArgumentException();
    }
    int hash = getHash(key);
    while (list[hash] != null) {
      if (!list[hash].isRemoved() && list[hash].getKey().equals(key)) {
        --size;
        list[hash].setRemoved();
        return list[hash].getValue();
      }
      hash = (hash + 1) % list.length;
    }
    return null;
  }
  
  @Override
  public V find(Predicate<V> searcher) {
    for (int i=0; i<list.length; ++i) {
      if (list[i] == null || list[i].isRemoved()) {
        continue;
      }
      V value = list[i].getValue();
      if (searcher.test(value)) {
        return value;
      }
    }
    return null;
  }
  
  @Override
  public int size() {
    return size;
  }
  
  @Override
  public int capacity() {
    return list.length;
  }
  
  @Override
  public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
    if (capacity < list.length) {
      throw new IllegalArgumentException();
    }   
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public void clear() {
    list = new Pair[DEFAULT_SIZE];
    size = 0;
    collisions = 0;
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public Pair<K,V>[] toArray() throws Exception {
    System.out.println("Amount of collisions: ["+collisions+"]");
    Pair<K, V>[] newList = new Pair[size];
    int j=-1;
    for (int i=0; i<list.length; ++i) {
      if (list[i] == null || list[i].isRemoved()) {
        continue;
      }
      newList[++j] = list[i];
    }
    return newList;
  }

  private int getHash(K key) {
    return getHash(key, list.length);
  }

  private int getHash(K key, int max) {
    return Math.abs(key.hashCode()) % max;
  }
}
