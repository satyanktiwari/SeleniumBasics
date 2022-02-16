package practice.testngConcepts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderConcept {
	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		return new Object[][] { { "test1@gmail.com", "abc123" }, { "test2@gmail.com", "abc123" },
				{ "test3@gmail.com", "abc123" }

		};
	}

	@Test(dataProvider = "loginData")
	public void loginTest(String username, String password) {
		Assert.assertTrue(doLogin(username, password));

	}

	public boolean doLogin(String username, String password) {
		System.out.println("User name: " + username);
		System.out.println("Password: " + password);
		System.out.println("Login Successful");
		return true;
	}

}
