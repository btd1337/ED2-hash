package hash.handlers;

import java.util.ArrayList;
import java.util.function.BiFunction;

import hash.Comparator;
import hash.Pair;

public class DoubleHashing implements CollisionHandling{
	
	static BiFunction <Integer, Integer, Integer> onePlusdivision = (index, m) -> 1 + (index % m);
	BiFunction<Integer, Integer, Integer> hash;

	@Override
	public Pair handle(ArrayList<Pair>[] hashTable, int key, String data, BiFunction<Integer, Integer, Integer> hash,
			Comparator comparator) {
		this.hash = hash;
		int index = this.getNextIndex(key, hashTable.length, 0);
		
		int hashIndex = this.checkAvailableIndex(index, index, false, hashTable, 0, comparator);
		
		boolean isTableFull = hashIndex == -1 ? true : false;
		
		if (isTableFull) {
			System.out.println("Error inserting element. The table is full.");
			return null;
		}
		
		hashTable[hashIndex].add(new Pair(key, data));
		return hashTable[hashIndex].get(0);
	}
	
	private int checkAvailableIndex(int currentIndex, int initialIndex, boolean isInitalChecked, ArrayList<Pair>[] hashTable, int iteration, Comparator comparator) {
		if (currentIndex == initialIndex) {
			if (isInitalChecked) {
				return -1;				
			}else {
				if (hashTable[currentIndex].size() == 0) {
					return currentIndex;
				} else {
					int nextIndex = this.getNextIndex(currentIndex, hashTable.length, iteration+1);
					isInitalChecked = true;
					comparator.addNumCollisions();
					return this.checkAvailableIndex(nextIndex, initialIndex, isInitalChecked, hashTable, iteration+1, comparator);
				}
			}
		}
		if (hashTable[currentIndex].size() == 0) {
			return currentIndex;
		}
		else {
			// Check if current index is last element and return it to zero position
			int nextIndex = this.getNextIndex(currentIndex, hashTable.length, iteration +1);
			comparator.addNumCollisions();
			return this.checkAvailableIndex(nextIndex, initialIndex, isInitalChecked, hashTable, iteration +1, comparator);
		}
	}

	private int getNextIndex(int index, int hashTableSize, int iteration) {
		int nextIndexValue = (this.hash.apply(index, hashTableSize) + iteration * DoubleHashing.onePlusdivision.apply(index, hashTableSize - 1)) % hashTableSize;
		// return to begin if it overflow the list size
		return nextIndexValue <= hashTableSize - 1 ? nextIndexValue : nextIndexValue - (hashTableSize - 1);
	}

}
