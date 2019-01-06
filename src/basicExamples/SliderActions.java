package basicExamples;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderActions {

	private WebDriver driver;
	private String base_url;
	
	@Before
	public void setUp() throws Exception {
		base_url = "https://jqueryui.com/slider/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjtba\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testSliderActions() throws Exception {
		driver.get(base_url);
		driver.switchTo().frame(0);
		
		// Using the actions class
		WebElement element = driver.findElement(By.xpath("//div[@id='slider']/span"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, 100, 0).perform();
		Thread.sleep(3000);		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	
	
	
}
