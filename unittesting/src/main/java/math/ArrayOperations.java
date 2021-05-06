package math;

import io.FileIO;
import java.util.ArrayList;
import java.util.List;

public class ArrayOperations {
	
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		int[] numbers = fileIo.readFile(filepath);
		MyMath mm = new MyMath();
		List<Integer> selectedNumbers = new ArrayList<>();
		
		for (int num : numbers) {
			if (mm.isPrime(num)) {
				selectedNumbers.add(num);
			}
		}
		
		int [] selectedNums = new int[selectedNumbers.size()];
		for (int i = 0; i <= selectedNumbers.size() - 1; i++) {
			selectedNums[i] = selectedNumbers.get(i);
		}
		
		return selectedNums;
	}
}
