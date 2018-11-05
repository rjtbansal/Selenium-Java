package userfulmethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author rjtba
 *A generic class containing methods to find any type of element
 */
public class GenericMethods {
	
	WebDriver driver;
	
	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	//below method used in GenericMethodsDemo class
	public WebElement getElement(String locator, String type) {
		/*
		 * Method will look for locators based on type
		 * 
		 * Inputs:
		 * | locator | element locator to be found
		 * | type	| type of locator : xpath, id, cssSelector, linkText, partialLinkText
		 */
		
		
		if(type.equals("id")) {
			System.out.println("Element found with id: "+locator);
			return this.driver.findElement(By.id(locator));
		}	
		else if(type.equals("xpath")) {
			System.out.println("Element found with xpath: " + locator);
			return this.driver.findElement(By.xpath(locator));
		}
		else if(type.equals("css")) {
			System.out.println(("Element found with css: " + locator));
			return this.driver.findElement(By.cssSelector(locator));
		}
		else if(type.equals("linkText")) {
			System.out.println("Element found with link text: "+ locator);
			return this.driver.findElement(By.linkText(locator));
		}
		else if(type.equals("partialLinkText")) {
			System.out.println("Element found with partial link text: "+ locator);
			return this.driver.findElement(By.partialLinkText(locator));
		}
		else {
			System.out.println("Locator type: " + type + " not supported");
			return null;
		}		
		
	}
	
	//below method is useful when we want to find multiple elements matching a locator
	public List<WebElement> getElementList(String locator, String type) {
		
		if(type.equals("id")) {
			System.out.println("Elements found with id: " + locator);
			return this.driver.findElements(By.id(locator));
		}
		else if(type.equals("xpath")) {
			System.out.println("Element found with xpath: " + locator);
			return this.driver.findElements(By.xpath(locator));
		}
		else if(type.equals("css")) {
			System.out.println(("Element found with css: " + locator));
			return this.driver.findElements(By.cssSelector(locator));
		}
		else if(type.equals("linkText")) {
			System.out.println("Element found with link text: "+ locator);
			return this.driver.findElements(By.linkText(locator));
		}
		else if(type.equals("partialLinkText")) {
			System.out.println("Element found with partial link text: "+ locator);
			return this.driver.findElements(By.partialLinkText(locator));
		}
		else {
			System.out.println("Locator type: " + type + " not supported");
			return null;
		}		
	}

}
