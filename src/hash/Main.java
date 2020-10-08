package hash;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		Hash hash = new Hash();
		hash.create(5, Hash.multiplication);

		for(int i=0; i<30; i++) {
			hash.insert(rand.nextInt(100), "Data");
		}
		
		System.out.println("Colisões: " + hash.collisions);
	}

}
