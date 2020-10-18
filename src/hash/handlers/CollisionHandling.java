package hash.handlers;

import java.util.ArrayList;

import hash.Comparator;
import hash.Pair;

public interface CollisionHandling {
	public Pair handle(int index, ArrayList<Pair>[] hashTable, int key, String data, Comparator comparator);
}
