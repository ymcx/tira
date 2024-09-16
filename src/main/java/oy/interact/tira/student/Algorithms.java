package oy.interact.tira.student;

import java.util.Comparator;

public class Algorithms {

   private Algorithms() {
      // nada
   }

   ///////////////////////
   // Oma swap lol
   ///////////////////////

   public static <T> void swap(T[] array, int first, int second) {
      T copyOfFirst = array[first];
      array[first] = array[second];
      array[second] = copyOfFirst;
   }
   
   ///////////////////////////////////////////
   // Insertion Sort for the whole array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array) {
      insertionSort(array, 0, array.length);
   }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      for (int i=fromIndex; i<toIndex; ++i) {
         for (int j=i; (j>fromIndex) && (array[j-1].compareTo(array[j])>0); --j) {
            swap(array, j, j-1);
         }
      }
   }

   //////////////////////////////////////////////////////////
   // Insertion Sort for the whole array using a Comparator
   //////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, Comparator<T> comparator) {      
      insertionSort(array, 0, array.length, comparator);
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      for (int i=fromIndex; i<toIndex; ++i) {
         for (int j=i; (j>fromIndex) && (comparator.compare(array[j-1], array[j])>0); --j) {
            swap(array, j, j-1);
         }
      }
   }

   ///////////////////////////////////////////
   // Reversing an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array) {
      reverse(array, 0, array.length);
   }

   ///////////////////////////////////////////
   // Reversing a slice of an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
      int i = fromIndex;
      int j = toIndex-1;
      while (i != j && i != j+1) {
         swap(array, i, j);
         ++i;
         --j;
      }
   }


   ///////////////////////////////////////////
   // Recursive binary search bw indices
   ///////////////////////////////////////////

   public enum BSearchImplementation {
      RECURSIVE,
      ITERATIVE
   }

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex - 1);
   }

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, BSearchImplementation impl) {
      switch (impl) {
         case RECURSIVE:
            return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex - 1);
         case ITERATIVE:
            return binarySearchIterative(aValue, fromArray, fromIndex, toIndex - 1);
         default:
            return -1;
      }
   }

   public static <T extends Comparable<T>> int binarySearchRecursive(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      if (fromIndex > toIndex) {
         return -1;
      }
      int checking = (toIndex-fromIndex)/2+fromIndex;
      int compared = aValue.compareTo(fromArray[checking]);
      if (compared==0) {
         return checking;
      }
      else if (compared>0) {
         return binarySearchRecursive(aValue, fromArray, checking + 1, toIndex);
      }
      else {
         return binarySearchRecursive(aValue, fromArray, fromIndex, checking - 1);
      }
   }

   public static <T extends Comparable<T>> int binarySearchIterative(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      while (fromIndex <= toIndex) {
         int checking = (toIndex-fromIndex)/2+fromIndex;
         int compared = aValue.compareTo(fromArray[checking]);
         if (compared==0) {
            return checking;
         }
         else if (compared>0) {
            fromIndex = checking + 1;
         }
         else {
            toIndex = checking - 1;
         }   
      }
      return -1;
   }

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex - 1, comparator);
   }

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator, BSearchImplementation impl) {
      switch (impl) {
         case RECURSIVE:
            return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex - 1, comparator);
         case ITERATIVE:
            return binarySearchIterative(aValue, fromArray, fromIndex, toIndex - 1, comparator);
         default:
            return -1;
      }
   }

   public static <T> int binarySearchRecursive(T aValue, T[] fromArray, int fromIndex,
         int toIndex, Comparator<T> comparator) {
      if (fromIndex > toIndex) {
         return -1;
      }
      int checking = (toIndex-fromIndex)/2+fromIndex;
      int compared = comparator.compare(aValue, fromArray[checking]);
      if (compared==0) {
         return checking;
      }
      else if (compared>0) {
         return binarySearchRecursive(aValue, fromArray, checking + 1, toIndex, comparator);
      }
      else {
         return binarySearchRecursive(aValue, fromArray, fromIndex, checking - 1, comparator);
      }
   }

   public static <T> int binarySearchIterative(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      while (fromIndex <= toIndex) {
         int checking = (toIndex-fromIndex)/2+fromIndex;
         int compared = comparator.compare(aValue, fromArray[checking]);
         if (compared==0) {
            return checking;
         }
         else if (compared>0) {
            fromIndex = checking + 1;
         }
         else {
            toIndex = checking - 1;
         }   
      }
      return -1;
   }

   public enum FastSortAlgorithm {
      QUICKSORT,
      HEAPSORT,
      MERGESORT
   }

   public static <E> void fastSort(E[] array, Comparator<E> comparator) {
      fastSort(array, 0, array.length, comparator, FastSortAlgorithm.QUICKSORT);
   }

   public static <E extends Comparable<E>> void fastSort(E[] array) {
      fastSort(array, 0, array.length, Comparator.naturalOrder(), FastSortAlgorithm.QUICKSORT);
   }

   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      fastSort(array, fromIndex, toIndex, comparator, FastSortAlgorithm.QUICKSORT);
   }

   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator, FastSortAlgorithm algorithm) {
      switch (algorithm) {
         case QUICKSORT:
            // TODO: Call your quicksort algorithm here.
            break;
         case HEAPSORT:
            // TODO: IF implementing heapsort, call your algorithm here.
            break;
         case MERGESORT:
            // TODO: IF implementing mergesort, call your algorithm here.
            break;
         default:
            break;
      }
   }

} // End of class Algorithms
