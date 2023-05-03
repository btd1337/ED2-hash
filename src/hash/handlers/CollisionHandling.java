package hash.handlers;

import java.util.ArrayList;
import java.util.function.BiFunction;

import hash.Comparator;
import hash.Pair;

public interface CollisionHandling {
	public Pair handle(ArrayList<Pair>[] hashTable, int key, String data, BiFunction <Integer, Integer, Integer> hash, Comparator comparator);

}
