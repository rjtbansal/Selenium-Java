package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsTabFactory {
	
	//using Page Object Factory model for Hotels tab
	
	WebDriver driver;
	
	@FindBy(id="tab-hotel-tab-hp")
	WebElement hotels_tab;
	
	@FindBy(id="hotel-destination-hp-hotel")
	WebElement destination;
	
	@FindBy(id="hotel-checkin-hp-hotel")
	WebElement check_in_date;
	
	@FindBy(id="hotel-checkout-hp-hotel")
	WebElement check_out_date;
	
	@FindBy(xpath="//div[@id='traveler-selector-hp-hotel']//button[@data-gcw-component='gcw-traveler-amount-select']")
	WebElement travelers_button;
	
	@FindBy(xpath="//form[@id=\"gcw-hotel-form-hp-hotel\"]//button[@data-gcw-change-submit-text=\"Search\"]/span[text()=\"Search\"]")
	WebElement search_button;
	
	@FindBy(id="hotel-add-flight-checkbox-hp-hotel")
	WebElement add_flight_checkbox;
	
	@FindBy(id="hotel-add-car-checkbox-hp-hotel")
	WebElement add_car_checkbox;
	
	@FindBy(id="hotel-flight-origin-hp-hotel")
	WebElement flying_from_input_field;
	
	public void clickHotelsTab() {
		hotels_tab.click();
	}
	
	public void enterDestination(String partial_destination) {
		destination.sendKeys(partial_destination);
		
		WebElement destination_dropdown_list = driver.findElement(By.id("typeaheadDataPlain"));
		List<WebElement> airport_list = destination_dropdown_list.findElements(By.tagName("a"));
		for(WebElement airport : airport_list) {
			if(airport.getAttribute("data-value").contains("YYZ-Pearson Int")) {
				airport.click();
				break;
			}
		}
	}
	
	public void enterCheckInDate(String date) {
		check_in_date.sendKeys(date);
		
	}
	
	public void enterCheckoutDate(String date) {
		check_out_date.clear();
		check_out_date.sendKeys(date);
	}
	
	public void clickSearchButton() {
		search_button.click();
	}
	
	public HotelsTabFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //initializes all above elements defined above
	}
	
}
