package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import googlePages.SearchPageObjcet;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestGoogleSearchPage {
	WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	private void testGoogleSearchPage() {
		SearchPageObjcet spo = new SearchPageObjcet(driver);
		driver.get("https://www.google.com");
		spo.enter_search_text("YouTube+Kalimoh");
		spo.send_enter_key();
	}
	
	@AfterTest
	private void tearDown() {
		driver.close();

	}
}
