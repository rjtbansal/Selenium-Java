package testNgClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNgGrouping {
 
	//alwaysRun ensures the method always runs irrespective of grouping rules
  @BeforeClass(alwaysRun=true)
  public void beforeClass() {
	  System.out.println("Before class method");
  }
  
  //groups specified in test argument are similar to tags in robot framework. We can group tests to run specific tests instead of running all the tests in a testsuite
  //we need to specify which groups to run in an xml file : here its testng-groups.xml
  @Test(groups= {"cars","suv"})
  public void testHondaCRV() {
	  System.out.println("Running test -> Honda CRV");
  }
  
  @Test(groups= {"cars","sedan"})
  public void testAudiA6() {
		System.out.println("Running Test - Audi A6 ");
	}
  
  @Test(groups= {"bikes"})
  public void testNinja() {
		System.out.println("Running Test - Kawasaki Ninja");
	}
  
  @Test(groups= {"bikes"})
  public void testHondaCBR() {
		System.out.println("Running Test - Honda CBR");
	}

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  System.out.println("After class method");
  }

}
