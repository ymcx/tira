package oy.interact.tira.util;

public interface Visitable<K,V> {
	void accept(Visitor<K,V> visitor) throws Exception;
}
