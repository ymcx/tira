package oy.interact.tira.student;

import java.util.Comparator;

public class QuickSort<E> {
  public static <E> void sort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
    if (fromIndex>=toIndex || fromIndex<0) {
      return;
    }
    int p = partition(array, fromIndex, toIndex, comparator);
    sort(array, fromIndex, p-1, comparator);
    sort(array, p+1, toIndex, comparator);
  }
  private static <E> int partition(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
    E pivot = array[toIndex];
    int i = fromIndex;
    for (int j=fromIndex; j<toIndex; ++j) {
      if (comparator.compare(array[j], pivot) <= 0) {
        swap(array, i, j);
        ++i;
      }
    }
    swap(array, i, toIndex);
    return i;
  }
  private static <E> void swap(E[] array, int first, int second) {
    E copy = array[first];
    array[first] = array[second];
    array[second] = copy;
  }
}
