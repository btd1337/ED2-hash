package hash;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import hash.handlers.DoubleHashing;
import hash.handlers.LinearProbing;
import hash.handlers.PollingType;

public class Main {

	public static void main(String[] args) {
		String inputFile = "entrada.txt";
		int tableSize;
		int numElements;
		PollingType pollingType;
		Random rand = new Random();
		Hash hash = new Hash();
		
		System.out.println("Lendo arquivo " + inputFile + "...");
		Path path = Paths.get(inputFile);
		List<String> intermediateFile;

		try {
			intermediateFile = Files.readAllLines(path);
			List<Integer> inputData = Utils.convertStringArrayListToIntegerArrayList(intermediateFile);
			
			tableSize = inputData.get(0);
			numElements = inputData.get(1);
			switch(inputData.get(2)) {
				case 1: { hash.create(tableSize, Hash.division, new LinearProbing()); break; }
				case 2: { hash.create(tableSize, Hash.division, new DoubleHashing()); break; }
				default: {
					System.out.println("Número inválido para sondagem");
					return;
				}
			}

			for(int i=1; i < numElements; i++) {
				hash.insert(inputData.get(2+i), "");	// 2+i => index 0, 1 and 2 are the first input line values
			}
			
			System.out.println("Colisões: " + hash.comparator.getNumCollisions());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
