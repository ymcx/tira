package oy.interact.tira.factories;

import oy.interact.tira.model.Coder;
import oy.interact.tira.student.SetImplementation;
import oy.interact.tira.util.SetInterface;
import oy.interact.tira.util.ValueRange;

public class SetFactory {
	
	private SetFactory() {
		// empty
	}

	public static SetInterface<String> createStringSet() {
		return new SetImplementation<String>();
	}

	public static SetInterface<Integer> createIntegerSet() {
		return new SetImplementation<Integer>();
	}

	public static SetInterface<Coder> createCoderSet() {
		return new SetImplementation<Coder>();
	}

	public static SetInterface<ValueRange> createValueRangeSet() {
		return new SetImplementation<ValueRange>();
	}

}
