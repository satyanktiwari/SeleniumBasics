
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitImplicitExample {
	public static void main(String[]args) {
		//Implicitly wait
		//Dynamic wait
		//Its only applicable for WebElements
			//Not applicable for alerts, title, url etc
		//Global wait
			//Once defined is applicable throughout
			//Applicable for all upcoming elements
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Below is deprecated now in Slenium4 so should not be used
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Use the one with Duration class
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//10 sec wait at least
		WebElement email = driver.findElement(By.id("input-email"));//NoSuchElementException when element not located
		email.sendKeys("test@gmail.com");
		
		//10 sec wait at least - since pwd and email are in the same form then 
		//no need to wait for 10 seconds for pwd
		//override t 5 sec wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement pwd = driver.findElement(By.id("input-password"));
		pwd.sendKeys("test123");
		// now for all the element there will be 5 sec wait
		
		//e3 -5
		//e4 -5
		
		//Home page - 20 sec override
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//H1 -20
		//H2 -20
		
		//Reg page - 0 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		//Re1 -0
		//Re2 -0
		
		
		//Once applied will be available to all upcoming WebElements
		//Should not be used, only used for practice
		
		
		
		
		
		
	}

}
