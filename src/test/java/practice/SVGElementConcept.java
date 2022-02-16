package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		
		String svgPath =
				"//*[local-name()='svg']//*[name()='g' and @id='features']/*[name()='g' and @id='states']/*[name()='g']/*[name()='path']";
		
		List <WebElement> graphList = driver.findElements(By.xpath(svgPath));
		System.out.println("There are "+graphList.size()+" states");
		
		Actions act = new Actions(driver) ;
		
		for(WebElement e:graphList) {
			act.moveToElement(e).perform();
			Thread.sleep(1000);
			String nameAttr  = e.getAttribute("name");
			System.out.println(nameAttr );
			if(nameAttr.equals("Colorado")) {
				act.click(e).perform();
				break;
			}
			
		}
		Thread.sleep(10000);
		String stateSvgPath = "//*[local-name()='svg']//*[name()='g' and @id='features']/*[name()='g' and @id='states']/*[name()='g']/*[name()='g']/*[name()='path']";
		List <WebElement> stateGraphList = driver.findElements(By.xpath(stateSvgPath));
		System.out.println("No. of counties is: "+stateGraphList.size());
		
		for(WebElement el:stateGraphList) {
			act.moveToElement(el).perform();
			Thread.sleep(1000);
			//this is not working need to figure out where the names are coming from
//			String countyName = e.getAttribute("name");
			String countyName = el.getText();
								System.out.println(countyName);
//			
			
		}
		
		
		
	}

}
