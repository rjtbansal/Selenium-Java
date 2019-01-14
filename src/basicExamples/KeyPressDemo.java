package basicExamples;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyPressDemo {

	private WebDriver driver;
	private String base_url;
	
	@Before
	public void setUp() throws Exception {
		base_url = "https://letskodeit.teachable.com/p/practice";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjtba\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testKeyPress() throws Exception {
		driver.get(base_url);
		driver.findElement(By.xpath("//a[contains(@href,'sign_in')]")).click();
		
		WebElement user_email_field = driver.findElement(By.id("user_email"));
		//enter email address
		user_email_field.sendKeys("test@gmail.com");
		Thread.sleep(2000);
		//press Tab to move to password field
		user_email_field.sendKeys(Keys.TAB);
		
		WebElement user_password_field = driver.findElement(By.id("user_password"));
		//enter password
		user_password_field.sendKeys("abcd");
		//press enter key
		driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
