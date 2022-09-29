package com.ebanking.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	public static WebDriver ldriver;

	public AddCustomer(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public void addNewCustomer() {
		WebElement newcust = ldriver.findElement(By.linkText("New Customer"));
		newcust.click();
	}

	public void custName(String cname) {
		WebElement name = ldriver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(cname);
	}

	public void custGender() {
		WebElement cgender = ldriver.findElement(By.xpath("(//input[@name='rad1'])[2]"));
		cgender.click();
	}

	public void custdob(String dd, String mm, String yyyy) {
		WebElement dob = ldriver.findElement(By.xpath("//input[@name='dob']"));
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yyyy);
	}
	public void custAddress(String address) {
		WebElement cadd = ldriver.findElement(By.xpath("//textarea[@name='addr']"));
		cadd.sendKeys(address);
	} 
	public void custCity(String city) {
		WebElement custcity = ldriver.findElement(By.xpath("//input[@name='city']"));
		custcity.sendKeys(city);
	}
	public void custState(String state) {
		WebElement custstate = ldriver.findElement(By.xpath("//input[@name='state']"));
		custstate.sendKeys(state);
	}
	public void custPin(String pin) {
		WebElement custpin = ldriver.findElement(By.xpath("//input[@name='pinno']"));
		custpin.sendKeys(pin);
	}
	public void custTeleno(String teleno) {
		WebElement custteleno = ldriver.findElement(By.xpath("//input[@name='telephoneno']"));
		custteleno.sendKeys(teleno);
	}
	public void custEmail(String email) {
		WebElement custemail = ldriver.findElement(By.xpath("//input[@name='emailid']"));
		custemail.sendKeys(email);
	}
	public void clickSubmit() {
		WebElement submit = ldriver.findElement(By.xpath("//input[@type='submit']"));
		submit.click();
	}

	}
