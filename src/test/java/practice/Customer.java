package practice;

import org.testng.annotations.Test;

public class Customer {
	
	@Test(priority = 0)
	public void createCustomerTest() {
		System.out.println("Execute HDFC CreateCustomerTest");
	}
     
	@Test(priority = 2,dependsOnMethods = "createCustomerTest")
	public void modifyCustomerTest() {
		System.out.println("Execute Modify HDFC To ICICI CreateCustomerTest");
	}
	
	@Test(priority = 3,dependsOnMethods = "createCustomerTest")
	public void deleteCustomerTest() {
		System.out.println("Execute Delete ICICI CreateCustomerTest");
	}
}
