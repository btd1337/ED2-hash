package hash.handlers;

import java.util.ArrayList;
import java.util.function.BiFunction;

import hash.Comparator;
import hash.Pair;

public class LinearProbing implements CollisionHandling{
	@Override
	public Pair handle(ArrayList<Pair>[] hashTable, int key, String data, BiFunction <Integer, Integer, Integer> hash, Comparator comparator) {
		int index = hash.apply(key, hashTable.length);
		int hashIndex = this.checkAvailableIndex(index, index, false, hashTable, comparator);
		
		boolean isTableFull = hashIndex == -1 ? true : false;
		
		if (isTableFull) {
			System.out.println("Error inserting element. The table is full.");
			return null;
		}
		
		hashTable[hashIndex].add(new Pair(key, data));
		return hashTable[hashIndex].get(0);
	}
	
	private int checkAvailableIndex(int currentIndex, int initialIndex, boolean isInitalChecked, ArrayList<Pair>[] hashTable, Comparator comparator) {
		if (currentIndex == initialIndex) {
			if (isInitalChecked) {
				return -1;				
			}else {
				if (hashTable[currentIndex].size() == 0) {
					return currentIndex;
				} else {
					int nextIndex = this.getNextIndex(currentIndex, hashTable.length);
					isInitalChecked = true;
					comparator.addNumCollisions();
					return this.checkAvailableIndex(nextIndex, initialIndex, isInitalChecked, hashTable, comparator);
				}
			}
		}
		if (hashTable[currentIndex].size() == 0) {
			return currentIndex;
		}
		else {
			// Check if current index is last element and return it to zero position
			int nextIndex = this.getNextIndex(currentIndex, hashTable.length);
			comparator.addNumCollisions();
			return this.checkAvailableIndex(nextIndex, initialIndex, isInitalChecked, hashTable, comparator);
		}
	}

	private int getNextIndex(int currentIndex, int hashTableSize) {
		// return to begin if it overflow the list size
		return currentIndex != hashTableSize - 1 ? currentIndex + 1 : 0;
	}
}
