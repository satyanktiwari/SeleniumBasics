package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDown {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		//select html tag <select>
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
//		WebElement country_ele = driver.findElement(country);
//		WebElement state_ele = driver.findElement(state);
//		
//		//Create object of the Select class from selenium
//		Select select = new Select(country_ele);
//		
//		//1. use index
//		select.selectByIndex(4);
//		//2. use the value attribute
//		select.selectByValue("Australia");
//		//3. use the visible text
//		select.selectByVisibleText("India");
//		Thread.sleep(2000);
//		
//		//Create another object for state because one object is pointing to one drop down
//		Select selectState =  new Select(state_ele);
//		selectState.selectByVisibleText("Karnataka");
		
		doSelectDropDownByText(country, "India");
		Thread.sleep(2000);
		doSelectDropDownByText(state, "Karnataka");
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropDownByIndex(By locator, int index) {
		Select select =new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectDropDownByText(By locator, String text) {
		Select select =new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public static void doSelectDropDownByValue(By locator, String value) {
		Select select =new Select(getElement(locator));
		select.selectByValue(value);
	}
}
