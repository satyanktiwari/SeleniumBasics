package practice;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import locators.OpenCrmLocatorsAndProperties;
import utils.ElelmentUtilities;

public class LocatorStratigies   {
	static WebDriver driver= null;

	public static void main(String[] args) {
		OpenCrmLocatorsAndProperties locators = new OpenCrmLocatorsAndProperties();
		
//		String browser ="chrome";
//		String url = "https://demo.opencart.com/index.php?route=account/login";
		String url = locators.getUrl();
//		WebDriver driver= null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		//1
//		driver.findElement(By.id("input-email"))
//		.sendKeys("test@test123.com");
//		driver.findElement(By.id("input-password"))
//		.sendKeys("test");
		
//		2
//		WebElement email_id = driver.findElement(By.id("input-email"));
//		WebElement pwd = driver.findElement(By.id("input-password"));
//		email_id.sendKeys("test@test123.com");
//		pwd.sendKeys("test");
		
//		3 Keep locator separate
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		WebElement email_id = driver.findElement(email);
//		WebElement pwd = driver.findElement(password);
//		email_id.sendKeys("test@test123.com");
//		pwd.sendKeys("test");
		
//	4 	By locator using generic method
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		getElement(email).sendKeys("test@test123.com");
//		getElement(password).sendKeys("test");
		
//		5 send keys generic method
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		doSendKeys(email, "test@test123.com");
//		doSendKeys(password, "test");
		
//	6 	Move methods to AutomationUtlities class
//		ElelmentUtilities ut = new ElelmentUtilities(driver);
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		ut.doSendKeys(email, "test@test123.com");
//		ut.doSendKeys(password, "test");
		
//		7
//		String e_id = "input-email";
//		String e_pwd = "input-password";
//		doSendKeys("id", e_id, "test@test123.com");
//		doSendKeys("id", e_pwd, "test123");
		
//		8
		ElelmentUtilities ut = new ElelmentUtilities(driver);
//		String e_id = "input-email";
//		String e_pwd = "input-password";
		String emailId = locators.getId_email();
		String emailPwd = locators.getId_email_pwd();
		ut.doSendKeys("id", emailId,"test@test123.com");
		ut.doSendKeys("id", emailPwd, "test123");
//		tearDown();
		
		
		
		
		
	}
//	public static WebElement getElement(By locator) {
//		return driver.findElement(locator);
//	}
//	
//	public static void doSendKeys(By locator, String value) {
//		getElement(locator).sendKeys(value);
//	}
	
//	public static By getBy(String locatortype, String locatorValue) {
//		
//		By locator = null;
//		
//		switch (locatortype) {
//		case "id":
//			locator  = By.id(locatorValue);
//			
//			break;
//
//		default:
//			System.out.println("Incorrect locatorType");
//			break;
//		}
//		
//		return locator;
//		
//	}
//	
//	Overloaded method of doSedKeys 
//	public static void doSendKeys(String locatortype, String locatorValue, String value ) {
//		getElement(getBy(locatortype, locatorValue)).sendKeys(value);
//	}
	
//	public static void tearDown() {
//		driver.quit();
//	}
	

}
