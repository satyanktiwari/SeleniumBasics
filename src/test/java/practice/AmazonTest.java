package practice;

import utils.BrowserUtility;

public class AmazonTest {

	public static void main(String[] args) {
		String browser = "chrome";
		BrowserUtility br = new BrowserUtility();
		br.init_browswer(browser);
		br.enter_url("https://www.amazon.in/");
		String title = br.getPageTitle();
		System.out.println("Title is: "+ title);
		String pageUrl = br.getPageUrl();
		System.out.println("Current Url for the page is \n"+ pageUrl);
		br.quitBrowser();

	}

}
