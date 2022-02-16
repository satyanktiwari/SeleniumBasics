package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrame {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(2));
//		waitForFrameIndex(5, 2);//1
		By frameLocator = By.name("main");
		waitForFrameByLocator(5, frameLocator);
		String header = driver.findElement(By.xpath("html/body/h2")).getText();
		System.out.println(header);
		

	}
	
	public static WebDriver waitForFrameIndex(int timeOut, int FrameIndex) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FrameIndex));
		
	}
	
	public static WebDriver waitForFrameByLocator(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		
	}
	
	public static WebDriver waitForFrameByElement(int timeOut, WebElement element ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	

}
