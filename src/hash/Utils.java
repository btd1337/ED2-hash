package hash;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	static Integer doubleToInteger(double valueDouble) {
		return new Integer((int) valueDouble);
	}
	
	public static ArrayList<Integer> convertStringArrayListToIntegerArrayList(List<String> list)
			throws NumberFormatException {
		ArrayList<Integer> auxList = new ArrayList<Integer>();
		
		String[] line1 = list.get(0).split(" ");
		
		for (String element : line1) {
			auxList.add(Integer.parseInt(element));			
		}

		for (int i = 1; i < list.size(); i++) {
			auxList.add(Integer.parseInt(list.get(i)));
		}

		return auxList;
	}
}
