package apptest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTestExtendsBaseTest extends BaseTest{
	
	   

	  
    @Test(priority = 1)
    public void googleTitleTest(){
        // driver.get("https://www.google.com");  
       Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test(priority = 2, enabled = false)
    public void googleSearchTest(){

        driver.findElement(By.name("q")).sendKeys("Selenium");
       Assert.assertTrue(true);
    }
    


}
