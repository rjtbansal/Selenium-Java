package userfulmethods;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericMethodsDemo {

		private WebDriver driver;
		private String base_url;
		//getting object of custom GenericMethods class
		private GenericMethods gm;
		
		@Before
		public void setup() throws Exception {
			base_url = "https://letskodeit.teachable.com/pages/practice";
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjtba\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();			
			gm = new GenericMethods(driver); //passing current driver instance to GenericMethods class
			//maximize window
			driver.manage().window().maximize();
			//implicit wait for 10 seconds
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test
		public void testMethod() throws Exception {
			driver.get(base_url);
			
			//click on Practice page
			WebElement element = gm.getElement("Practice", "linkText");
			element.click();
			
			//click on Open Window button
		    element = gm.getElement("//button[@id=\"openwindow\"]", "xpath");
			element.click();
			
			//using custom getElement method in GenericMethods class
			//locator we looking for is name and type is id
			element = gm.getElement("name", "id");
			element.sendKeys("rjtbansal");
		}
		
		@After
		public void tearDown() throws Exception {
			Thread.sleep(3000);
			driver.quit();
		}
}
