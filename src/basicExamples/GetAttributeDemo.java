package basicExamples;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeDemo {

	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setup() throws Exception {
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjtba\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		//maximize window
		driver.manage().window().maximize();
		//implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testGetAttribute() {
		
		//look for element with id 'name'
		WebElement elem = driver.findElement(By.id("name"));
		//look for an attribute 'type' within same tag whose id is name
		String attributeVal = elem.getAttribute("type");
		System.out.println("Value of attribute: type " + attributeVal);
		
		String attribute_class_value = elem.getAttribute("class");
		System.out.println("Value of class attribute: " + attribute_class_value);
		
		String attrib_name_val = elem.getAttribute("name");
		System.out.println("Value of name attribute: " + attrib_name_val);
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
}
