package oy.interact.tira.grade_5.task_8;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import oy.interact.tira.factories.SetFactory;
import oy.interact.tira.util.SetInterface;

class BasicSetImplementationTests {

	@Test
	void testSetAllocationAndPropertiesOfEmptySet() {
		SetInterface<Integer> set = SetFactory.createIntegerSet();
		SetInterface<Integer> emptySet = SetFactory.createIntegerSet();
		assertTrue(set.isEmpty());
		assertEquals(0, set.count());
		assertFalse(set.contains(42));
		assertNull(set.contains( value -> value > 0 ));
		assertNull(set.remove(42));
		assertTrue(set.intersection(emptySet).isEmpty());
		assertTrue(set.union(emptySet).isEmpty());
		assertTrue(set.symmetricDifference(emptySet).isEmpty());
		assertTrue(set.filter( value -> value >= 0).isEmpty());
		// See https://math.stackexchange.com/questions/2653776/is-the-null-empty-set-both-a-subset-of-and-disjoint-from-every-non-empty-set
		assertTrue(set.isDisjoint(emptySet));
		assertTrue(set.isSubsetOf(emptySet));
		assertTrue(set.isSupersetOf(emptySet));
	}

	@Test 
	void testDisjointSets() {
		SetInterface<Integer> setOne = SetFactory.createIntegerSet();
		SetInterface<Integer> setTwo = SetFactory.createIntegerSet();
		assertTrue(setOne.insert(1));
		assertTrue(setOne.insert(2));
		assertTrue(setOne.insert(3));
		assertTrue(setTwo.insert(4));
		assertTrue(setTwo.insert(5));
		assertTrue(setTwo.insert(6));
		assertEquals(3, setOne.count());
		assertEquals(3, setTwo.count());

		assertTrue(setOne.intersection(setTwo).isEmpty());
		assertEquals(6, setOne.union(setTwo).count());
		assertEquals(6, setOne.symmetricDifference(setTwo).count());

		assertTrue(setOne.isDisjoint(setTwo));
		assertFalse(setOne.isSubsetOf(setTwo));
		assertFalse(setOne.isSupersetOf(setTwo));
	}

	@Test 
	void testIdenticalSets() {
		SetInterface<Integer> setOne = SetFactory.createIntegerSet();
		SetInterface<Integer> setTwo = SetFactory.createIntegerSet();
		assertTrue(setOne.insert(1));
		assertTrue(setOne.insert(2));
		assertTrue(setOne.insert(3));
		assertTrue(setTwo.insert(1));
		assertTrue(setTwo.insert(2));
		assertTrue(setTwo.insert(3));
		assertEquals(3, setOne.count());
		assertEquals(3, setTwo.count());
		assertEquals(true, setOne.equals(setTwo));

		assertEquals(3, setOne.intersection(setTwo).count());
		assertEquals(3, setOne.union(setTwo).count());
		assertEquals(0, setOne.symmetricDifference(setTwo).count());

		assertFalse(setOne.isDisjoint(setTwo));
		assertTrue(setOne.isSubsetOf(setTwo));
		assertTrue(setOne.isSupersetOf(setTwo));
	}

	@Test 
	void testOverlappingSets() {
		SetInterface<Integer> setOne = SetFactory.createIntegerSet();
		SetInterface<Integer> setTwo = SetFactory.createIntegerSet();
		assertTrue(setOne.insert(1));
		assertTrue(setOne.insert(2));
		assertTrue(setOne.insert(3));
		assertTrue(setTwo.insert(3));
		assertTrue(setTwo.insert(4));
		assertTrue(setTwo.insert(5));
		assertTrue(setTwo.insert(6));
		assertEquals(3, setOne.count());
		assertEquals(4, setTwo.count());
		assertEquals(false, setOne.equals(setTwo));
		
		assertEquals(1, setOne.intersection(setTwo).count());
		assertTrue(setOne.intersection(setTwo).contains(3));
		assertEquals(6, setOne.union(setTwo).count());
		assertEquals(5, setOne.symmetricDifference(setTwo).count());

		assertFalse(setOne.isDisjoint(setTwo));
		assertFalse(setOne.isSubsetOf(setTwo));
		assertFalse(setOne.isSupersetOf(setTwo));
	}

