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
		Assert.assertEquals(0.1, ao.divide(10, 100), 0.001);
		Assert.assertEquals(-2, ao.divide(-8, 4), 0.001);
		Assert.assertEquals(-0.5, ao.divide(4, -8), 0.001);
	}
	
	@Test
	public void test_divide_zero_result() {
		Assert.assertEquals(0, ao.divide(0, 10), 0.001);
		Assert.assertEquals(0, ao.divide(0, -10), 0.001);
	}
	
	@Test
	public void test_divide_borders() {
		Assert.assertEquals(-1, ao.divide(-1, 1), 0.001);
		Assert.assertEquals(-1, ao.divide(1, -1), 0.001);
		Assert.assertEquals(1, ao.divide(1, 1), 0.001);
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
	public void test_multiply_x_zero_result() {
		Assert.assertEquals(0, ao.multiply(0, 7));
	}
	
	@Test
	public void test_multiply_y_zero_result() {
		Assert.assertEquals(0, ao.multiply(7, 0));
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

	@Test
	public void test_multiply_borders() {
		Assert.assertEquals(7, ao.multiply(1, 7));
		Assert.assertEquals(8, ao.multiply(8, 1));
		Assert.assertEquals(Integer.MAX_VALUE, ao.multiply(Integer.MAX_VALUE, 1));
		Assert.assertEquals(Integer.MAX_VALUE, ao.multiply(1, Integer.MAX_VALUE));
	}
}
