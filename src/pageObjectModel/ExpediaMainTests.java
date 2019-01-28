package pageObjectModel;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageclasses.HotelsTabFactory;
import pageclasses.FlightsTab;

//expedia website main tests go here
public class ExpediaMainTests {

	private WebDriver driver;
	private String base_url;
	HotelsTabFactory hotelsTab;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjtba\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		base_url = "https://www.expedia.com";
		
		
		driver.get(base_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		//close banner
//		WebElement remove_banner_button = FlightsTab.removeTopBannerButton(driver);
//		if(remove_banner_button.isDisplayed()) {
//			remove_banner_button.click();
//		}
		
		
	}
	
	@Test
	public void testFlightSearch() throws Exception {
		FlightsTab.clickFlightsTab(driver);
		FlightsTab.clickRoundTripTab(driver);
		FlightsTab.inputFlyingFromField(driver, "New York");
		FlightsTab.inputFlyingToField(driver, "Toronto");
		FlightsTab.inputDepartingDateField(driver, "28/01/2019");
		FlightsTab.returningDateField(driver).clear();
		//FlightsTab.inputReturningDateField(driver, "11/01/2019");
		FlightsTab.returningDateField(driver).sendKeys("31/01/2019");
		FlightsTab.clickSearchButton(driver);
		Thread.sleep(2000);
	}
	
	@Test
	public void testHotelSearch() throws Exception {
		hotelsTab = new HotelsTabFactory(driver);
		hotelsTab.clickHotelsTab();
		hotelsTab.enterDestination("Toronto");
		hotelsTab.enterCheckInDate("02/12/2019");
		hotelsTab.enterCheckoutDate("02/15/2019");
		hotelsTab.clickSearchButton();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
