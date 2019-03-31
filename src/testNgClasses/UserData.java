package testNgClasses;

import org.testng.annotations.DataProvider;

public class UserData {

	 @DataProvider(name="users")
	  public Object[][] getUsers() {
		  return new Object[][] {
			  {"user1","rajat"},
			  {"user2","jack"},
			  {"user3","ashley"}
			  };
		  }
}
