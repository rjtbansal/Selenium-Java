package testNgClasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNg_TestClass2 {
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("TestNg_TestClass2 ----> Runs before every method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("TestNg_TestClass2 ----> Runs after every method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("TestNg_TestClass2 ----> Runs once before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("TestNg_TestClass2 ----> Runs once after class");
  }

  @Test
  public void testMethod1() {
    System.out.println("TestNg_TestClass2 ----> Running testMethod1");
  }
  
  @Test
  public void testMethod2() {
    System.out.println("TestNg_TestClass2 ----> Running testMethod2");
  }
}
