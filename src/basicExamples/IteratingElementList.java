package basicExamples;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IteratingElementList {
	private WebDriver driver;
	private String baseUrl;
	DesiredCapabilities dc;

	@Before
	public void setUp() throws Exception {
		dc = DesiredCapabilities.firefox();
		dc.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rjtba\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void testListOfElements() throws Exception {
		boolean isChecked = false;
		//find all radio buttons with name attribute as cars
		List<WebElement> radioButtons = driver.findElements(
				By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));
		int size = radioButtons.size();
		System.out.println("Size of the list: " + size);
		//iterate through all radiobuttons
		for (int i=0; i<size; i++) {
			isChecked = radioButtons.get(i).isSelected();
			
			if (!isChecked) { //click if radio button isnt selected
				radioButtons.get(i).click();
				Thread.sleep(2000);
			}
		}
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
