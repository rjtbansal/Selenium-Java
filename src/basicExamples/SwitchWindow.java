package basicExamples;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {

		//concept of window handles and switching to different windows/tabs
	private WebDriver driver;
	private String base_url;
	
	@Before
	public void setUp() throws Exception {
		
		base_url = "http://letskodeit.teachable.com/pages/practice";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjtba\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void test() throws Exception {
		
		driver.get(base_url);
		//get handle
		String parent_handle = driver.getWindowHandle();
		System.out.println("Current Handle: " + parent_handle);
		
		//look for open window button and click
		WebElement open_window_button = driver.findElement(By.id("openwindow"));
		open_window_button.click();
		
		//a new window will open above and now we get all handles
		Set<String> handles = driver.getWindowHandles();
		
		//Switch between handles
		for(String handle : handles) {
			System.out.println("Now iterating through Handle: " + handle);
			//if handle isnt equal to parent handles means its the newly opened window 
			if (!handle.equals(parent_handle)) {
				
				//switch to new handle
				driver.switchTo().window(handle);
				Thread.sleep(2000);
				//search for search box and enter some text
				WebElement search_box = driver.findElement(By.id("search-courses"));
				search_box.sendKeys("javascript");
				Thread.sleep(2000);
				driver.close();
				break;
			}
		}
		
		//switch to original window
		driver.switchTo().window(parent_handle);
		//look for name input text box and enter a text to ensure we have indeed switched to original window
		driver.findElement(By.id("name")).sendKeys("Test suceeded");
		Thread.sleep(2000);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
