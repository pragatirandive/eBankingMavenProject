package com.ebanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebanking.pageobjects.LoginPage;
import com.ebanking.utilities.XlUtils;

public class TC002_LoginDDT extends BaseClass {
	@Test(dataProvider = "LoginData")
	public void LoginDDT(String user , String pw) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(user);
		log.info("username provided");
		lp.setPassword(pw);
		log.info("password provided");

		Thread.sleep(3000);
		lp.clickSubmit();
		if(isAlertPresent()==true) {
			Thread.sleep(3000);

			driver.switchTo().alert().accept();  //close alert
			driver.switchTo().defaultContent();   //go to main page
			Assert.assertTrue(false);
			log.warn("Login failed");

		}
		else {
			Assert.assertTrue(true);
			log.info("login passed");

			lp.clickLogout();
			Thread.sleep(3000);

			driver.switchTo().alert().accept();   //close logout alert
			driver.switchTo().defaultContent();   // back to login page
			
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String path = "E:/PragatiWorkSpace/eBankingMavenProject/src/test/java/com/ebanking/testdata/ebankingData.xlsx";
		int rowCount = XlUtils.getRowCount(path, "Sheet1");
		int cellCount = XlUtils.getCellCount(path, "Sheet1", 1);

		String loginData[][] = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				loginData[i - 1][j] = XlUtils.getCellData(path, "Sheet1", i, j);
			}
		}

		return loginData;
	}

}
