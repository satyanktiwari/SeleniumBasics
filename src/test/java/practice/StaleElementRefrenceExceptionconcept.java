package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefrenceExceptionconcept {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//DOM-->v1
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//Element created in the version 1 of the DOM - /DOM-->v1
		WebElement ele = driver.findElement(By.id("Form_submitForm_subdomain"));
		ele.sendKeys("test");
		driver.navigate().refresh();
		//back and forward also refreshes page
		
		//This created the version 2 of the DOM
//		ele.sendKeys("test2");//StaleElementException
		
		//DOM-->v2
		//To solve this reinitialize the element
		WebElement ele_v2 = driver.findElement(By.id("Form_submitForm_subdomain"));
		ele_v2.sendKeys("test2");
	}
}
