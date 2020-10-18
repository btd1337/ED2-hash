package hash;

import java.util.Random;

import hash.handlers.LinearProbing;
import hash.handlers.SimpleHandler;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		Hash hash = new Hash();
		// hash.create(5, Hash.division, new SimpleHandler());
		hash.create(5, Hash.division, new LinearProbing());

		for(int i=1; i <= 10; i++) {
			hash.insert(i, "Data");
		}
		
		System.out.println("Colisões: " + hash.comparator.getNumCollisions());
	}
}
