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

public class MultipleSelect {

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
	public void testMultiSelect() throws Exception{
		WebElement element = driver.findElement(By.id("multiple-select-example"));
		Select sel = new Select(element);
		
		Thread.sleep(2000);
		System.out.println("Select orange by value");
		sel.selectByValue("orange");
		
		Thread.sleep(2000);
		System.out.println("De-select orange by value");
		sel.deselectByValue("orange");
		
		Thread.sleep(2000);
		System.out.println("Select peach by index");
		sel.selectByIndex(2);
		
		Thread.sleep(2000);
		System.out.println("Select Apple by visible text");
		sel.selectByVisibleText("Apple");

		Thread.sleep(2000);
		System.out.println("Print all selected options");
		List<WebElement> selectedOptions = sel.getAllSelectedOptions();
		for(WebElement option : selectedOptions) {
			System.out.println(option.getText());
		}
		
		Thread.sleep(2000);
		System.out.println("De-select all selected options");
		sel.deselectAll();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
	
		

