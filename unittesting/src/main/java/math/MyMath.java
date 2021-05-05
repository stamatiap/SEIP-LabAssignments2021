package math;

/**
 * A class that provides a method for calculating
 * the factorial of a number 
 * @author stamatiap
 */
public class MyMath {
	/**
	 * This method receives an integer and calculates 
	 * its factorial
	 * @param n integer
	 */
	 public int factorial(int n) {
		 int nFactorial = 1;
		 if (n < 0 || n > 12) {
			 throw new IllegalArgumentException("number should between 0 and 12");
		 }else if(n != 0){
			 for (int i = 1; i <= n; i++) {
				 nFactorial *= i;
			 }
		 }
		 return nFactorial;
	 }

}
