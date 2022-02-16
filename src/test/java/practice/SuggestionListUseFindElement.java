package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ElelmentUtilities;
import utils.WdmBrowserUtility;

public class SuggestionListUseFindElement {
	static WebDriver driver;

	public static void main(String[] args) {
		String browser = "chrome";
//		to generalize add the suggestion string as a separate text
		String suggestion = "Casual Dresses > Printed";
//		add the string suggestion to the below locator
//		see how the single quotes are maintained and suggestion added within double quotes
		String xpathForDress = 
				"//div[@class='ac_results']//li[contains(text(),'"+suggestion+"')]";
		String url = "http://automationpractice.com/index.php";
		WdmBrowserUtility bu = new WdmBrowserUtility();
		driver = bu.LaunchBrowser(browser);
		bu.enter_url(url);
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		ElelmentUtilities util = new ElelmentUtilities(driver);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		driver.findElement(By.xpath(xpathForDress)).click();
		selectSuggestion(suggestion);
		

		
	}
//	Best way to generalize the code and keep the simplicity by passing only suggestion string
	public static void selectSuggestion(String suggestion) {
		WebElement el = 
				driver.findElement(By.xpath("//div[@class='ac_results']//li[contains(text(),'"+suggestion+"')]"));
				el.click();
	}
	
}
