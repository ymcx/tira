package oy.interact.tira.grade_5.task_8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

import oy.interact.tira.factories.SetFactory;

import oy.interact.tira.model.Coder;
import oy.interact.tira.util.JSONConverter;
import oy.interact.tira.util.SetInterface;

class SetWithCoderTests {

	private static final String TEST_FILE = "10000-large-city-coders.json";
	private static Coder[] testData;

	@Test
	void testInsertAndGet() {

		try {
			SetInterface<Coder> testSet = createTestSet();
			assertEquals(testData.length, testSet.count());

			for (int index = 0; index < testData.length; index++) {
				Coder found = testSet.get(testData[index]);
				assertNotNull(found);
				assertEquals(testData[index], found);
			}
			System.out.println("Insert and get test passed");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			fail("Could not read test file to memory " + TEST_FILE);
		}
	}

	@Test
	void testInsertAndRemove() {

		try {
			SetInterface<Coder> testSet = createTestSet();

			assertEquals(testData.length, testSet.count());

			for (int index = 0; index < testData.length; index++) {
				Coder found = testSet.remove(testData[index]);
				assertNotNull(found);
				assertEquals(testData[index], found);
			}
			assertTrue(testSet.isEmpty());
			System.out.println("Insert and remove test passed");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			fail("Could not read test file to memory " + TEST_FILE);
		}
	}

	// Test class to cause deliberate collisions in adding to hashtable.
	class ValueRange implements Comparable<ValueRange> {
		private int value;

		ValueRange(int value) {
			this.value = value;
		}

		@Override
		public boolean equals(Object another) {
			if (another instanceof ValueRange) {
				return ((ValueRange) another).value == this.value;
			}
			return false;
		}

		@Override
		public int hashCode() {
			// Deliberately causing collisions by this lousy hash func.
			return value % 2;
		}

		@Override
		public int compareTo(ValueRange o) {
			return this.value - o.value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	private Coder[] readCodersFromFile(String fileName) throws IOException {
		long start = System.currentTimeMillis();
		JSONTokener tokener = new JSONTokener(
				new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8)));
		JSONArray array = new JSONArray(tokener);
		System.out.format("  JSON Parsing - from file %s to JSONArray it took %d ms%n", fileName,
				System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		Coder[] coders = JSONConverter.codersFromJSONArray(array);
		System.out.format("  From JSONArray to Coders array it took %d ms%n",
				System.currentTimeMillis() - start);
		return coders;
	}

	private SetInterface<Coder> createTestSet() throws IOException {
		SetInterface<Coder> testSet = SetFactory.createCoderSet();

		testData = readCodersFromFile(TEST_FILE);
		for (Coder coder : testData) {
			testSet.insert(coder);
		}
		return testSet;
	}

}
