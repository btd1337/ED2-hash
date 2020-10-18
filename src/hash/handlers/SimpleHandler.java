package hash.handlers;

import java.util.ArrayList;

import hash.Comparator;
import hash.Pair;

public class SimpleHandler implements CollisionHandling{

	@Override
	public Pair handle(int index, ArrayList<Pair>[] hashTable, int key, String data, Comparator comparator) {
		if(hashTable[index].size() > 1) {
			comparator.addNumCollisions();
		}
		hashTable[index].add(new Pair(key, data));
		int lastElementIndex = hashTable[index].size() - 1;
		return hashTable[index].get(lastElementIndex);
	}

}
