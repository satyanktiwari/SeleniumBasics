package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefrenceExceptionconceptUsingList {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();

		// DOM-->v1
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		List <WebElement> footerList = 
				driver.findElements(By.xpath("(//ul[@class='list-unstyled'])[8]//a"));
		
		for(int i=0; i<footerList.size();i++) {
			footerList.get(i).click();
			Thread.sleep(2000);
			footerList = driver.findElements(By.xpath("(//ul[@class='list-unstyled'])[8]//a"));
			
			
		}
		
		System.out.println("Script Completed");

	}

}
