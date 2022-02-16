package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElelmentUtilities {
	private WebDriver driver;

	/**
	 * This will take the driver from the browser utility
	 * 
	 * @param driver
	 */
	public ElelmentUtilities(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Method returns a WebElement.</br>
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * doSendKeys Method takes following parameters</br>
	 * With a By type locator</br>
	 * For String type locator use the overloaded method.
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

//	moved as part of 8
	public By getBy(String locatortype, String locatorValue) {

		By locator = null;

		switch (locatortype.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;

		case "cssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			break;

		default:
//			System.out.println("Incorrect locatorType");
			try {
				throw new Exception("Incorrect locatorType");
			} catch (Exception e) {
				System.out.println("Invalid locator type");
//				e.printStackTrace();
			}
			break;
		}

		return locator;

	}

	/**
	 * Overloaded method of the doSendKeys method above</br>
	 * Takes input as String DataType
	 * 
	 * @param locatortype
	 * @param locatorValue
	 * @param value
	 */
	public void doSendKeys(String locatortype, String locatorValue, String value) {
		getElement(getBy(locatortype, locatorValue)).sendKeys(value);
	}
	
	

	/**
	 * Method to get an attribute using By type locator
	 * 
	 * @param locator
	 * @param attrName
	 * @return
	 */
	public String doGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	/**
	 * Overloaded method for doGetAttribute which takes String locators
	 * 
	 * @param locatorType
	 * @param locatorvalue
	 * @param attrName
	 * @return
	 */
	public String doGetAttribute(String locatorType, String locatorvalue, String attrName) {
		return getElement(getBy(locatorType, locatorvalue)).getAttribute(attrName);
	}

	/**
	 * Method to get text
	 * 
	 * @param locator
	 * @return
	 */
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	

	/**
	 * OVerloaded method to get text using String type locators
	 * 
	 * @param locatorType
	 * @param locatorValue
	 * @return
	 */

	public String doGetText(String locatorType, String locatorValue) {
		return getElement(getBy(locatorType, locatorValue)).getText();
	}
	
	

	/**
	 * Method to perform click on a element</br>
	 * use getElelment method internally</br>
	 * Which in turn uses the getBy method with String params
	 * 
	 * @param locatorType
	 * @param locatorValue
	 */
	public void doClick(String locatorType, String locatorValue) {
		getElement(getBy(locatorType, locatorType)).click();

	}
	
	

	/*******************************methods for findElements ***************************/

	/**
	 * Returns List of WebElelments
	 * 
	 * @param Locator
	 * @return WebElelment
	 */
	public List<WebElement> getElelements(By Locator) {
		return driver.findElements(Locator);
	}
	

	/**
	 * Returns count of elements
	 * 
	 * @param locator
	 * @return Count of elements
	 */
	public int getElementsCount(By locator) {
		return driver.findElements(locator).size();
	}
	
	

	/**
	 * Print method to print each value of elelment within a list
	 * 
	 * @param locator
	 */
	public void printElementsText(By locator) {
		List<WebElement> elList = getElelements(locator);
		for (WebElement e : elList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				System.out.println(text);
			}
		}

	}
	

	/**
	 * Returns a list of String text for elements</br>
	 * Will return non-empty text
	 * 
	 * @param loctor
	 * @return elementTextList
	 */

	public List<String> getElementsTextList(By loctor) {
		List<WebElement> elementList = getElelements(loctor);
		List<String> elementTextList = new ArrayList<String>();
		for (WebElement e : elementList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				elementTextList.add(text);
			}

		}
		return elementTextList;
	}

	public List<String> getElementsAttributeList(By locator, String attributeName) {
		List<WebElement> elementList = getElelements(locator);
		List<String> elementsAttributeList = new ArrayList<String>();
		for (WebElement e : elementList) {
			String attributeValue = e.getAttribute(attributeName);
			elementsAttributeList.add(attributeValue);

		}
		return elementsAttributeList;
	}

	public void printElementsAttributList(By locator, String attributeName) {
		List<String> elementsAttributeList = getElementsAttributeList(locator, attributeName);
		elementsAttributeList.forEach(System.out::println);
		/*
		 * stringList.forEach(System.out::println); // 1) Iterable.forEach
		 * stringList.stream().forEach(System.out::println); // 2) Stream.forEach (order
		 * maintained generally but doc does not guarantee)
		 * stringList.stream().forEachOrdered(System.out::println); // 3)
		 * Stream.forEachOrdered (order maintained always)
		 * stringList.parallelStream().forEach(System.out::println); // 4) Parallel
		 * version of Stream.forEach (order not maintained)
		 * stringList.parallelStream().forEachOrdered(System.out::println); // 5)
		 * Parallel version ofStream.forEachOrdered (order maintained always)
		 */

	}

	/****************** Wait Utils ******************/
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param loctor
	 * @param timeout
	 * @return
	 */

	public WebElement waitForElementVisible(By loctor, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loctor));
	}

	// ----Non WebElement
	/**
	 * An expectation for checking that the title contains a case-sensitive
	 * substring
	 * 
	 * @param titleValue
	 * @param timeOut
	 * @return
	 */
	public boolean waitforPageTitle(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(titleValue));
	}

	/**
	 * An expectation for checking the title of a page.
	 * 
	 * @param actualTitle
	 * @param timeOut
	 * @return
	 */
	public boolean waitforPageActualTitle(String actualTitle, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(actualTitle));
	}

	/**
	 * An expectation for checking that the title contains a case-sensitive
	 * substring and returning the Title
	 * 
	 * @param titleValue
	 * @param timeOut
	 * @return
	 */
	public String doGetPageTitleContains(String titleValue, int timeOut) {
		if (waitforPageTitle(titleValue, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}

	/**
	 * An expectation for checking the title of a page and returning the Title
	 * 
	 * @param titleValue
	 * @param timeOut
	 * @return
	 */
	public String doGetPageTitleIs(String titleValue, int timeOut) {
		if (waitforPageActualTitle(titleValue, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}

	/**
	 * An expectation for the URL of the current page to contain specific text.
	 * 
	 * @param urlFraction
	 * @param timeOut
	 * @return
	 */
	public String waitForUrlContains(String urlFraction, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
		return null;
	}

	/**
	 * Wait for a alert
	 * 
	 * @param timeOut
	 * @return
	 */

	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * Get text from a JS alert
	 * 
	 * @param timeOut
	 * @return
	 */

	public String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}

	/**
	 * Accept the alert
	 * 
	 * @param timeOut
	 */
	public void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}

	/**
	 * Cancel the alert
	 * 
	 * @param timeOut
	 */

	public void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}

	public WebDriver waitForFrameIndex(int timeOut, int FrameIndex) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FrameIndex));

	}

	public WebDriver waitForFrameByLocator(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));

	}

	public WebDriver waitForFrameByElement(int timeOut, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	/********************************* Wait for Elements **********************/
//	Visibility
	/**
	 * An expectation for checking that all elements present on the web page that
	 * match the locator are visible. Visibility means that the elements are not
	 * only displayed but also have a height and width that is greater than 0.
	 * 
	 * @param timeOut
	 * @param locator
	 * @return
	 */
	public List<WebElement> waitForElementVisible(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}
//	Presence

	/**
	 * An expectation for checking that there is at least one element present on a
	 * web page.
	 * 
	 * @param timeout
	 * @param locator
	 * @return
	 */
	public List<WebElement> waitforElementPresence(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	/**
	 * An expectation for checking an element is visible and enabled such that you
	 * can click it.
	 * 
	 * @param timeOut
	 * @param locator
	 * @return
	 */
	public WebElement clickWhenReady(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

//WithTimeout is compulsory others are not mandatory
	/**
	 * 
	 * @param locator
	 * @param timeOut
	 * @param pollingTime
	 * @return
	 */
	public WebElement waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage(locator + " is not found within the given time");
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	/**
	 * 
	 * @param locator
	 * @param timeOut
	 * @param pollingTime
	 * @return
	 */
	public WebElement waitForElementPresenceWithWebDriverWait(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage(locator + " is not found within the given time");
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
