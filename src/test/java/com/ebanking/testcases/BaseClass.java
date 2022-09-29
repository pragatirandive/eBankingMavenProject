package com.ebanking.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ebanking.utilities.ReadConfig;

public class BaseClass {

	 static ReadConfig readconfig = new ReadConfig();
	
	public static String url = readconfig.getApplicationUrl();
	public static String username = readconfig.getUsername();
	public static String password = readconfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger log;

    @Parameters("browser")
	@BeforeClass
    public  void setUp(@Optional("Chrome") String br) {
    	
        log = Logger.getLogger("eBankingMavenProject");
		//PropertyConfigurator.configure("log4j.properties"); 
    	
    	if(br.equals("Chrome")) {

		System.setProperty("webdriver.chrome.driver","E:\\PragatiWorkSpace\\eBankingMavenProject\\drivers\\chromedriver.exe");
		   driver = new ChromeDriver();
    	}
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
  
	}
    
    public static String timeUtils() {
		   
		   Date date = new Date();
		   SimpleDateFormat format = new SimpleDateFormat("_ddmmyyyyhhmmss");
		   String datevalue = format.format(date);
		   return datevalue;
	   }

    public static void captureScreenshot(WebDriver driver ,String name) throws IOException {
    	TakesScreenshot ts =  (TakesScreenshot) driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	File dest = new File("E:\\PragatiWorkSpace\\eBankingMavenProject\\screenshots\\failedLoginTest_"+timeUtils()+".png");
    	FileUtils.copyFile(source, dest);
    	System.out.println("screenshot captured ");
    }
    
	@AfterClass
	public  void tearDown() {
		
		driver.close();
   }

}
