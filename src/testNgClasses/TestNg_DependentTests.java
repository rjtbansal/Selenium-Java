package testNgClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testNgClassesToTest.MathTestClass;

public class TestNg_DependentTests {
  
	MathTestClass math_obj;
	
	@BeforeMethod
	@BeforeClass
	public void setUp() {
		math_obj = new MathTestClass();
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("after class");
	}
	
	/**
	 * dependsOnMethods are those methods which this test method depends upon. So here testMethod1 below is depending on testMethod2 to run.
	 * The order of other methods in which they are run does not matter but the methods specified in dependsOnMethods will definitely run prior
	 * to the below method. If any of the dependent methods fail, all subsequent methods will be skipped. To prevent that we could use alwaysRun
	 */
	@Test(dependsOnMethods= {"testMethod2"}, alwaysRun=true)
	public void testMethod1() {
		System.out.println("testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("testMethod2");
		int result = math_obj.addNumbers(1, 2);
		AssertJUnit.assertEquals(result, 2);
	}
	
	//testMethod3 is depending on testMethod1 
	@Test(dependsOnMethods = {"testMethod1"})
	public void testMethod3() {
		System.out.println("testMethod3");
	}
	
	@Test
	public void testMethod4() {
		System.out.println("testMethod4");
	}
	
}
