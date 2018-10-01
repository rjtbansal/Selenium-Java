package basicweb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PageNavigation {

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
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		String title = driver.getTitle();  //get title of current page
		System.out.println("Title of page: " + title);
		
		String current_url = driver.getCurrentUrl();  //self-explanatory
		System.out.println("Current URL: " + current_url);
		
		String url_to_navigate = "https://sso.teachable.com/secure/42299/users/sign_in?reset_purchase_session=1";
		driver.navigate().to(url_to_navigate);  //navigate to the given url
		System.out.println("Navigating to login page");
		current_url = driver.getCurrentUrl();
		System.out.println("Current URL: " + current_url);
		
		Thread.sleep(2000);
		
		driver.navigate().back();  //navigate to previous url/page
		System.out.println("Navigate to previous url");
		current_url = driver.getCurrentUrl();
		System.out.println("Current URL: " + current_url);
		
		Thread.sleep(2000);
		
		driver.navigate().forward(); //go to forward url
		System.out.println("Navigate Forward");
		current_url = driver.getCurrentUrl();
		System.out.println("Current URL: " + current_url);
		
		Thread.sleep(2000);
		
		driver.navigate().back();	
		System.out.println("Navigate to previous url");
		current_url = driver.getCurrentUrl();
		System.out.println("Current URL: " + current_url);
		
		driver.navigate().refresh();   //refresh page
		System.out.println("Navigate Refresh");
		driver.get(current_url);
		System.out.println("Navigate Refresh");
		
		String pageSource = driver.getPageSource();    //get html
		System.out.println(pageSource);
		
				
	}
}
