package hash;

public class Main {

	public static void main(String[] args) {
		// System.out.println(4 % 5);
		Hash hash = new Hash();
		hash.create(5, Hash.division);
		hash.insert(1, "Brasil1");
		
		hash.printHash();
	}

}
