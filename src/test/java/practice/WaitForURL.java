package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForURL {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.findElement(By.linkText("Register")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		if(wait.until(ExpectedConditions.urlContains("account/register"))) {
//			System.out.println(driver.getCurrentUrl());
//		}

		String Url = waitForUrlContains("account/register", 5);
		System.out.println(Url);
	}
	
	public static String waitForUrlContains(String urlFraction, int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if(wait.until(ExpectedConditions.urlContains("account/register"))) {
			return driver.getCurrentUrl();
		}return null;
	}

}
