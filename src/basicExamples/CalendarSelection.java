package basicExamples;

import java.util.List;
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
	//this test selects a date which is hardcoded	
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
	
	@Test
	public void test2() throws Exception {
		//test for valid dates and click on 31st
		
		driver.get(base_url);
		//click flights tab
		WebElement flights_tab = driver.findElement(By.id("tab-flight-tab-hp"));
		flights_tab.click();
		//find departing field
		WebElement departing_field = driver.findElement(By.id("flight-departing-hp-flight"));
		departing_field.click();
		List<WebElement> days_of_a_month = driver.findElements(By.xpath("//div[contains(@class,'datepicker-cal-month')][position()=2]//button[@data-day]"));
		
		for(WebElement day: days_of_a_month) {
			if (day.getText().equals("27")) {
				day.click();
				break;
			}
		}
		
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
