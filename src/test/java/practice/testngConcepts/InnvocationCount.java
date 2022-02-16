package practice.testngConcepts;

import org.testng.annotations.Test;

public class InnvocationCount {
	@Test(invocationCount = 5)
    public void test1() {
        System.out.println("Test 1");
    }
}
