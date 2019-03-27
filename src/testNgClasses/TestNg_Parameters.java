package testNgClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNg_Parameters {
	
  @BeforeClass
  @Parameters({"browser", "platform"}) //mapping params from xml file. names in xml should match
  public void setup(String browser1, String platform) {
	  System.out.println("TestNG_Parameters -> Setup");
		System.out.println("1. Parameter value from xml file: " + browser1);
		System.out.println("2. Parameter value from xml file: " + platform);
  }
  
  @Test
  @Parameters({"response"})
  public void testMethod1(String response) throws InterruptedException {
	  String[] stringArr = response.split(",");
	  System.out.println("TestNG_Parameters -> testMethod1");
	  System.out.println("Response from xml file: " + response);
	  System.out.println("stringArray[0] from xml file: " + stringArr[0]);
	  System.out.println("stringArray[1] from xml file: " + stringArr[1]);
  }
}
