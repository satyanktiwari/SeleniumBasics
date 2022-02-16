package practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WdmBrowserUtility;

public class TestToUseFindElementsMethod {
	static WebDriver driver;
	public static void main(String[] args) {
		String browser = "chrome";
		WdmBrowserUtility bu = new WdmBrowserUtility();
		driver = bu.LaunchBrowser(browser);
		bu.enter_url("https://www.amazon.com");
//		List<WebElement> linkList = driver.findElements(By.tagName("a"));
//		System.out.println("Total anchor tags: "+linkList.size());
		
//		
		
//		counter is used to print the position 
//		int counter = 0;
//		for(WebElement link:linkList) {
//			String text = link.getText();
//			if (!text.isEmpty()) {
//				System.out.println(counter + ":"+text);
//			}
//			counter++;
//		}
		
//		Now the test can be mofied to use generic methods
		
		By links = By.tagName("a");
		System.out.println("Number of links is: "+getElementsCount(links));
		
		By images = By.tagName("img");
		System.out.println("Number of images is: "+getElementsCount(images));
		
		if(getElementsTextList(links).contains("Registry")) {
			System.out.println("Registry is present");
		}
		
		System.out.println(getElementsAttributeList(images, "src"));
		
		//this is not required but created for practice
		printElementsAttributList(images, "src");

	}
	
	
	
	public static List<WebElement> getElelements(By Locator) {
		return driver.findElements(Locator);
	}
	
	public static int getElementsCount(By locator) {
		return driver.findElements(locator).size();
	}
	
	public static void printElementsText(By locator) {
		List<WebElement> elList = getElelements(locator);
		for(WebElement e: elList) {
			String text = e.getText();
			if(!text.isEmpty()) {
				System.out.println(text);
			}
		}
		
	}
	/**
	 * Returns a list of String text for elements</br>
	 * Will return non-empty text
	 * @param loctor
	 * @return elementTextList
	 */
	
	public static List<String> getElementsTextList(By loctor) {
		List <WebElement> elementList = getElelements(loctor);
		List <String> elementTextList = new ArrayList<String>();
		for (WebElement e: elementList) {
			String text = e.getText();
			if(!text.isEmpty()) {
				elementTextList.add(text);
			}
			
		}
		return elementTextList;
	}
	
	public static List<String> getElementsAttributeList(By locator, String attributeName) {
		List <WebElement> elementList = getElelements(locator);
		List<String> elementsAttributeList = new ArrayList<String>();
		for (WebElement e: elementList) {
			String attributeValue = e.getAttribute(attributeName);
			elementsAttributeList.add(attributeValue);
			
		}
		return elementsAttributeList;
	}
	
	public static void printElementsAttributList(By locator, String attributeName) {
		List <String> elementsAttributeList = getElementsAttributeList(locator, attributeName);
		elementsAttributeList.forEach(System.out::println);
		/*
		 *  stringList.forEach(System.out::println);                            // 1) Iterable.forEach
			stringList.stream().forEach(System.out::println);                   // 2) Stream.forEach (order maintained generally but doc does not guarantee)
			stringList.stream().forEachOrdered(System.out::println);            // 3) Stream.forEachOrdered (order maintained always)
			stringList.parallelStream().forEach(System.out::println);           // 4) Parallel version of Stream.forEach (order not maintained)
			stringList.parallelStream().forEachOrdered(System.out::println);    // 5) Parallel version ofStream.forEachOrdered (order maintained always)
		 */
		
		
	}

}
