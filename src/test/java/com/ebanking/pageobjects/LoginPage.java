package com.ebanking.pageobjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

/*	@FindBy(name = "uid")
	WebElement txtUserName;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	WebElement loginBtn;
	*/
	
	public  void setUsername(String uname) {
		
		WebElement txtUserName = ldriver.findElement(By.name("uid"));
		txtUserName.sendKeys(uname);
	}
	
	public  void setPassword(String password) {

		WebElement txtPassword = ldriver.findElement(By.name("password"));
		txtPassword.sendKeys(password);
	}
	
	public  void clickSubmit() {
		
		WebElement loginBtn = ldriver.findElement(By.name("btnLogin"));
		loginBtn.click();
	}
	
	public static void clickLogout() {
		
		WebElement logoutBtn = ldriver.findElement(By.linkText("Log out"));
		logoutBtn.click();
	}
}
