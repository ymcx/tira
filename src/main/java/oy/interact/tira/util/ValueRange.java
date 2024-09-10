package oy.interact.tira.util;

	// Test class to cause deliberate hash collisions in tests.
	public class ValueRange implements Comparable<ValueRange> {
		private int value;

		public ValueRange(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
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