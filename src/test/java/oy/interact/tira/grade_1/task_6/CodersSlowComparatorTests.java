package oy.interact.tira.grade_1.task_6;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.util.Comparator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import oy.interact.tira.model.Coder;
import oy.interact.tira.student.Algorithms;

@DisplayName("Testing slow sort algorithm with Comparators")
class CodersSlowComparatorTests {

	private static final int TEST_COUNT = 5;
	private static int currentFileIndex = 0;
	private static Coder [] coderArray;
	private static boolean testIsDisabled = false;

	@BeforeAll
	static void printTest() {
		System.out.println("Testing SLOW sorting with Coders and Comparator");
		System.out.format("There will be %d tests executed%n", TEST_COUNT);
		System.out.format("%3s\t%8s\t%-8s\t%-8s%n", "Test#", "Count", "ms", "ms/element");
		File f = new File("enable-slow-tests");
		if (f.exists() && !f.isDirectory()) {
			testIsDisabled = false;
		} else {
			testIsDisabled = true;
		}
	}

	@BeforeEach
	void loadTestPhoneBook() {
		if (testIsDisabled) {
			System.out.println("Slow tests disabled, not excuting this one");
			return;
		}
		System.out.println("Slow tests enabled, excuting this one");
		try {
			if (currentFileIndex < CoderSortTestUtility.coderFiles.length) {
				coderArray = CoderSortTestUtility.loadCoders(new File(
						CoderSortTestUtility.coderFiles[currentFileIndex]));
				assertNotNull(coderArray, "Coders array cannot be null");
				assertEquals(
						CoderSortTestUtility.coderCounts[currentFileIndex], coderArray.length, "Array size of coders is not correct");
			}
		} catch (Exception e) {
			fail("Could not read coders to memory for the test");
		}
	}

	@RepeatedTest(TEST_COUNT)
	void testCoderNameAscendingComparator() {
		if (testIsDisabled) {
			return;
		}
		// System.out.format("Sorting file %s with %d coders...%n", coderFiles[currentFileIndex], coderCounts[currentFileIndex]);
		long start = System.currentTimeMillis();
		Comparator<Coder> comparator = new Comparator<Coder>() {
			@Override
			public int compare(Coder first, Coder second) {
				return first.getFullName().compareTo(second.getFullName());
			}
		};
		Algorithms.insertionSort(coderArray, comparator);
		long duration = System.currentTimeMillis() - start;
		System.out.format("%3d\t%8d\t%8d\t%8.3f%n", currentFileIndex+1, 
				CoderSortTestUtility.coderCounts[currentFileIndex], duration, (double)duration/(double) CoderSortTestUtility.coderCounts[currentFileIndex]);
		assertDoesNotThrow(() -> CoderSortTestUtility
				.isInOrder(coderArray, comparator), "Order is not correct in array");
		currentFileIndex++;			
	}

}
