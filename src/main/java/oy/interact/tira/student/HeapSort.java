package oy.interact.tira.student;

import java.util.Comparator;

public class HeapSort<E> {
  public static <E> void sort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
    int len = toIndex - fromIndex;
    for (int i=fromIndex+len/2-1; i>=fromIndex; --i) {
      heapify(array, len, i, fromIndex, comparator);
    }
    for (int i=toIndex-1; i>fromIndex; --i) {
      swap(array, fromIndex, i);
      heapify(array, i-fromIndex, fromIndex, fromIndex, comparator);
    }
  }
  private static <E> void heapify(E[] array, int len, int i, int fromIndex, Comparator<E> comparator) {
    int largest = i;
    int left = 2 * (i - fromIndex) + 1 + fromIndex;
    int right = left+1;
    if (left<fromIndex+len && comparator.compare(array[left], array[largest])>0) {
      largest = left;
    }
    if (right<fromIndex+len && comparator.compare(array[right], array[largest])>0) {
      largest = right;
    }
    if (largest != i) {
      swap(array, i, largest);
      heapify(array, len, largest, fromIndex, comparator);
    }
  }
  private static <E> void swap(E[] array, int first, int second) {
    E copy = array[first];
    array[first] = array[second];
    array[second] = copy;
  }
}
