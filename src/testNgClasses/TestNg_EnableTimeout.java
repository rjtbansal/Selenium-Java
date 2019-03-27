package testNgClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNg_EnableTimeout {
	@BeforeMethod
	@BeforeClass
	public void setUp() {
		System.out.println("before class");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("after class");
	}
	
	//enabled false will disable the below test method to run. useful when debugging if we want to disable it
	@Test(enabled=false)
	public void testMethod1() {
		System.out.println("testMethod1");
	}
	
	//timeout means the time this test should take to execute. if timeout exceeds exception is thrown
	@Test(timeOut=300)
	public void testMethod2() throws InterruptedException {
		System.out.println("testMethod2");
		Thread.sleep(200);
	}
}
