package hash;

public class Main {

	public static void main(String[] args) {
		Hash hash = new Hash();
		hash.create(5);
		hash.insert(1, "Brasil");
		System.out.println(hash.lookup(1, "brasil"));
	}

}
