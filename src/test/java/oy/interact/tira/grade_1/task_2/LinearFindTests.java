package oy.interact.tira.grade_1.task_2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import oy.interact.tira.util.SimpleContainer;
import oy.interact.tira.util.TIRAContainer;

class LinearFindTests {

	private static final int MIN_SIZE = 1_000;
	private static final int MAX_SIZE = 50_000;

	private static boolean testIsDisabled = false;

	static String searchResult;
	static int foundIndex;
	static final String[] hardCodedElements = { "Programming, one those little joys in life",
			"SimpleContainer",
			"All the code words",
			"I prefer binary search trees to SimpleContainers",
			"I prefer debugging to mindless hacking",
			"Inter cactus",
			"TIRA course, the trip everybody wants to join",
			"Juunivaersitus of Olutensin",
			"Reverse that array!",
			"Environment variables, those pesky beasts",
			"Reading a programming book on the beach",
			"Unit testing, better than beer!",
			"Sorting is fun!",
			"Hello World!",
			"Those lovely arrays!",
			"My god, it's full of stars!" };

	@BeforeAll
	static void checkIfSlowTestAreEnabled() {
		File f = new File("enable-slow-tests");
		if (f.exists() && !f.isDirectory()) {
			testIsDisabled = false;
		} else {
			testIsDisabled = true;
		}
	}

	@Test
	@DisplayName("Simple linear search test for SimpleContainer")
	// @Timeout(value = 30, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
	@Order(1)
	void testLinearSearchPredicateWithStrings() {
		SimpleContainer<String> container = new SimpleContainer<>(String.class);
		assertDoesNotThrow(() -> fillContainer(container, 1000), () -> "Adding to SimpleContainer should not throw");

		assertDoesNotThrow(() -> container.add("Something something"),
				() -> "Adding to SimpleContainer should not throw");

		assertDoesNotThrow(() -> searchResult = container.find(string -> string.contains("something")),
				"SimpleContainer.find should not throw");
		assertEquals("Something something", searchResult,
				"Did not find the string that was put in the SimpleContainer");
		assertEquals(container.size() - 1, container.findIndex(string -> string.equals("Something something")), "");

		assertNull(container.find(string -> string.equals("TIRA course, the trip nobody wants to join")),
				"The string to find is not in container and null should be returned");
		assertEquals(-1, container.findIndex(string -> string.equals("TIRA course, the trip nobody wants to join")),
				"The string to find is not in container and -1 should be returned");
	}

	@Test
	@Order(2)
	// @Timeout(value = 300, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
	@DisplayName("Time performance search test for SimpleContainer")
	void testTimePerformanceOfLinearSearch() {

		if (testIsDisabled) {
			System.out.println("Slow tests disabled, not excuting this one");
			return;
		}
		System.out.println("Slow tests enabled, excuting this one");
		System.out.println("Time performance tests of filling and searching (linear) the SimpleContainer");
		System.out.format("Array size will grow from %,d up to %,d%n", MIN_SIZE, MAX_SIZE);
		System.out.println("NB 1: Fill time (F) is in milliseconds, and search time (S) in microseconds");
		System.out.println(
				"NB 2: With 2,3 GHz Intel Core i5 16GB RAM (laptop from 2018), filling 50K array takes about 15 s.");
		System.out.println("n\tF (ms)\tS (us) \tTotal (ms)");
		for (int size = MIN_SIZE; size <= MAX_SIZE; size += 1000) {
			final int currentSize = size;
			SimpleContainer<String> container = new SimpleContainer<>(String.class);
			long start = System.currentTimeMillis();
			assertDoesNotThrow(() -> fillContainer(container, currentSize),
					() -> "Adding to SimpleContainer should not throw");
			long fillDuration = System.currentTimeMillis() - start;
			start = System.nanoTime();
			for (int index = 0; index < hardCodedElements.length; index++) {
				final int currentIndex = index;
				assertNotNull(container.find(string -> string.equals(hardCodedElements[currentIndex])),
						"The string to find must be in container");
			}
			long searchDuration = (System.nanoTime() - start) / 1000; // Is now microsecs
			System.out.format("%d\t%d\t%d\t%d%n", currentSize, fillDuration, searchDuration,
					fillDuration + (searchDuration / 1000)); // search is now in millisecs
		}
		System.out.println("\nDone!");
	}

	private void fillContainer(TIRAContainer<String> container, int size) {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		final Random random = new Random();
		int hardCodedElementIndex = 0;

		for (int i = 0; i < size; i++) {
			String generatedString = random.ints(leftLimit, rightLimit + 1)
					.filter(number -> (number <= 57 || number >= 65) && (number <= 90 || number >= 97))
					.limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
					.toString();
			container.add(generatedString);
			if (i > ((size / 3) * 2) && hardCodedElementIndex < hardCodedElements.length) {
				if (random.nextInt(42) % 5 == 0) {
					container.add(hardCodedElements[hardCodedElementIndex++]);
				}
			}
		}
		while (hardCodedElementIndex < hardCodedElements.length) {
			container.add(hardCodedElements[hardCodedElementIndex++]);
		}
	}

}
