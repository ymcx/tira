package oy.interact.tira.grade_4.task_6;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

import oy.interact.tira.CoderSortTestUtility;
import oy.interact.tira.model.Coder;
import oy.interact.tira.student.Algorithms;
import oy.interact.tira.student.Algorithms.FastSortAlgorithm;

@DisplayName("Testing fastSort algorithm with Comparators")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CodersFastSortRangeTests {
	
	private int currentFileIndex = 0;
	private Coder[] coderArray;
	private Algorithms.FastSortAlgorithm sortAlgorithm = FastSortAlgorithm.QUICKSORT;

	@BeforeAll
	static void printTest() {
		System.out.println("Testing FAST sorting with Coders and Comparator");
		System.out.println("Testing sort correctness with 100 coders");
	}

	@BeforeEach
	void loadTestPhoneBook() {
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

	@Order(1)
	@RepeatedTest(3)
	// @Timeout(value = 30, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
	void testCoderNameRangeAscendingComparator(RepetitionInfo repetitionInfo) {
		System.out.println("--\nSorting a range of 8 Coders with ASCENDING comparator by name, printing the range ofs coders, verify order:");
		Comparator<Coder> comparator = new Comparator<Coder>() {
			@Override
			public int compare(Coder first, Coder second) {
				return first.getFullName().compareTo(second.getFullName());
			}
		};
		switch (repetitionInfo.getCurrentRepetition()) {
		default:
		case 1:
			sortAlgorithm = FastSortAlgorithm.QUICKSORT;
			break;
		case 2:
			sortAlgorithm = FastSortAlgorithm.MERGESORT;
			break;
		case 3:
			sortAlgorithm = FastSortAlgorithm.HEAPSORT;
			break;
		}
		Algorithms.fastSort(coderArray, 42, 50, comparator, sortAlgorithm);
		printCoders(42, 50);
		assertDoesNotThrow(() -> CoderSortTestUtility
				.isInOrder(coderArray, 42, 50, comparator), "Array contained nulls, or sort order was wrong");
	}

	@Order(2)
	@RepeatedTest(3)
	// @Timeout(value = 30, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
	void testCoderNameRangeDescendingComparator(RepetitionInfo repetitionInfo) {
		System.out.println("--\nSorting a range of 8 Coders with DESCENDING comparator by name, printing the range ofs coders, verify order:");
		Comparator<Coder> comparator = new Comparator<Coder>() {
			@Override
			public int compare(Coder first, Coder second) {
				return second.getFullName().compareTo(first.getFullName());
			}
		};
		switch (repetitionInfo.getCurrentRepetition()) {
			default:
			case 1:
				sortAlgorithm = FastSortAlgorithm.QUICKSORT;
				break;
			case 2:
				sortAlgorithm = FastSortAlgorithm.MERGESORT;
				break;
			case 3:
				sortAlgorithm = FastSortAlgorithm.HEAPSORT;
				break;
		}
		Algorithms.fastSort(coderArray, 42, 50, comparator, sortAlgorithm);
		printCoders(42, 50);
		assertDoesNotThrow(() -> CoderSortTestUtility
				.isInOrder(coderArray, 42, 50, comparator), "Array contained nulls, or sort order was wrong");
	}

	private void printCoders(int from, int to) {
		System.out.format("%3s %3s  %s%n", "ind", "Langs", "Coder name -- programming language skills");
		for (int index = from; index < to; index++) {
			System.out.format("%3d. %3d  %s -- %s %n", index, coderArray[index].getLanguages().size(), coderArray[index], coderArray[index].getLanguagesString());
			if (index == 10) {
				break;
			}
		}
		System.out.println("...");
	}

}
