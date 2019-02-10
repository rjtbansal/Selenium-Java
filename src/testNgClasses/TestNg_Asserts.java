package testNgClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testNgClassesToTest.MathTestClass;

public class TestNg_Asserts {
	//Test annotation means below method is a test case
	
	/*@Test cases run in an alphabetical order and not the order in which they are coded
	 * 
	 * Here execution order would be : testArrays -> testStrings -> testSum
	 * 
	 * */
  @Test
  public void testSum() {
	  
	  System.out.println("\n Running testSum test case");
	  MathTestClass mathObj = new MathTestClass();
	  int sum = mathObj.addNumbers(12, 1);
	  //Assert.assertEquals(sum, 13);
	  //assert conditions specifies if result of actual matches with expected and based on condition test passes/fails
	  Assert.assertNotEquals(sum, 13);
	  
	  /*below statement wont execute if assertion above fails and it will throw an exception.
	   * This is typically Hard Assertion by default. In hard assertion if an assertion fails all code below that assertion for that test method wont execute at all
	   * */
	 
	  System.out.println("\ntestSum method after assertion");
  }
  
  @Test
  public void testSumSoftAssert() {
	 /*
	  * SOft Asserts: In this method we are using Soft Assert. With SOft Assert even when an assert fails, the following code continues executing. If we really want to throw an exception and stop the further execution of the testcase,
	  * then at the end of the method use assertAll
	  */
	  System.out.println("\n Running testSumSoftAssert test case");
	  MathTestClass mathObj = new MathTestClass();
	  int sum = mathObj.addNumbers(12, 1);
	  
	  SoftAssert sa = new SoftAssert(); //to use soft assert explicitly instantiate its object
	  sa.assertEquals(sum, 10); //use soft assert object to access its methods
	  System.out.println("----After first assertEqual----");
	  sa.assertNotEquals(sum, 13);
	  System.out.println("----After second assertEqual----");
	  //sa.assertAll();  //if we want to throw exception on failed assert and dont want the code to continue executing, use assertAll at the end of the test case
  }
  
  @Test
  public void testStrings() {
	  System.out.println("\n Running testStrings test case");
	  MathTestClass mathObj = new MathTestClass();
	  String added_strings = mathObj.addStrings("hello", "world");
	  Assert.assertEquals(added_strings, "hello world");
  }
  
  @Test
  public void testArrays() {
	  System.out.println("\n Running testArrays method");
	  int[] expected_array = {2,2,1};
	  MathTestClass mathObj = new MathTestClass();
	  int[] actual_array=mathObj.getArray();
	  
	  Assert.assertNotEquals(actual_array, expected_array);
	  
  }
}
