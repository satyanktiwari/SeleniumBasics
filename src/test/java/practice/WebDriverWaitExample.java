package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitExample {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email");
		By pwd = By.id("input-password");
		
		//don't use te striket out methods
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//this is the 9'th way of creating a webElement
//		WebElement email_ele = wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
//		email_ele.sendKeys("test@123.com");
//		driver.findElement(pwd).sendKeys("test123");
		
//		waitForElementPresence(emailId,10).sendKeys("testa@gmail.com");
//		getElement(pwd).sendKeys("test123");
		
		waitForElementVisible(emailId, 10).sendKeys("test@gmail.com");
		getElement(pwd).sendKeys("test123");
	
		
		
	}
	
	
	public static WebElement getElement(By locator) {
		//make the WebDriver Static to access it here
		return driver.findElement(locator);
	}

	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	public static WebElement waitForElementVisible(By loctor, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loctor));
	}
}
