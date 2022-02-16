package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class will use the WebDriverManager to manage the browser drivers
 */
public class WdmBrowserUtility {
	private WebDriver driver;
	
	/**
	 * Method to pass the browser and instantiate the browser
	 * @param browser
	 * @return driver
	 */
	
	public WebDriver LaunchBrowser(String browser) {
		System.out.println("Browser is: "+ browser);
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Value passed as browser is not Valid");
			break;
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
