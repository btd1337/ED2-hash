package hash.handlers;

import java.util.ArrayList;
import java.util.function.BiFunction;

import hash.Comparator;
import hash.Pair;

public class SimpleHandler implements CollisionHandling{

	@Override
	public Pair handle(ArrayList<Pair>[] hashTable, int key, String data, BiFunction <Integer, Integer, Integer> hash, Comparator comparator) {
		int index = hash.apply(key, hashTable.length);
		if(hashTable[index].size() > 1) {
			comparator.addNumCollisions();
		}
		hashTable[index].add(new Pair(key, data));
		int lastElementIndex = hashTable[index].size() - 1;
		return hashTable[index].get(lastElementIndex);
	}
}
