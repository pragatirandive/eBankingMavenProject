package com.ebanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.pageobjects.AddCustomer;
import com.ebanking.pageobjects.LoginPage;

public class TC003_AddCustomer extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		log.info("username provided");

		lp.setPassword(password);
		log.info("password provided");

		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomer addcust = new AddCustomer(driver);
		addcust.addNewCustomer();
		log.info("providing customer details ....");

		Thread.sleep(1000);
		
		addcust.custName("pragati");
		Thread.sleep(1000);

		addcust.custGender();
		Thread.sleep(1000);

		addcust.custdob("16","09","2022");
		Thread.sleep(1000);

		addcust.custAddress("nagar");
		Thread.sleep(1000);

		addcust.custCity("Pune");
		Thread.sleep(1000);

		addcust.custState("Mharashtra");
		Thread.sleep(1000);

		addcust.custPin("414101");
		Thread.sleep(1000);

		addcust.custTeleno("9975380259");
		Thread.sleep(1000);

		addcust.custEmail("pragati@gmail.com");
		Thread.sleep(1000);
		addcust.clickSubmit();
		log.info("validtion is started...");

		Thread.sleep(3000);

		Boolean res = driver.getPageSource().contains("Connection failed: Access denied for user 'root'@'localhost' (using password: NO)");
		if (res==true) {
			Assert.assertTrue(true);
			log.info("testcase passed ");

		}
		else {
			captureScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
			log.info("testcase is failed ");


		}
	}
}
