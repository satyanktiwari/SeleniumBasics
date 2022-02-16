package practice.testngConcepts;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	 @Test(expectedExceptions = {ArithmeticException.class,NullPointerException.class})
	    public void loginTest(){
	        System.out.println("Login Test");
	        int i=9/0;
	    }
	    
	    @Test(dependsOnMethods = "loginTest")
	    public void homeTest(){
	        System.out.println("Home Test");
	    }

	    @Test(dependsOnMethods = "loginTest")
	    public void searchTest(){
	        System.out.println("Search Test");
	    }
}
