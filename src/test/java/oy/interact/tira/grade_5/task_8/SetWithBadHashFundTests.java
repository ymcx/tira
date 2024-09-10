package oy.interact.tira.grade_5.task_8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import oy.interact.tira.factories.SetFactory;

import oy.interact.tira.util.SetInterface;
import oy.interact.tira.util.ValueRange;

class SetWithBadHashFundTests {

	private static final int TEST_DATA_INITIAL_VALUE = 1;
	private static final int TEST_DATA_UPPER_VALUE = 42;

	@Test
	@DisplayName("Testing Set insert and get with bad hash function")
	void testInsertAndGet() {

		SetInterface<ValueRange> testSet = createTestSet();
		assertEquals(TEST_DATA_UPPER_VALUE, testSet.count());

		for (int value = TEST_DATA_INITIAL_VALUE; value <= TEST_DATA_UPPER_VALUE; value++) {
			ValueRange found = testSet.get(new ValueRange(value));
			assertNotNull(found);
			assertEquals(value, found.getValue());
		}
		System.out.println("Insert and get test passed");
	}

	@Test
	@DisplayName("Testing Set insert and remove with bad hash function")
	void testInsertAndRemove() {

		SetInterface<ValueRange> testSet = createTestSet();

		assertEquals(TEST_DATA_UPPER_VALUE, testSet.count());

		for (int value = TEST_DATA_INITIAL_VALUE; value <= TEST_DATA_UPPER_VALUE; value++) {
			ValueRange found = testSet.remove(new ValueRange(value));
			assertNotNull(found);
			assertEquals(value, found.getValue());
		}
		assertTrue(testSet.isEmpty());
		System.out.println("Insert and remove test passed");
	}

	private SetInterface<ValueRange> createTestSet() {
		SetInterface<ValueRange> testSet = SetFactory.createValueRangeSet();

		for (int value = TEST_DATA_INITIAL_VALUE; value <= TEST_DATA_UPPER_VALUE; value++) {
			ValueRange valueRange = new ValueRange(value);
			testSet.insert(valueRange);
		}
		return testSet;
	}

}
