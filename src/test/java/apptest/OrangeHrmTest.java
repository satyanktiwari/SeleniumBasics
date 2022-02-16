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

public class OrangeHrmTest {
	WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
        
    }

    @Test
    public void orangeHrmTitleTest() {
        Assert.assertEquals(driver.getTitle(), "Sign Up for a Free HR Software Trial | OrangeHRM");
    }
    @Test
    public void orangeHRmLogoTest(){
        Assert.assertTrue(driver.findElement(By.cssSelector("a img.nav-logo")).isDisplayed());
      }

      @AfterTest
        public void tearDown(){
            driver.quit();
        }
}
