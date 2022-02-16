package opencarttests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Pages.OpenCartLoginPage;
import factory.DriverFactory;

public class BaseTest {
	WebDriver driver;
	DriverFactory driverFactory;
	OpenCartLoginPage loginPage;
	Properties prop;
	
	
	@BeforeTest
	public void setup() {
		driverFactory = new DriverFactory();
		prop = driverFactory.init_properties();
		driver = driverFactory.init_driver(prop);
		loginPage = new OpenCartLoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
