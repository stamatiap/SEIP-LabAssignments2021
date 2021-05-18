package math;

import io.FileIO;
import java.util.ArrayList;
import java.util.List;

/**
* The ArrayOperations provides a method
* that returns the prime numbers in a file
*
* @author  stamatiap
*/
public class ArrayOperations {
	/**
	 * This method receives the path of a file, reads the file and
	 * returns all the prime numbers that are in it
	 * 
	 * @param fileio FileIO object
	 * @param filepath String, the path of the file
	 * @param myMath MyMath object
	 */
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
