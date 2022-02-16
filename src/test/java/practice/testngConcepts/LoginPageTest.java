package practice.testngConcepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest {
	 @Test
	    public void loginTest(){
	        Assert.assertTrue(doLogin("test@gmail.com", "test123"));
	    }

	    public boolean doLogin(String username, String password){
	        System.out.println("User name: "+username);
	        System.out.println("Password: "+password);
	        System.out.println("Login Successful");
	        return true;
	    }
}
