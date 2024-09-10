package oy.interact.tira.factories;

import oy.interact.tira.NotYetImplementedException;
import oy.interact.tira.model.Coder;
import oy.interact.tira.util.SetInterface;
import oy.interact.tira.util.ValueRange;

public class SetFactory {
	
	private SetFactory() {
		// empty
	}

	public static SetInterface<String> createStringSet() {
		throw new NotYetImplementedException("Task 08 about Sets not yet implemented");
	}

	public static SetInterface<Integer> createIntegerSet() {
		throw new NotYetImplementedException("Task 08 about Sets not yet implemented");
	}

	public static SetInterface<Coder> createCoderSet() {
		throw new NotYetImplementedException("Task 08 about Sets not yet implemented");
	}

	public static SetInterface<ValueRange> createValueRangeSet() {
		throw new NotYetImplementedException("Task 08 about Sets not yet implemented");
	}

}
