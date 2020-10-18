package hash;

import java.util.Random;

import hash.handlers.SimpleHandler;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		Hash hash = new Hash();
		hash.create(5, Hash.division, new SimpleHandler());

		for(int i=0; i<12; i++) {
			hash.insert(rand.nextInt(12), "Data");
		}
		
		System.out.println("Colisões: " + hash.comparator.getNumCollisions());
	}
}
