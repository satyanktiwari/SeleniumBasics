package practice.testngConcepts;

import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * 
 * 
 * This demonstrates the use of annotation in testng unit testing frameowork </br>
 * Also one can identify the sequence in which these are run by executing the script</br>
 *
 */

public class AppTest {
	 @BeforeClass
	    public void beforeClass() {
	        System.out.println("Before Class");
	    }

	    @BeforeTest
	    public void beforeTest() {
	        System.out.println("Before Test");
	    }

	    @BeforeSuite
	    public void beforeSuite() {
	        System.out.println("Before Suite");
	    }

	    @BeforeMethod
	    public void beforeMethod() {
	        System.out.println("Before Method");
	    }

	    @Test
	    public void test1() {
	        System.out.println("Test 1");
	    }
	    
	    @Test
	    public void test2() {
	        System.out.println("Test 2");
	    }
	    @AfterMethod
	    public void afterMethod() {
	        System.out.println("After Method");
	    }

	    @AfterSuite
	    public void afterSuite() {
	        System.out.println("After Suite");
	    }

	    @AfterTest    
	    public void afterTest(){
	        System.out.println("After Test");
	    }

	    @AfterClass

	    public void afterClass(){
	        System.out.println("After Class");
	    }

	    

	    
}
