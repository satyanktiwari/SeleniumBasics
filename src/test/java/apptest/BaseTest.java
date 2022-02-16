package apptest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * All common code needs to be moved here </br>
 * Browser / Url are parameterized using the testng.xml</br>
 * Tests which extend this class are run using the xml file</br>
 *
 */
public class BaseTest {
	
	WebDriver driver;

	@Parameters({"browser","url"})
    @BeforeTest
    
    public void setUp(String browserName, String url, String timeout){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }

        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(Integer.parseInt(timeout))));//use wrapper class
        driver.get(url);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
