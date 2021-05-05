package math;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * An class used as a holder of the @RunWith and @Suite 
 * annotations
 * @author stamatiap 
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MyMathTest.class, MyMathFactorialTest.class})
public class MyMathTestSuite {

}