	@Test
	void testSubSets() {
		SetInterface<Integer> setOne = SetFactory.createIntegerSet();
		SetInterface<Integer> setTwo = SetFactory.createIntegerSet();
		assertTrue(setOne.insert(1));
		assertTrue(setOne.insert(2));
		assertTrue(setOne.insert(3));
		assertTrue(setOne.insert(4));
		assertTrue(setOne.insert(5));
		assertTrue(setTwo.insert(3));
		assertTrue(setTwo.insert(4));
		assertEquals(5, setOne.count());
		assertEquals(2, setTwo.count());
		assertEquals(false, setOne.equals(setTwo));

		assertEquals(2, setOne.intersection(setTwo).count());
		assertTrue(setOne.intersection(setTwo).contains(3));
		assertTrue(setOne.intersection(setTwo).contains(4));
		assertEquals(5, setOne.union(setTwo).count());
		assertEquals(3, setOne.symmetricDifference(setTwo).count());

		assertFalse(setOne.isDisjoint(setTwo));
		assertFalse(setOne.isSubsetOf(setTwo));
		assertTrue(setOne.isSupersetOf(setTwo));
		assertTrue(setTwo.isSubsetOf(setOne));
	}

	@Test
	void testAddingDuplicateValues() {
		SetInterface<Integer> setOfInts = SetFactory.createIntegerSet();
	
		assertTrue(setOfInts.insert(1));
		assertTrue(setOfInts.insert(2));
		assertFalse(setOfInts.insert(1));

		assertEquals(2, setOfInts.count());

		SetInterface<String> setOfStrings = SetFactory.createStringSet();
	
		assertTrue(setOfStrings.insert("blanko"));
		assertTrue(setOfStrings.insert("otit"));
		assertFalse(setOfStrings.insert("blanko"));
		assertFalse(setOfStrings.insert("otit"));

		assertEquals(2, setOfStrings.count());

		SetInterface<String> blankoOnly = setOfStrings.filter(string -> string.equals("blanko"));
		assertEquals(1, blankoOnly.count());
		assertTrue(blankoOnly.contains("blanko"));
	}

	@Test
	void testPredicates() {
		SetInterface<Integer> setOfInts = SetFactory.createIntegerSet();
		for (int integer = 1; integer <= 1000; integer++) {
			assertTrue(setOfInts.insert(integer));
		}
		SetInterface<Integer> setOfEvenNumbers = setOfInts.filter( value -> value % 2 == 0);
		for (Integer value : setOfEvenNumbers) {
			assertEquals(0, value % 2);
		}

		SetInterface<Integer> setOfOddNumbers = setOfInts.filter( value -> value % 2 != 0);
		for (Integer value : setOfOddNumbers) {
			assertTrue(value % 2 != 0);
		}

		assertTrue(setOfEvenNumbers.isDisjoint(setOfOddNumbers));
		assertTrue(setOfEvenNumbers.union(setOfOddNumbers).equals(setOfInts));

		SetInterface<Integer> setOfNumbersDivBySeven = setOfInts.filter( value -> value % 7 == 0);
		for (Integer value : setOfNumbersDivBySeven) {
			assertTrue(value % 7 == 0);
		}
	}

	@Test
	void testToArray() {
		SetInterface<Integer> setOfInts = SetFactory.createIntegerSet();
	
		assertTrue(setOfInts.insert(1));
		assertTrue(setOfInts.insert(2));
		assertTrue(setOfInts.insert(3));

		assertEquals(3, setOfInts.count());

		Integer [] array = new Integer[setOfInts.count()];
		assertDoesNotThrow(() -> setOfInts.toArray(array), "Set toArray must not throw");
		assertEquals(3, array.length);
		assertEquals(1, array[0]);
		assertEquals(2, array[1]);
		assertEquals(3, array[2]);
	}

	@Test
	void testClear() {
		SetInterface<Integer> setOfInts = SetFactory.createIntegerSet();
	
		assertTrue(setOfInts.insert(1));
		assertTrue(setOfInts.insert(2));
		assertTrue(setOfInts.insert(3));

		assertEquals(3, setOfInts.count());
		assertEquals(false, setOfInts.isEmpty());

		setOfInts.clear();
		assertEquals(0, setOfInts.count());
		assertEquals(true, setOfInts.isEmpty());
	}

}
