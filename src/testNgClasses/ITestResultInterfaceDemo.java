package testNgClasses;

import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ITestResultInterfaceDemo {
	
  @Test
  public void testMeth1() {
	  System.out.println("Running -> testMethod1");
	  Assert.assertTrue(false);
  }
  
  @Test
  public void testMeth2() {
	  System.out.println("Running -> testMethod2");
	  Assert.assertTrue(true);
  }
  
  @AfterMethod
  /**
   * ITestResult class provided by TestNg provides result of a test
   */
  public void resultMeth(ITestResult testResult) {
	  //comparing status to testResult and check if its a failure
	  if(testResult.getStatus() == ITestResult.FAILURE) {
		  System.out.println(testResult.getStatus());
		  //getting test method name which failed
		  System.out.println("Test Failed: " + testResult.getMethod().getMethodName());
		  System.out.println("----------------------------------------------");
	  }
	  if(testResult.getStatus() == ITestResult.SUCCESS) {
		  System.out.println(testResult.getStatus());
		  System.out.println("Test Passed: " + testResult.getName());
	  }
  }
}
