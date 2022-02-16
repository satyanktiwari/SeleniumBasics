package apptest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTestExtendsBaseTest extends BaseTest {

	    @Test
	    public void openCartTitleTest(){
	        Assert.assertEquals(driver.getTitle(), "Account Login");
	    }

	    @Test
	    public void openCartHeaderTest(){
	        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='New Customer']")).isDisplayed());
	    }

	 
}
