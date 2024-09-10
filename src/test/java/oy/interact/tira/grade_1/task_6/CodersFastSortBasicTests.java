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
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

import oy.interact.tira.model.Coder;
import oy.interact.tira.student.Algorithms;

@DisplayName("Testing fastSort algorithm with Comparators")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CodersFastSortBasicTests {
	
	private int currentFileIndex = 0;
	private Coder[] coderArray;

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

	@Test
	@Order(1)
	// @Timeout(value = 30, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
	void testDefaultSortOrder() {
		System.out.println("--\nSorting by DEFAULT sort order, printing first 10 coders, verify order:");
		Algorithms.fastSort(coderArray);
		printCoders(0, coderArray.length);
		assertDoesNotThrow(() -> CoderSortTestUtility
				.isInOrder(coderArray), "Array contained nulls, or sort order was wrong");
	}

	@Test
	@Order(2)
	// @Timeout(value = 30, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
	void testCoderNameAscendingComparator() {
		System.out.println("--\nSorting with ASCENDING comparator by name, printing first 10 coders, verify order:");
		Comparator<Coder> comparator = new Comparator<Coder>() {
			@Override
			public int compare(Coder first, Coder second) {
				return first.getFullName().compareTo(second.getFullName());
			}
		};
		Algorithms.fastSort(coderArray, comparator);
		printCoders(0, coderArray.length);
		assertDoesNotThrow(() -> CoderSortTestUtility
				.isInOrder(coderArray, comparator), "Array contained nulls, or sort order was wrong");
	}

	@Test
	@Order(3)
	// @Timeout(value = 30, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
	void testCoderNameDescendingComparator() {
		System.out.println("--\nSorting DESCENDING comparator by name, printing first 10 coders, verify order:");
		Comparator<Coder> comparator = new Comparator<Coder>() {
			@Override
			public int compare(Coder first, Coder second) {
				return second.getFullName().compareTo(first.getFullName());
			}
		};
		Algorithms.fastSort(coderArray, comparator);
		printCoders(0, coderArray.length);
		assertDoesNotThrow(() -> CoderSortTestUtility
				.isInOrder(coderArray, comparator), "Array contained nulls, or sort order was wrong");
	}

	@Test
	@Order(4)
	// @Timeout(value = 30, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
	void testLeastKnownLanguagesComparator() {
		System.out.println("--\nPrinting first 10 coders who know the least number of languages verify order:");
		Comparator<Coder> comparator = new Comparator<Coder>() {
			@Override
			public int compare(Coder first, Coder second) {
				return first.getLanguages().size() - second.getLanguages().size();				
			}
		};
		Algorithms.fastSort(coderArray, comparator);
		printCoders(0, coderArray.length);
		assertDoesNotThrow(() -> CoderSortTestUtility
				.isInOrder(coderArray, comparator), "Array contained nulls, or sort order was wrong");
	}

	@Test
	@Order(5)
	// @Timeout(value = 30, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
	void testMostKnownLanguagesComparator() {
		System.out.println("--\nPrinting first 10 coders who know the most number of languages, verify order:");
		Comparator<Coder> comparator = new Comparator<Coder>() {
			@Override
			public int compare(Coder first, Coder second) {
				return second.getLanguages().size() - first.getLanguages().size();				
			}
		};
		Algorithms.fastSort(coderArray, comparator);
		printCoders(0, coderArray.length);
		assertDoesNotThrow(() -> CoderSortTestUtility
				.isInOrder(coderArray, comparator), "Array contained nulls, or sort order was wrong");
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
