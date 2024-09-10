package oy.interact.tira.grade_1.task_1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import oy.interact.tira.student.Algorithms;

class InsertionSortArrayRangeTests {

   private static final int ARRAY_SIZE = 21;
   private static final int NUMBER_OF_NULLS = 5;
   private static final int ELEMENT_COUNT = ARRAY_SIZE - NUMBER_OF_NULLS;
   private static final int SORT_FROM_INDEX = 6;

   @Test
   // @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
   @DisplayName("Testing the Generic sort() with integers")
   void sortTestInteger() {
      Integer[] testArray = getArrayWithNumbers(ARRAY_SIZE, NUMBER_OF_NULLS);

      Integer[] verifyArray = new Integer[ELEMENT_COUNT];
      int index = 0;
      while (testArray[index] != null) {
         verifyArray[index] = testArray[index];
         index++;
      }
      Arrays.sort(verifyArray, SORT_FROM_INDEX, index);

      System.out.format("==> Sort test array has %d elements%n", index);
      System.out.format("==> Sorting from index %d to index: %d%n", SORT_FROM_INDEX, index);
      System.out.println("Test data: " + Arrays.toString(testArray));
      Algorithms.insertionSort(testArray, SORT_FROM_INDEX, index);
      System.out.println("Sorted   : " + Arrays.toString(testArray));
      System.out.println("Correct  : " + Arrays.toString(verifyArray));
      assertTrue(Arrays.equals(Arrays.copyOfRange(verifyArray, 6, ELEMENT_COUNT), Arrays.copyOfRange(testArray, 6, ELEMENT_COUNT)),
            () -> "Sorted array is not correct!");
      System.out.println("-- Sort test finished");
   }

   @Test
   // @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
   @DisplayName("Testing the Generic sort() with strings")
   void sortTestString() {
      String[] testArray = getArrayWithStrings(ARRAY_SIZE, NUMBER_OF_NULLS);

      String[] verifyArray = new String[ELEMENT_COUNT];
      int index = 0;
      while (testArray[index] != null) {
         verifyArray[index] = testArray[index];
         index++;
      }
      Arrays.sort(verifyArray, SORT_FROM_INDEX, index);

      System.out.format("==> Sort test array has %d elements%n", index);
      System.out.format("==> Sorting from index %d to index: %d%n", SORT_FROM_INDEX, index);
      System.out.println("test data: " + Arrays.toString(testArray));
      Algorithms.insertionSort(testArray, SORT_FROM_INDEX, index);
      System.out.println("Sorted   : " + Arrays.toString(testArray));
      System.out.println("Correct  : " + Arrays.toString(verifyArray));
      assertTrue(Arrays.equals(Arrays.copyOfRange(verifyArray, SORT_FROM_INDEX,
            ELEMENT_COUNT), Arrays.copyOfRange(testArray, SORT_FROM_INDEX, ELEMENT_COUNT)),
            () -> "Sorted array is not correct!");
      System.out.println("-- Sort test finished");
   }

   private Integer[] getArrayWithNumbers(int size, int countofElementsNullAtEnd) {
      Integer[] array = new Integer[size];
      for (int i = 0; i < size - countofElementsNullAtEnd; i++) {
         array[i] = ThreadLocalRandom.current().nextInt(10);
      }
      return array;
   }

   private String[] getArrayWithStrings(int size, int countofElementsNullAtEnd) {
      int leftLimit = 48; // numeral '0'
      int rightLimit = 122; // letter 'z'
      int targetStringLength = 3;
      final Random random = new Random();

      String[] array = new String[size];

      for (int i = 0; i < size - countofElementsNullAtEnd; i++) {
         String generatedString = random.ints(leftLimit, rightLimit + 1)
               .filter(number -> (number <= 57 || number >= 65) && (number <= 90 || number >= 97))
               .limit(targetStringLength)
               .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
               .toString().toLowerCase();
         array[i] = generatedString;
      }

      return array;
   }

}
