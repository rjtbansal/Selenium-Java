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

public class DragAndDropActions {
	//example to perform drag and drop
	private WebDriver driver;
	private String base_url;
	
	@Before
	public void setUp() throws Exception {
		base_url = "https://jqueryui.com/droppable/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjtba\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testDragAndDrop() throws Exception {
		driver.get(base_url);
		
		//switch to the iframe where element to be selected is present
		driver.switchTo().frame(0);
		
		WebElement from_element = driver.findElement(By.id("draggable"));
		WebElement to_element = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		
		//drag and drop - 1 way 
//		action.dragAndDrop(from_element, to_element).build().perform();
//		Thread.sleep(3000);
		
		//drag and drop - 2nd way : click -> hold -> move (drag) -> release
		action.clickAndHold(from_element).moveToElement(to_element).release().build().perform();
		Thread.sleep(3000);
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	
}
