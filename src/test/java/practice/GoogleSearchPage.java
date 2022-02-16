package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WdmBrowserUtility;

public class GoogleSearchPage {
	static WebDriver driver;
	public static void main(String[] args) {
		WdmBrowserUtility bu = new WdmBrowserUtility();
		String browser = "chrome";
		driver = bu.LaunchBrowser(browser);
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("naveen automation labs");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<WebElement> suggestionList = 
				driver.findElements(By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']/span"));
		System.out.println(suggestionList.size());
		
		for(WebElement e:suggestionList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals("naveen automationlabs paid course")) {
				e.click();
				break;
			}
			
		}
	}

}
