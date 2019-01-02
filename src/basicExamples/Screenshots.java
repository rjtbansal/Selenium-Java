package basicExamples;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//takes screenshot of the page and saves it as a file
public class Screenshots {
	
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
	public void testScreenshot() throws Exception {
		driver.get(base_url);
		
		//click flights tab
		WebElement flights_tab = driver.findElement(By.id("tab-flight-tab-hp"));
		flights_tab.click();
		
		//id Flying From field flight-origin-hp-flight
		WebElement flying_from_field = driver.findElement(By.id("flight-origin-hp-flight"));
		
		
		//id Flying To Field : flight-destination-hp-flight
		WebElement flying_to_field = driver.findElement(By.id("flight-destination-hp-flight"));		
		
		
		//id Departing Date FIeld: flight-departing-hp-flight
		WebElement departing_date_field = driver.findElement(By.id("flight-departing-hp-flight"));
		
		
		//id Returning Field: flight-returning-hp-flight
		WebElement returning_date_field = driver.findElement(By.id("flight-returning-hp-flight"));
		
		flying_from_field.sendKeys("New York");
		flying_to_field.sendKeys("San Jose");
		departing_date_field.sendKeys("02/06/2019");
		returning_date_field.sendKeys("06/06/2019");
		Thread.sleep(3000);
			
	}
	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	@After
	public void tearDown() throws Exception {
		
		String filename = getRandomString(10) + "_screenshot.png";
		String save_to_directory = "C:\\Users\\rjtba\\Downloads\\";
		
		//screenshot taking
		File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source_file, new File(save_to_directory + filename));
		driver.quit();
		
	}
	
	
	

}
