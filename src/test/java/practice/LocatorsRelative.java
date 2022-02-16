package practice;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsRelative {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/india");
		WebElement ele = driver.findElement(By.linkText("New-Delhi, India"));
		
		
		/*
		 * How to read
		 * toRightOf(ele) There is a tag name p
		 * Find it with tag name p
		 * and get its text
		 */
		String index = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(index);
		
		String rank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(rank);
		
		String belowCity = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(belowCity);
		
		String aboveCity = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(aboveCity);
		
		//15 pixels of radius then it will pick
		//nearest p if you see in DOM then the text is for new-delhi 
		String nearCity = driver.findElement(with(By.tagName("p")).near(ele)).getText();
		System.out.println(nearCity);
		
		//example on how to use findElements with relative locators
		List <WebElement> aboveList = driver.findElements(with(By.tagName("p")).above(ele));
		for(WebElement e:aboveList) {
			System.out.println(e.getText());
		}
		
		
	}

}
