package googlePages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageObjcet {
	WebDriver driver = null;

	public SearchPageObjcet(WebDriver driver) {
		this.driver = driver;
	}
	
	By search_txt_box=By.name("q");
//	This is giving error
//	WebElement search_field = driver.findElement(search_txt_box);
	
	public void enter_search_text(String text) {
		driver.findElement(search_txt_box)
		.sendKeys(text);
	}
	
	public void send_enter_key() {
		driver.findElement(search_txt_box)
		.sendKeys(Keys.RETURN);
	}
	
}
