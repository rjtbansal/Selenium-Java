package basicExamples;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverActions {

	private WebDriver driver;
	private String base_url;
	private JavascriptExecutor jse;
	//example for mouse hover action
	@Before
	public void setUp() throws Exception{
		base_url = "https://letskodeit.teachable.com/pages/practice";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjtba\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//cast driver to JavascriptExecutor
		jse = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void mouse_hover_test() throws Exception {
		driver.get(base_url);
		//javascriptexecutor's executeScript method runs javasript functions
		//below we are scrolling window
		jse.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		
		WebElement main_element = driver.findElement(By.id("mousehover"));
		
		Actions action = new Actions(driver);
		//hovering over main_element using .perform()
		action.moveToElement(main_element).perform();
		Thread.sleep(2000);
		
		WebElement sub_element = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
		//hovering and clicking the element 
		action.moveToElement(sub_element).click().perform();	
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
