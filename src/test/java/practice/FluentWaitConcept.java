package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email");
		By pwd = By.id("input-password");

		/*
		 * Here we can use Topcasting Refrence variable of parent interface points to
		 * the child class object
		 */
		// use the builder pattern to write the methods
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
//				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class)
//				.ignoring(StaleElementReferenceException.class);
//		WebElement email_ele = wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
//		email_ele.sendKeys("test@mail.com");
		
		
		//use the fluent wait
			waitForElementPresenceWithFluentWait(emailId, 10, 2).sendKeys("test@gmail.com");
			driver.findElement(pwd).sendKeys("test");
		
		//use the webDriverWait - this also works
//		waitForElementPresenceWithWebDriverWait(emailId, 5, 1).sendKeys("test@gmail.com");
//		driver.findElement(pwd).sendKeys("test");

	}

	//This works the same way as fluent
	public static WebElement waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait <WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage(locator+" is not found within the given time");
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	
	public static WebElement waitForElementPresenceWithWebDriverWait(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(pollingTime))
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.withMessage(locator+" is not found within the given time");
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
