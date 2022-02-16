package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

	

public class WebDriverWaitNonWebelement {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//initially when the page is loading it will give loading instead of the 
		// correct  title
//		wait.until(ExpectedConditions.titleContains("Amazon.com"));
//		System.out.println(driver.getTitle());
		System.out.println(doGetPageTitle("Amazon", 5));
		
	}
	
	public static boolean waitforPageTitle(String titleValue, int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.titleContains(titleValue));
		
	}
	
	public static String doGetPageTitle(String titleValue, int timeOut) {
		if(waitforPageTitle(titleValue, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}

}
