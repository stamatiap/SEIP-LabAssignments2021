package math;

import org.junit.Assert;
import org.junit.Test;
import io.FileIO;
import math.ArrayOperations;
import math.MyMath;

import static org.mockito.Mockito.*;

/**
 * An class that provides test cases for
 * the ArrayOperations class.
 * @author stamatiap
 */
public class ArrayOperationsTest {
	
	ArrayOperations ao ;
	
	public ArrayOperationsTest() {
		this.ao = new ArrayOperations();
	}
	
	@Test
	public void testReverseArrayNumbersMocking() {
		// Mock the MyMath dependency
		MyMath mm = mock(MyMath.class);
		FileIO fileio = mock(FileIO.class);
		
		// Pre-define the results of the readFile calls
		when(fileio.readFile("src/test/resources/mocking_test.txt")).thenReturn(new int[] {3,6,14,47});
		
		// Pre-define the results of the isPrime calls
		when(mm.isPrime(3)).thenReturn(true);
		when(mm.isPrime(6)).thenReturn(false);
		when(mm.isPrime(14)).thenReturn(false);
		when(mm.isPrime(47)).thenReturn(true);
		
		String testFilepath = "src/test/resources/mocking_test.txt";
		// Call the findPrimesInFile with the mocked MyMath and FileIO instances
		Assert.assertArrayEquals(new int[]{3,47}, 
				ao.findPrimesInFile(fileio, testFilepath, mm));
	}
	

}