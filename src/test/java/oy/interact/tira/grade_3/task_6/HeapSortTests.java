package oy.interact.tira.grade_3.task_6;

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
import org.junit.jupiter.api.Timeout;

import oy.interact.tira.CoderSortTestUtility;
import oy.interact.tira.model.Coder;
import oy.interact.tira.student.Algorithms;
import oy.interact.tira.student.Algorithms.FastSortAlgorithm;

@DisplayName("Testing heapsort algorithm with Comparators")
class HeapSortTests {

	private static final int TEST_COUNT = 7;
	private static int currentFileIndex = 0;
	private Coder[] coderArray;

	@BeforeAll
	static void printTest() {
		System.out.println("Testing FAST sorting with Coders and Comparator");
		System.out.format("There will be %d tests executed%n", TEST_COUNT);
		System.out.format("%3s\t%8s\t%-8s\t%-8s%n", "Test#", "Count", "ms", "ms/element");
	}

	@BeforeEach
	void loadTestPhoneBook() {
		try {
			if (currentFileIndex < CoderSortTestUtility.coderFiles.length) {
				coderArray = CoderSortTestUtility.loadCoders(
					new File(
						CoderSortTestUtility.coderFiles[currentFileIndex]
					)
				);
				assertNotNull(coderArray, "Coders array cannot be null");
				assertEquals(
						CoderSortTestUtility.coderCounts[currentFileIndex], coderArray.length, "Array size of coders is not correct");
			}
		} catch (Exception e) {
			fail("Could not read coders to memory for the test");
		}
	}

	@RepeatedTest(TEST_COUNT)
	// @Timeout(value = 600, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
	void testCoderNameAscendingComparator() {
		long start = System.currentTimeMillis();
		Comparator<Coder> comparator = new Comparator<Coder>() {
			@Override
			public int compare(Coder first, Coder second) {
				return first.getFullName().compareTo(second.getFullName());
			}
		};
		Algorithms.fastSort(coderArray, 0, coderArray.length, comparator, FastSortAlgorithm.HEAPSORT);
		long duration = System.currentTimeMillis() - start;
		System.out.format("%3d\t%8d\t%8d\t%8.3f%n", currentFileIndex+1, 
				CoderSortTestUtility.coderCounts[currentFileIndex], 
				duration, 
				(double)duration/(double)CoderSortTestUtility.coderCounts[currentFileIndex]);
		assertDoesNotThrow(() -> CoderSortTestUtility
				.isInOrder(coderArray, comparator), "Order is not correct in array");
		currentFileIndex++;			
	}

}
