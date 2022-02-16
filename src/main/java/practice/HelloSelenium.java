package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {

	public static void main(String[] args) {
		/*
		 * Windows
		 * include the .exe in path
		 */
	
		System.setProperty("WebDriver.chrome.driver", 
				"D:\\Satyank\\Automation\\EclipseWorkspace\\practice\\chromedriver.exe");
		/*
		 * Refrence varaible of type granparent pointing
		 * to child object
		 * Top casting - option 2 from diagram
		 *  in training
		 */
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("Title is: "+ title);
		
		if (title.equals("Google")) {
			System.out.println("Correct title");
		} else {
			System.out.println("Incorrect title");
		}
		
		driver.close();

	}

}
