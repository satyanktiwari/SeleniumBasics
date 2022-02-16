package opencarttests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Constants;

public class LoginPageTest extends BaseTest {
	
	@Test
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title : " + title);
		Assert.assertTrue(title.contains(Constants.LOGIN_PAGE_TITLE));
	}
	
	@Test
	public void loginPageUrlTest() {
		String url = loginPage.getLoginPageUrl();
		System.out.println("Url is: "+ url);
//		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}

}
