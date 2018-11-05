package basicExamples;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasicActions {
	
    WebDriver driver;
	String baseUrl;
	DesiredCapabilities dc;

	@Before
	public void setUp() throws Exception {
		dc = DesiredCapabilities.firefox();
		dc.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rjtba\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://letskodeit.teachable.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Executing the teardown in the end");
	}

	@Test
	public void test() {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("user_email")).sendKeys("*****");
		driver.findElement(By.id("user_password")).sendKeys("*****");
		driver.findElement(By.id("user_email")).clear();
		System.out.println("Clearing the username field");
	}

}
