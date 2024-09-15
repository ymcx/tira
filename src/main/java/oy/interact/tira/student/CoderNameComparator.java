package oy.interact.tira.student;

import java.util.Comparator;
import oy.interact.tira.model.Coder;

public class CoderNameComparator implements Comparator<Coder> {
    @Override
    public int compare(Coder o1, Coder o2) {
        return o1.getCoderName().compareTo(o2.getCoderName());
    }
}
