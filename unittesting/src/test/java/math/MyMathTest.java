package math;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class MyMathTest {
	MyMath mm = new MyMath();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test_factorial_negative() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("number should between 0 and 12");
		mm.factorial(-7);
	}
	
	@Test
	public void test_factorial_overLimit() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("number should between 0 and 12");
		mm.factorial(21);
	}

	@Test
	public void test_isPrime_exception() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("number must be >= 2");
		mm.isPrime(0);
	}

}
