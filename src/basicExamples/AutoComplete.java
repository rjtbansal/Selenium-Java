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

public class AutoComplete {

	//this example partially types a city and selects the one based on target city from the list
	
	private WebDriver driver;
	private String base_url;
	
	@Before
	public void setup() throws Exception {
		base_url = "https://www.expedia.com/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjtba\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test_select_origin_from_list() throws Exception{
		driver.get(base_url);
		String city_keyword_partial = "New York";
		String city_to_be_found = "Newark, NJ";
		
		//enter origin city name in the textbox
		WebElement origin_city = driver.findElement(By.id("package-origin-hp-package"));
		origin_city.sendKeys(city_keyword_partial);
		
		WebElement results_list_menu = driver.findElement(By.id("typeaheadDataPlain"));
		//store keyword based results in a list
		List<WebElement> origin_city_list = results_list_menu.findElements(By.tagName("a"));
		System.out.println("City list:");
		//print out the list
		for(int i=0; i<origin_city_list.size();i++) {
			System.out.println(origin_city_list.get(i).getText());
		}
		Thread.sleep(3000);
		
		//search for specific city and click if found
		for(WebElement city : origin_city_list ) {
			if (city.getText().contains(city_to_be_found)) {
				System.out.println(city.getText());
				city.click();				
				break;
			}
		}
		
		
				
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
