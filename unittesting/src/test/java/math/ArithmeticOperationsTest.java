package math;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Assert;

public class ArithmeticOperationsTest {
	ArithmeticOperations ao = new ArithmeticOperations();

	@Test (expected = ArithmeticException.class)
	public void test_divide_zero_exception() {
		ao.divide(1, 0);
	}
	
	@Test
	public void test_divide_result() {
		Assert.assertEquals(10, ao.divide(100, 10), 0.001);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test_multiply_getX_negative() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(-4, 2);
	}
	
	@Test
	public void test_multiply_getY_negative() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(4, -2);
	}

	
	@Test
	public void test_multiply_getX_BigInteger() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(Integer.MAX_VALUE, 4);
	}
	
	@Test
	public void test_multiply_getY_BigInteger() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(4, Integer.MAX_VALUE);
	}
	
	@Test
	public void test_multiply_result() {
		Assert.assertEquals(200, ao.multiply(10, 20));
	}
}
