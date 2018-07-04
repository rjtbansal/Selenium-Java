package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTestClass {

	public static void main(String[] args) {
		
		String baseUrl = "http://www.google.com";
		WebDriver driver;
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjtba\\Downloads\\chromedriver_win32\\chromedriver.exe"); //not needed if Environment Variables are set
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.quit();

	}

}
