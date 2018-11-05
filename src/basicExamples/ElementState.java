package basicExamples;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ElementState {

	WebDriver driver;
	String baseUrl;
	DesiredCapabilities dc;

	@Before
	public void setUp() throws Exception {
		dc = DesiredCapabilities.firefox();
		dc.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rjtba\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		baseUrl = "https://www.southwest.com/";		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	public void test() {
		//choose one way radio button
		driver.findElement(By.id("trip-type-one-way")).click();
		//check if return date is enabled
		WebElement e1 = driver.findElement(By.id("air-date-return"));
		System.out.println("Is Return Date field enabled?: " + e1.isEnabled());
		
		//choose Round Trip radiobutton
		driver.findElement(By.id("trip-type-round-trip")).click();
		//now check again if return date is enabled
		System.out.println("Is Return Date field enabled?: " + e1.isEnabled());
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
}
