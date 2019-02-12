package testNgClasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_Prioritiy {
  
	@BeforeClass
	public void setUp() {
		System.out.println("TestNG_Prioritiy -> before class");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("TestNG_Prioritiy -> after class");
	}
	
	/* within test annotation 'priority' parameter specifies the priority of the test methods to be run. 
	 * */
	@Test(priority=2)
	public void testMethod1() {
		System.out.println("TestNG_Prioritiy -> testMethod1");
	}
	
	//priority=1 will run second and so on
	@Test(priority=1)
	public void testMethod2() {
		System.out.println("TestNG_Prioritiy -> testMethod2");
	}
	
	//priority=0 will run below test method first
	@Test(priority=0)
	public void testMethod3() {
		System.out.println("TestNG_Prioritiy -> testMethod3");
	}

}
