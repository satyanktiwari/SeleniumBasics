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

public class GoogleTest {
	 WebDriver driver;

	    @BeforeTest
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
	        driver.get("https://www.google.com");       

	    }

	    @Test
	    public void googleTitleTest(){
	       Assert.assertEquals(driver.getTitle(), "Google");
	    }

	    @Test
	    public void googleSearchTest(){

	        driver.findElement(By.name("q")).sendKeys("Selenium");
	       Assert.assertTrue(true);
	    }
	    
	    @AfterTest
	    public void tearDown(){
	        driver.quit();
	    }

}
