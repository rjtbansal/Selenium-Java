package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//locators and methods for flights tab on expedia website
public class FlightsTab {

	public static WebElement element = null;
	
	public static WebElement removeTopBannerButton(WebDriver driver) {
		return driver.findElement(By.id("join-rewards-close-btn"));
	}
	
	//flights tab locator
	public static WebElement flightsTab(WebDriver driver) {
		
		element = driver.findElement(By.id("tab-flight-tab-hp"));
		return element;
	}
	
	public static void clickFlightsTab(WebDriver driver) {
		element = flightsTab(driver);
		element.click();
	}
	
	//round-trip sub tab
	public static WebElement roundTripTab(WebDriver driver) {
		element = driver.findElement(By.id("flight-type-roundtrip-label-hp-flight"));
		return element;
	}
	
	public static void clickRoundTripTab(WebDriver driver) {
		element = roundTripTab(driver);
		element.click();
	}
	
	//flying from field
	public static WebElement flyingFromField(WebDriver driver) {
		return driver.findElement(By.id("flight-origin-hp-flight"));
	}
	
	public static void inputFlyingFromField(WebDriver driver, String flying_from_airport) throws InterruptedException {
		element = flyingFromField(driver);
		element.sendKeys(flying_from_airport);
		WebElement dropdown_airport_list_menu = driver.findElement(By.id("typeaheadDataPlain"));
		List<WebElement> airport_list = dropdown_airport_list_menu.findElements(By.tagName("a"));
		for(WebElement airport : airport_list) {
			if(airport.getAttribute("data-value").contains("JFK-John F. Kennedy")) {
				airport.click();
				break;
			}
		}
		Thread.sleep(3000);
	}
	
	//flying to field
	public static WebElement flyingToField(WebDriver driver) {
		return driver.findElement(By.id("flight-destination-hp-flight"));
	}
	
	public static void inputFlyingToField(WebDriver driver, String flying_to_airport) throws InterruptedException {
		element = flyingToField(driver);
		element.sendKeys(flying_to_airport);
		WebElement dropdown_airport_list_menu = driver.findElement(By.id("typeaheadDataPlain"));
		List<WebElement> airport_list = dropdown_airport_list_menu.findElements(By.tagName("a"));
		for(WebElement airport : airport_list) {
			if(airport.getAttribute("data-value").contains("YYZ-Pearson Int")) {
				airport.click();
				break;
			}
		}
		Thread.sleep(3000);
	}
	
	//departing field
	public static WebElement departingDateField(WebDriver driver) {
		return driver.findElement(By.id("flight-departing-hp-flight"));
	}
	
	public static void inputDepartingDateField(WebDriver driver, String departing_date) {
		element = departingDateField(driver);
		element.sendKeys(departing_date);
	}
	
	//returning field
	public static WebElement returningDateField(WebDriver driver) {
		return driver.findElement(By.id("flight-returning-hp-flight"));
	}
	
	public static void inputReturningDateField(WebDriver driver, String return_date) {
		element = returningDateField(driver);
		element.sendKeys(return_date);
	}
	
	//search button
	public static WebElement searchButton(WebDriver driver) {
		return driver.findElement(By.xpath("//form[@id='gcw-flights-form-hp-flight']//button[@type='submit']//span"));
	}
	
	public static void clickSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
	}
	
	
	
	
	
}
