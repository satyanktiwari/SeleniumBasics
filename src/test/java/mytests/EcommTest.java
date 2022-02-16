package mytests;

import org.testng.annotations.Test;

public class EcommTest {
	@Test(priority =1)
	public void loginTest() {
		//any test method name method name should end with word test
		System.out.println("loginTest");
	}
	@Test(priority =2)
	public void homeTest() {
		//any test method name method name should end with word test
		System.out.println("homeTest");
	}
	@Test(priority =0)
	public void priceTest() {
		//any test method name method name should end with word test
		System.out.println("priceTest");
	}
	@Test(priority =4)
	public void cartTest() {
		//any test method name method name should end with word test
		System.out.println("cartTest");
	}
	@Test(priority =5)
	public void searchTest() {
		//any test method name method name should end with word test
		System.out.println("searchTest");
	}
	@Test
	public void m1Test() {
		//any test method name method name should end with word test
		System.out.println("searchTest");
	}
	@Test
	public void m2Test() {
		//any test method name method name should end with word test
		System.out.println("searchTest");
	}
	
	
	

}
