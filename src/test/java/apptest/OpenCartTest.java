package apptest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCartTest {
	 WebDriver driver;

	    @BeforeTest
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://demo.opencart.com/index.php?route=account/login");

	    }
	    
	    @Test
	    public void openCartTitleTest(){
	        Assert.assertEquals(driver.getTitle(), "Account Login");
	    }

	    @Test
	    public void openCartHeaderTest(){
	        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='New Customer']")).isDisplayed());
	    }

	    @AfterTest
	    public void tearDown(){
	        driver.quit();
	    }
}
