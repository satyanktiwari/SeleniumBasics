package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefrenceExceptionconceptUsingByLocator {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();

		// DOM-->v1
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		By userName = By.id("Form_submitForm_subdomain");
		doSendKeys(userName, "test123");
		driver.navigate().refresh();
		doSendKeys(userName, "email@123");
		
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String text) {
		getElement(locator).sendKeys(text);
		
	}

}
