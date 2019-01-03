package basicExamples;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchAlert {

	//example for alert popup as well as confirm popup
	
	private WebDriver driver;
	private String base_url;
	
	@Before
	public void setup() throws Exception {
		base_url = "http://letskodeit.teachable.com/pages/practice";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjtba\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test1() throws InterruptedException {
		driver.get(base_url);
		driver.findElement(By.id("name")).sendKeys("Rajat");
		//click on alert
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		//switch to alert
		Alert alert = driver.switchTo().alert();
		//accept the alert
		alert.accept();
		Thread.sleep(2000);
		
		driver.findElement(By.id("name")).sendKeys("Rajat");
		//click confirm
		driver.findElement(By.id("confirmbtn")).click();
		alert = driver.switchTo().alert();
		//alert.accept();
		alert.dismiss();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}
