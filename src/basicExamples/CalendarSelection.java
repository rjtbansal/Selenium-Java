package basicExamples;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarSelection {
	
	private WebDriver driver;
	private String base_url;
	
	@Before
	public void setup() throws Exception {
		//expedia website
		base_url = "https://www.expedia.com/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjtba\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test1() throws Exception {
		
		driver.get(base_url);
		
		//click flights tab
		WebElement flights_tab = driver.findElement(By.id("tab-flight-tab-hp"));
		flights_tab.click();
		//find departing field
		WebElement departing_field = driver.findElement(By.id("flight-departing-hp-flight"));
		departing_field.click();
		WebElement select_date_from_dropdown = driver.findElement(By.xpath("//div[contains(@class,\"datepicker-cal-month\")][position()=2]//button[@data-day=9]"));
		select_date_from_dropdown.click();
		Thread.sleep(3000);
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
