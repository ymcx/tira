package oy.interact.tira.util;

import java.util.function.Predicate;

/**
 * Implement this interface as a concrete class.
 * 
 * Impleent also the Iterable interface, using a private inner class
 * that iterates over the elements in the set internal array, returning
 * null when no more elements can be iterated.
 * 
 * Note also that you need to implement also equals method, overriding the 
 * method from `Object` class. Equals returns true if the other object is
 * a set, and contains exactly the same number of elements that are identical
 * to elements in this set.
 */
public interface SetInterface<E> extends Iterable<E> {

	/**
	 * Inserts a new element to set. If inserted successfully, returns true. 
	 * @param element Element to add
	 * @return Returns true if element was inserted, and false if element already existed in set and was not added.
	 * @throws NullPointerException If element is null, throws this exception.
	 * @throws OutOfMemoryError If memory ran out when adding new element.
	 */
	public boolean insert(E element) throws NullPointerException, OutOfMemoryError;

	/**
	 * Removes the element from the set, returning the element removed.
	 * @param element The element to remove.
	 * @return Returns the element, or null if element was not in the set.
	 * @throws NullPointerException If parameter element was null.
	 */
	public E remove(E element) throws NullPointerException;

	/**
	 * Empties the set.
	 */
	public void clear();

	/**
	 * Use this method to check if the set contains the specified element.
	 * @param element The element to check.
	 * @return Returns true if element is in the set, otherwise returns false.
	 * @throws NullPointerException If the element was null.
	 */
	public boolean contains(E element) throws NullPointerException;

	/**
	 * Check if the set contains an element satisfying the given predicate.
	 * @param predicate The predicate to use to check for element in the set.
	 * @return True if the set contains an element satisying the predicate, false otherwise.
	 */
	public E contains(Predicate<E> predicate);

	/**
	 * Retrieves an element from the set, if it contains the one satisfying equals.
	 * @param element The element to get from the set.
	 * @return The element from the set, or null if one cannot be found.
	 * @throws NullPointerException If parameter element is null.
	 */
	public E get(E element) throws NullPointerException;
	
	/**
	 * Check if the set is empty
	 * @return True if set is empty, false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Query the number of elements in the set.
	 * @return The number of elements in the set.
	 */
	public int count();

	/**
	 * How many elements the set could hold with current capacity.
	 * @return The number of elements set can contain without reallocating space.
	 */
	public int capacity();

	/**
	 * Get the elements from the set in an array. To use this, first query
	 * the count of elements in the set, then allocate enough room for the elements
	 * in an array, and then pass that array to this method. The array is filled
	 * with elements in the set.
	 * @param array The array to place the elements from the set to.
	 */
	public void toArray(E [] array);

	/**
	 * Creates and returns a new set that contains the unique elements in both sets.
	 * 
	 * @param anotherSet The other set to take the intersection with.
	 * @return A new set containing elements in both sets.
	 * @throws OutOfMemoryError If memory runs out when creating the new set.
	 */
	public SetInterface<E> intersection(SetInterface<E> anotherSet) throws OutOfMemoryError;

	/**
	 * Creates and returns a new set that contains elements in this set, not in the other set.
	 * 
	 * @param anotherSet A set to subtract from this set.
	 * @return A new set containing elements in this set but not in the other set.
	 * @throws OutOfMemoryError If memory runs out when creating the new set.
	 */
	public SetInterface<E> subtracting(SetInterface<E> anotherSet) throws OutOfMemoryError;

	/**
	 * Creates and returns a new set containing unique elements from this and the other set.
	 * 
	 * @param anotherSet The other set to create an union from.
	 * @return A new set containing unique elements from both sets.
	 * @throws OutOfMemoryError If memory runs out when creating the new set.
	 */
	public SetInterface<E> union(SetInterface<E> anotherSet) throws OutOfMemoryError;

	/**
	 * Creates and returns a new set containing elements that are only in this or the other
	 * set but not in both sets.
	 * 
	 * @param anotherSet The other set to form the difference with this set.
	 * @return Returns the new set with elements in either set but not in both.
	 * @throws OutOfMemoryError If memory runs out when creating the new set.
	 */
	public SetInterface<E> symmetricDifference(SetInterface<E> anotherSet) throws OutOfMemoryError;

	/**
	 * Check if the other set is a subset of this set.
	 * Note that if sets are equal, containing exactly the same elements, this
	 * method should return true. A strict proper subset would be a set that is smaller.
	 * 
	 * @param anotherSet Another set to check against this set.
	 * @return True if anotherSet is a subset (or equal to) this set.
	 */
	public boolean isSubsetOf(SetInterface<E> anotherSet);

	/**
	 * Check if the other set is a superset of this set.
	 * Note that if sets are equal, containing exactly the same elements, this
	 * method should return true. A strict proper superset would be a set that is larger.
	 * 
	 * @param anotherSet Another set to check against this set.
	 * @return True if anotherSet is a superset (or equal to) this set.
	 */
	public boolean isSupersetOf(SetInterface<E> anotherSet);

	/**
	 * Checks if the other set is disjoint of this set, meaning that it does not
	 * contain any of the elements in this set.
	 * 
	 * @param anotherSet Another set to check against this one.
	 * @return True if the sets are disjoint, false otherwise.
	 */
	public boolean isDisjoint(SetInterface<E> anotherSet);

	/**
	 * Creates and returns a new set that contains only elements from this
	 * set that satisfy the given predicate.
	 * 
	 * @param filter The predicate to use in filtering.
	 * @return A new set containing elements from this set satisfying the given predicate.
	 * @throws OutOfMemoryError If memory runs out when creating the new set.
	 */
	public SetInterface<E> filter(Predicate<E> filter) throws OutOfMemoryError;
}