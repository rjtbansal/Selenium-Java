package testNgPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersAndParallel {
	
  String base_url;
  WebDriver driver;
  
  @BeforeClass
  @Parameters({"browser"})
  public void setUp(String browser) {
	  if(browser.equalsIgnoreCase("chrome")) {
		  System.out.println("Browser received: "+browser);
		  System.out.println("Inside Chrome");
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjtba\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }
	  else {
		  System.out.println("Browser received: "+browser);
		  System.out.println("Inside Firefox");
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\rjtba\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
	  }
	  
	  base_url="https://letskodeit.teachable.com";
	  driver.get(base_url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test
  public void testLogin() throws InterruptedException {
	  
	  WebElement login_link = driver.findElement(By.linkText("Login"));
	  login_link.click();
	  
	  WebElement email_field = driver.findElement(By.id("user_email"));
	  email_field.sendKeys("abc@gmail.com");
	  
	  WebElement password_field = driver.findElement(By.id("user_password"));
	  password_field.sendKeys("testtest");
	  
	  WebElement login_button = driver.findElement(By.name("commit"));
	  login_button.click();
	  
	  String invalid_credentials_text = driver.findElement(By.xpath("//div[contains(text(),'Invalid email or password')]")).getText();
	  System.out.println("Invalid credentials text: " + invalid_credentials_text);
	  
	  Assert.assertTrue(invalid_credentials_text.contains("Invalid email or password"));
  }
  
  @AfterClass
  public void cleanUp() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
  }
}
