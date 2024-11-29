package oy.interact.tira.grade_1.task_7;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import oy.interact.tira.factories.BSTFactory;
import oy.interact.tira.model.Coder;
import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedOrderedContainer;


@DisplayName("Testing that the implementations are really generic.")
class GenericTests {

    // Implementations to test:
    static TIRAKeyedOrderedContainer<String, Integer> bst = null;
    static final int MIN_TEST_COUNT = 100;
    static final int TEST_COUNT = 999;
    static Pair<String, Integer> [] testArray;
    static int testIndex = 0;
    static Integer testValue;
    static Coder testCoder;
    static boolean testResult;
    static Comparator<String> comparator = new Comparator<>() {
        @Override
        public int compare(String first, String second) {
            return first.compareTo(second);
        }
    };

    @BeforeAll
    static void allocateDataStructure() {
        try {
            bst = BSTFactory.createBST(comparator);
            if (null == bst) {
                fail("BSTFactory.createBST did not instantiate the TIRAKeyedOrderedContainer implementation (yet)");
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("BSTFactory.createBST could not instantiate the TIRAKeyedOrderedContainer implementation");
        }
    }

    @Test
    // @Timeout(value = 30, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    @DisplayName("Tests BST calling add, size, get and toArray")
    void testBST() {
        try {
            if (bst == null) {
                System.out.println("======================================================");
                System.out.println("Not testing BST yet since it has not been implemented.");
                System.out.println("======================================================");
                fail("BSTFactory.createBST could not instantiate the TIRAKeyedOrderedContainer implementation (yet?)");
                return;
            }
            bst.clear();
            List<String> randomList = new ArrayList<>();
            final int CURRENT_TEST_COUNT = ThreadLocalRandom.current().nextInt(TEST_COUNT) + MIN_TEST_COUNT;
            for (int index = 0; index < CURRENT_TEST_COUNT; index++) {
                randomList.add(String.valueOf(index));
            }
            Collections.shuffle(randomList);
            for (int index = 0; index < CURRENT_TEST_COUNT; index++) {
                final int findValue = index;
                assertDoesNotThrow(() -> bst.add(randomList.get(findValue), Integer.parseInt(randomList.get(findValue))), "BST add must not throw");
            }
            System.out.println(">> Testing BST with " + bst.size() + " entries");
            assertEquals(CURRENT_TEST_COUNT, bst.size(), () -> "Inserted count must match");
            for (int index = 0; index < CURRENT_TEST_COUNT; index++) {
                final int findValue = index;
                assertDoesNotThrow( () -> testValue = bst.get(String.valueOf(findValue)), "BST find must not throw");
                assertEquals(index, testValue, () -> "Inserted and retrieved values must match");
            }
            assertNull(bst.get(String.valueOf(CURRENT_TEST_COUNT + 42)), () -> "Must return null when element not in tree");
            assertDoesNotThrow( () -> testArray = bst.toArray(), "BST toSortedArray must not throw");
            assertNotNull(testArray, () -> "Returned array from toSortedArray must not be null");
            assertTrue(isSorted(testArray), () -> "KeyValueBSearchTree.toSortedArray() does not sort correctly");
            assertEquals(randomList.size(), testArray.length, () -> "Test array and toSortedArray lengths do not match");
            Object [] originalArray = randomList.toArray();
            Arrays.sort(originalArray);
            for (int index = 0; index < CURRENT_TEST_COUNT; index++) {
                final int findIndex = index;
                assertNotNull(testArray[index], "Array from toSortedArray must not contain null elements");
                assertEquals(originalArray[index], testArray[index].getKey(), () -> "Array elements do not match");
                int randomListIndex = Arrays.binarySearch(originalArray, 0, originalArray.length, String.valueOf(index));
                assertDoesNotThrow(() -> testIndex = bst.findIndex(value -> value.equals(findIndex)), "Finding an index from BST must not throw");
                assertEquals(randomListIndex, testIndex, "Found testIndex for the value is not correct");
                assertDoesNotThrow( () -> testValue = bst.getIndex(findIndex).getValue(), "BST get(int) must not throw");
                assertEquals(Integer.valueOf((String)originalArray[findIndex]), testValue, "When in correct order, same object in same indices");
                assertDoesNotThrow(() -> testIndex = bst.indexOf(originalArray[findIndex].toString()), "bst.indexOf must not throw");
                assertEquals(findIndex, testIndex, "Index of item in bst must match the index of item in test data");
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("Something went wrong in the test." + e.getMessage());
        }
    }

    @Test
    // @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    @DisplayName("Test that get(int index) works also in cases where the bst forms a linked list")
    void testBSTAsLinkedList() {
        // BST will be a linked list where 10 is at root, numbers going down in left side edge of the tree.
        // Strings have preceding zeroes to make sort order correct.
        String [] testArray2 = {"10", "09", "08", "07", "06", "05", "04", "03", "02", "01"};
        // Indices should be     9     8     7     6     5     4     3     2     1     0
        try {
            if (bst == null) {
                System.out.println("======================================================");
                System.out.println("Not testing BST yet since it has not been implemented.");
                System.out.println("======================================================");
                fail("BSTFactory.createBST could not instantiate the TIRAKeyedOrderedContainer implementation (yet?)");
                return;
            }
            System.out.println("-- Testing bst forming a linked list to left side");
            bst.clear();
            for (String item : testArray2) {
                bst.add(item, Integer.parseInt(item));
            }
            // Reverse the array and get elements by index from both array and bst -- should get same results from both.
            List<String> tempList = Arrays.asList(testArray2);
            Collections.reverse(tempList);
            tempList.toArray(testArray2);
            for (int index = 0; index < testArray2.length; index++) {
                final int currentIndex = index;
                assertDoesNotThrow(() -> testValue = bst.getIndex(currentIndex).getValue(), "Getting item by index from bst must not throw");
                final int arrayValue = Integer.parseInt(testArray2[currentIndex]);
                System.out.format("index: %2d, array value: %3d tree value: %3d%n", index, arrayValue, testValue);
                assertEquals(arrayValue, testValue, "The value from testArray and bst do not match but they should");
            }
            // Test so that bst is linked list to right side.
            System.out.println("-- Testing bst forming a linked list to right side");
            bst.clear();
            String [] testArray3 = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10"};
            for (String item : testArray3) {
                bst.add(item, Integer.parseInt(item));
            }
            // Get elements by index from both array and bst -- should get same results from both.
            for (int index = 0; index < testArray3.length; index++) {
                final int currentIndex = index;
                assertDoesNotThrow(() -> testValue = bst.getIndex(currentIndex).getValue(), "Getting item by index from bst must not throw");
                final int arrayValue = Integer.parseInt(testArray3[currentIndex]);
                System.out.format("index: %2d, array value: %3d tree value: %3d%n", index, arrayValue, testValue);
                assertEquals(arrayValue, testValue, "The value from testArray and bst do not match but they should");
            }
            System.out.println("** Tests succeeded!");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Something went wrong in the test." + e.getMessage());
        }
    }

    @Test
    // @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    @DisplayName("Test that tries to add identical values (not keys)")
    void testAddingIdenticalValues() {
        Comparator<String> ascComparator = new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return first.compareTo(second);
            }
        };
        TIRAKeyedOrderedContainer<String, Coder> coderBST = BSTFactory.createBST(ascComparator);
        if (coderBST == null) {
            System.out.println("======================================================");
            System.out.println("Not testing BST yet since it has not been implemented.");
            System.out.println("======================================================");
            fail("BSTFactory.createBST could not instantiate the TIRAKeyedOrderedContainer implementation (yet)");
            return;
        }
        coderBST.clear();
        Coder antti = new Coder("Antti", "Juustila", "secret");
        Coder identicalAntti = new Coder(antti.getId());
        identicalAntti.setFirstName("Antti");
        identicalAntti.setLastName("Juustila");
        identicalAntti.setPhoneNumber("555-1234 567");
        assertDoesNotThrow(() -> coderBST.add(antti.getFullName(), antti), "Adding to BST must not throw");
        assertDoesNotThrow(() -> coderBST.add(identicalAntti.getFullName(), identicalAntti), "Adding to BST must not throw");
        assertEquals(1, coderBST.size(), "After trying to add two identical values (that are equal()), BST size must be one (1)");
        assertDoesNotThrow(() -> testCoder = coderBST.find(coder -> coder.equals(identicalAntti)));
        assertNotNull(testCoder, "Value must be in the dictionary in this test");
        assertEquals(identicalAntti, testCoder, "Added value should be in BST when adding the same value twice with different keys");
        assertEquals("555-1234 567", testCoder.getPhoneNumber(), "The last addded identical value must be in the BST.");
    }

    private <T extends Comparable<T>> boolean isSorted(Pair<String, Integer> [] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i].getKey().compareTo(array[i + 1].getKey()) >= 0)
                return false;
        }
        return true;
    }
}
