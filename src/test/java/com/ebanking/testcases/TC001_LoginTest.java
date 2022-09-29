package com.ebanking.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ebanking.pageobjects.LoginPage;

public class TC001_LoginTest extends BaseClass {
	
	@Test
	public static void loginTest() throws IOException {
		
		log.info("user navigates to homepage");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		log.info("user entered usernsme");

		lp.setPassword(password);
		log.info("user entered password");

		lp.clickSubmit();

		System.out.println("PageTitle : "+driver.getTitle());
		
		if (driver.getTitle().equals("GTPL Bank Manager HomePage")) {

			System.out.println("user navigates to homepage");
			log.info("login test passed");
		} else {
			captureScreenshot(driver ,"loginTest");
			System.out.println("user not navigates to homepage");
			log.info("login test failed");

		}
	}

	
}
