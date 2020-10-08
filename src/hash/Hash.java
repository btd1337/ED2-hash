package hash;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class Hash {
	ArrayList<Pair>[] hashTable;
	int tableSize;
	BiFunction<Integer, Integer,Integer> hash;
	
	static BiFunction <Integer, Integer, Integer> division = (index, tableSize) -> index % tableSize;
	static BiFunction <Integer, Integer, Double> multiplication = (index, tableSize) -> Math.floor(tableSize*(index*((Math.sqrt(5)-1)/2)%1));
	
	@SuppressWarnings("unchecked")
	void create(int tableSize, BiFunction<Integer, Integer,Integer> hash) {
		this.tableSize = tableSize;
		this.hash = hash;

		this.hashTable = new ArrayList[tableSize];
		
		for(int i=0; i<tableSize; i++) {
			this.hashTable[i] = new ArrayList<Pair>();
		}
	}
	
	Pair insert(int key, String data) {
		int tableIndex = this.getHashTableIndex(key);
		this.hashTable[tableIndex].add(new Pair(key, data));
		int lastElementIndex = this.hashTable[tableIndex].size() - 1;
		return this.hashTable[tableIndex].get(lastElementIndex);
	}
	
	Pair lookup(int key, String data) {
		int tableIndex = this.getHashTableIndex(key);
		int index = this.hashTable[tableIndex].indexOf(new Pair(key, data));
		return index != -1 ? this.hashTable[tableIndex].get(index) : null;
	}
	
	void detroy() {
		for(int i=0; i < this.hashTable.length; i++) {
			this.hashTable[i].clear();
		}
	}
	
	int getHashTableIndex(int key) {
		return this.hash.apply(key, this.tableSize);
	}
	
	void printHash() {
		for(int i=0; i<this.tableSize; i++) {
			for(int j=0; j < this.hashTable[i].size(); j++) {
				System.out.println("[" + i + ", " + j + "] = " + this.hashTable[i].get(j));							
			}
		}
	}
}
