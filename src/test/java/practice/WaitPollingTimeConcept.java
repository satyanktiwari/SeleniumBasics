package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitPollingTimeConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		/*
		 * To test how polling works
		 * give an incorrect ID - FOLLOWING EXCEPTION IS GIVEN
		 * Exception in thread "main" org.openqa.selenium.TimeoutException: Expected condition failed:
		 *  waiting for visibility of element located by By.id: input-emailD (tried for 10 second(s) with 2000 milliseconds interval)
		 */
		
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-emailD");
		By pwd = By.id("input-password");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		Default polling is 0.5s
//		wait.pollingEvery(Duration.ofSeconds(2));
		WebElement email_ele = 
				wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));
		
		email_ele.sendKeys("test@gmail.com");

	}

}
