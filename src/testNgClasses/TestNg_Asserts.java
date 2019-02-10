package testNgClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import testNgClassesToTest.MathTestClass;

public class TestNg_Asserts {
	//Test annotation means below method is a test case
  @Test
  public void testSum() {
	  
	  System.out.println("Running testSum test case");
	  MathTestClass mathObj = new MathTestClass();
	  int sum = mathObj.addNumbers(12, 1);
	  //Assert.assertEquals(sum, 13);
	  //assert conditions specifies if result of actual matches with expected and based on condition test passes/fails
	  Assert.assertNotEquals(sum, 13);
  }
  
  @Test
  public void testStrings() {
	  System.out.println("Running testStrings test case");
	  MathTestClass mathObj = new MathTestClass();
	  String added_strings = mathObj.addStrings("hello", "world");
	  Assert.assertEquals(added_strings, "hello world");
  }
  
  @Test
  public void testArrays() {
	  System.out.println("Running testArrays method");
	  int[] expected_array = {2,2,1};
	  MathTestClass mathObj = new MathTestClass();
	  int[] actual_array=mathObj.getArray();
	  
	  Assert.assertNotEquals(actual_array, expected_array);
	  
  }
}
