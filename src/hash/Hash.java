package hash;

import java.util.ArrayList;

public class Hash {
	ArrayList<Pair>[] hashTable;
	
	@SuppressWarnings("unchecked")
	void create(int tableSize) {
		this.hashTable = new ArrayList[tableSize];
		
		for(int i=0; i<tableSize; i++) {
			this.hashTable[i] = new ArrayList<Pair>();
		}
	}
	
	Pair insert(int key, String data) {
		this.hashTable[0].add(new Pair(key, data));
		int lastElementIndex = this.hashTable[0].size() - 1;
		return this.hashTable[0].get(lastElementIndex);
	}
	
	Pair lookup(int key, String data) {
		int index = this.hashTable[0].indexOf(new Pair(key, data));
		return index != -1 ? this.hashTable[0].get(index) : null;
	}
}
