package practice;

import org.openqa.selenium.WebDriver;

import locators.OpenCrmLocatorsAndProperties;
import utils.ElelmentUtilities;
import utils.WdmBrowserUtility;

public class locatorTypes {
	 static WebDriver driver;
	
	public static void main(String[] args) {
		OpenCrmLocatorsAndProperties locators = new OpenCrmLocatorsAndProperties();
		WdmBrowserUtility br = new WdmBrowserUtility();
		
		String browser = "chrome";
		String url = locators.getUrl();
//		use id
//		String id_email = locators.getId_email();
//		String id_emailPwd = locators.getId_email_pwd();
		
//		use name
		String name_email = locators.getName_email();
		String name_emailPwd = locators.getName_email_pwd();
		
		String email_value = "test@test123.com";
		String emailPwdValue= "test123";
		
		driver = br.LaunchBrowser(browser );
		ElelmentUtilities au = new ElelmentUtilities(driver);
		br.enter_url(url);
//		id
//		au.doSendKeys("id", id_email, email_value);
//		au.doSendKeys("id", id_emailPwd, emailPwdValue);
		
//		use name
		au.doSendKeys("name", name_email, email_value);
		au.doSendKeys("name", name_emailPwd, emailPwdValue);
		
		String text = au.doGetText("tagname", "h2");
		System.out.println("Text is: \n"+text);
		
		String textInEmailField = au.doGetAttribute("name", name_email, "value");
		System.out.println("Text entered in email is: "+textInEmailField);
		
//		 driver.close();
		
	}

}
