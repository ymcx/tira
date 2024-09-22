package oy.interact.tira.student;

import java.util.Comparator;

public class MergeSort<E> {
  public static <E> void sort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
    E[] copy = array;
    TopDownSplitMerge(copy, fromIndex, toIndex, array, comparator);
  }
  private static <E> void TopDownSplitMerge(E[] copy, int start, int end, E[] array, Comparator<E> comparator) {
    if (end-start <= 1) {
      return;
    }
    int middle = (end+start) / 2;
    TopDownSplitMerge(array, start, middle, copy, comparator);
    TopDownSplitMerge(array, middle, end, copy, comparator);
    TopDownMerge(copy, start, middle, end, array, comparator);
  }
  private static <E> void TopDownMerge(E[] copy, int start, int middle, int end, E[] array, Comparator<E> comparator) {
    int i = start;
    int j = middle;
    for (int k=start; k<end; ++k) {
      if (i<middle && (j>=end || comparator.compare(array[i], array[j]) <= 0)) {
        copy[k] = array[i];
        ++i;
      }
      else {
        copy[k] = array[j];
        ++j;
      }
    }
  }
}
