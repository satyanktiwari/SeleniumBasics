package apptest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHrmTestExtendsBaseTest extends BaseTest {


    @Test
    public void orangeHrmTitleTest() {
        Assert.assertEquals(driver.getTitle(), "Sign Up for a Free HR Software Trial | OrangeHRM");
    }
    @Test
    public void orangeHRmLogoTest(){
        Assert.assertTrue(driver.findElement(By.cssSelector("a img.nav-logo")).isDisplayed());
      }

}
