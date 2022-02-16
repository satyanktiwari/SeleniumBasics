package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElelmentUtilities;
import utils.WdmBrowserUtility;

public class SuggestionListGoogleSearchByFindElement {
	static WebDriver driver;
	public static void main(String[] args) {
		String browser = "chrome";
		String locatorType ="name";
		String locatorValue = "q";
		String value = "naveen auto";
		By suggestionValue = 
				By.xpath("//div[@role='option']//span[contains(.,'naveen automation labs youtube')]");
		
		WdmBrowserUtility bu =new  WdmBrowserUtility();
		driver = bu.LaunchBrowser(browser);
		bu.enter_url("https://www.google.co.in");
		ElelmentUtilities el = new ElelmentUtilities(driver);
		el.doSendKeys(locatorType, locatorValue, value);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		el.getElement(suggestionValue).click();
				
	
	}

}
