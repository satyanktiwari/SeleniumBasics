package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElelments {
	static WebDriver driver;

	public static void main(String[] args) {
		//'org.openqa.selenium.TimeoutException' is thrown with NoSuchElementException when element is not found.
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com");
		By footers = By.cssSelector("ul.footer-nav>li>a");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		List<WebElement> footerList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footers));
		
		List<WebElement> footerList = waitForElementVisible(5, footers);
		
		System.out.println("Number of links are: "+footerList.size());
		for (WebElement e : footerList) {
			String footerText = e.getText();
			System.out.println(footerText);
		}
	}

	/**
	 * An expectation for checking that all elements present on the web page that
	 * match the locator are visible. Visibility means that the elements are not
	 * only displayed but also have a height and width that is greater than 0.
	 * 
	 * @param timeOut
	 * @param locator
	 * @return
	 */
	public static List<WebElement> waitForElementVisible(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	/**
	 * An expectation for checking that there is at least one element present on a
	 * web page.
	 * 
	 * @param timeout
	 * @param locator
	 * @return
	 */
	public static List<WebElement> waitforElementPresence(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}
}
