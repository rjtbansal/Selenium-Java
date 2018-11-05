package basicExamples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelect {
	private WebDriver driver;
	private String baseUrl;
	DesiredCapabilities dc;

	@Before
	public void setUp() throws Exception {
		dc = DesiredCapabilities.firefox();
		dc.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rjtba\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	public void testDropdown() throws Exception {
		WebElement element = driver.findElement(By.id("carselect"));
		//note: Select only will work for dropdowns with select tags
		Select sel = new Select(element); //creating select object to be used for dropdowns 
		
		Thread.sleep(2000);
		System.out.println("Select Benz by value");
		//will choose value attribute within option tag
		sel.selectByValue("benz");
		
		Thread.sleep(2000);
		System.out.println("Select Honda by index");
		sel.selectByIndex(2);
		
		Thread.sleep(2000);
		System.out.println("Select BMW by visible text");
		sel.selectByVisibleText("BMW");
		
		Thread.sleep(2000);
		System.out.println("Print the list of all options");
		List<WebElement> options = sel.getOptions(); //getOptions will grab all options within that select dropdown
		int size = options.size();
		
		for(int i=0;i<size;i++) {
			String optionName = options.get(i).getText();
			System.out.println(optionName);
		}
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
