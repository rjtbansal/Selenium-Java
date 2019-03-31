package testNgClasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersDemo {
	
 /**
  * DataProviders allow specifying data and its values which can then be called by calling a single test method
  * Below getUsers method contains 2d object containing user and their values
  * DataProvider is identified by its name
  */
//  @DataProvider(name="users")
//  public Object[][] getUsers() {
//	  return new Object[][] {
//		  {"user1","rajat"},
//		  {"user2","jack"},
//		  {"user3","ashley"}
//		  };
//	  }
  
  /**
   *In below method above data provider is wired using dataProvider attribute and specifying its name i,e users in this case
   */
//  @Test(dataProvider="users")
//  public void testUsers(String user, String name) {
//	  System.out.println("User: " + user);
//	  System.out.println("Name: " + name);
//  }
	
  /*Below method we are moving DataProvider method in a seperate class and we specify that class name within Test annotation using
   * dataProviderClass attribute
   * */
  @Test(dataProvider="users", dataProviderClass=UserData.class)
  public void testUsers(String user, String name) {
	  System.out.println("User: " + user);
	  System.out.println("Name: " + name);
  }
  
  
  
}
