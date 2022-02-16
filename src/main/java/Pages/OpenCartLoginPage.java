package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Constants;
import utils.ElelmentUtilities;
import utils.ElementUtils;

public class OpenCartLoginPage {

	private WebDriver driver;
	ElementUtils ele;
	
	By username_txt = By.id("input-email");
	By password_txt = By.id("input-password");
	By forgotPassword_link = By.linkText("Forgotten Password");
	By login_btnk = By.xpath("//input[@type='submit' and @value='Login']");
	
	
	public OpenCartLoginPage(WebDriver driver) {
		this.driver = driver;
		ele = new ElementUtils(driver);
		
	}
	
	//get title
	
	public String getLoginPageTitle() {
		return ele.doGetPageTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_INT_TIMEOUT);
	}
	
	//get url
	
	public String getLoginPageUrl() {
		return ele.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_INT_TIMEOUT);
	}
	
	//is forgortpassword link available
	
	//send keys to username and password
	
	
}
