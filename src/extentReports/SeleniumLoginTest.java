package extentReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class SeleniumLoginTest {
	
  private WebDriver driver;
  private String baseUrl;
  ExtentReports report;
  ExtentTest test;
  
  @BeforeClass
  public void setUp() {
	baseUrl = "https://letskodeit.teachable.com/";
	//folder path where report file will be saved
	//initializing extent report and providing the path to the file
	report = new ExtentReports("C:\\Users\\rjtba\\Documents\\extent_reports\\logintest.html");
	//provides toggle to start the test using which logs are generated. this is a mandatory step
	test = report.startTest("Verify Welcome Test");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjtba\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	//logging info
	test.log(LogStatus.INFO, "Browser opened and maximized");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(baseUrl);
	//verify page title
	
	String page_title = driver.getTitle();
	test.log(LogStatus.INFO, "Verifying page title after login");
	Assert.assertTrue(page_title.contains("Let's Kode It"));
	//logging test as passed
	test.log(LogStatus.PASS, "Verified page title after login");
  }
  
  @Test
  public void test_login() {
	  WebElement login_link = driver.findElement(By.linkText("Login"));
	  login_link.click();
	  test.log(LogStatus.INFO, "Clicked Login link");
	  
	  WebElement email_address = driver.findElement(By.id("user_email"));
	  email_address.sendKeys("test@email.com");
	  test.log(LogStatus.INFO, "Entered email");
	  
	  WebElement password = driver.findElement(By.id("user_password"));
	  password.sendKeys("abcabc");
	  test.log(LogStatus.INFO, "Entered password");
	  
	  WebElement login_button = driver.findElement(By.name("commit"));
	  login_button.click();
	  
	  String loggedin_url = driver.getCurrentUrl();
	  Assert.assertTrue(loggedin_url.contains("learn.letskodeit"));
	  test.log(LogStatus.PASS, "Verified url");
  }
  
  @AfterClass
  public void cleanUp() {
	  driver.quit();
	  report.endTest(test);
	  report.flush();
  }
}
