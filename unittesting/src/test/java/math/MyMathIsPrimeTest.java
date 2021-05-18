package math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Collection;

/**
 * A test class that implements a Parameterized test
 * for the MyMath isPrime method.
 * @author stamatiap 
 */

@RunWith(Parameterized.class)
public class MyMathIsPrimeTest {
	// the value is the id of each parameter
	@Parameter (value = 0) 
	public int number;
	@Parameter (value = 1)
	public boolean result;
		
	MyMath mm = new MyMath();
		
	/*
	 * The following method generates the input values 
	 * for the tests. 
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{2,true},{3,true},{6,false},{20,false},{23,true}};
			
		return Arrays.asList(data);
	}
		
	/*
	 * A unit test that is executed for each pair of 
	 * parameters. 
	 */
	@Test
	public void testisPrime() {
		Assert.assertEquals(result, mm.isPrime(number));
	}
}

