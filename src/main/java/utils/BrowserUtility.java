package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility {
	
	private WebDriver driver;
	
/**
 * Method to pass the browser and instantiate the browser
 * @param browser
 * @return driver
 */
	
	public WebDriver init_browswer(String browser) {
		System.out.println("Your have passed broswer name: "+ browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("WebDriver.chrome.driver",
					"D:\\Satyank\\Automation\\EclipseWorkspace\\practice\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("WebDriver.gecko.driver", 
					"D:\\Satyank\\Automation\\EclipseWorkspace\\practice\\geckoriver.exe");
			driver = new FirefoxDriver();
			
		}
		else {
			System.out.println("Value passed as browser is not Valid");
		}
		
		
		return driver;
	}
	
	/**
	 * Method to get url as input
	 * Verifies if the url contains http or https
	 * if not will throw an exception
	 * @param url
	 */
	public void enter_url(String url) {
		System.out.println("You've entered url: "+ url);
		if(url.contains("http")||url.contains("https")) {
			driver.get(url);
			
		}else {
			try {
			throw new Exception ("URL is missing http or https");
			} catch (Exception e) {}
		}
	}
	
	/**
	 * Method returns title of the page
	 * @return title
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	/**
	 * Method returns url
	 * @return URL
	 */
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	/**
	 * Method to quit the browser
	 */
	public void quitBrowser() {
		driver.quit();
	}
	
	/**
	 * Method to close browser
	 */
	public void closeBrowser() {
		driver.close();
	}
}
