package testNgClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class BaseTestSuite {
 
	
  @BeforeClass
  public void beforeClass() {
	  System.out.println("\nBaseTestSuite -> before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("\nBaseTestSuite -> after class");
  }
  
  @BeforeTest
	public void beforeTest() {
		System.out.println("\nBaseTestSuite -> before test");
	}

  @AfterTest
	public void afterTest() {
		System.out.println("\nBaseTestSuite -> after test");
    }
  

  

  //runs only at the beginning of the testsuite
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("\nBaseTestSuite -> before suite");
  }

  //runs only at the end of testsuite
  @AfterSuite
  public void afterSuite() {
	  System.out.println("\nBaseTestSuite -> after suite");
  }
  

}
