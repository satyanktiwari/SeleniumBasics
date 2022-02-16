package practice;

import utils.WdmBrowserUtility;

public class AmazonTestWithWdm {

	public static void main(String[] args) {
		String browser = "FireFox";
		WdmBrowserUtility bu =new WdmBrowserUtility();
		bu.LaunchBrowser(browser);
		bu.enter_url("https://www.amazon.in/");
		String title = bu.getPageTitle();
		System.out.println("Title of the page is: "+ title);
		String url = bu.getPageUrl();
		System.out.println("Current url is: "+ url);
		bu.quitBrowser();

	}

}
