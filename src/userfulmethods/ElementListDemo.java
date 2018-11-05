package userfulmethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementListDemo {

	WebDriver driver;
	String base_url;
	GenericMethods gm;
	
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
		
		List<WebElement> element_list = gm.getElementList("//input[@type='text']", "xpath");
		
		int size = element_list.size();
		System.out.println("Size of the element list is: " + size);
		System.out.println("Element List:");
		for(WebElement elem : element_list) {
			System.out.println(elem.toString());
		}
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
