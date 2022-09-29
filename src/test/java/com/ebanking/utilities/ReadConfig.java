package com.ebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	public ReadConfig() {
		
		File src = new File("E:\\PragatiWorkSpace\\eBankingMavenProject\\configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {

			System.err.println("file not found");
		}
	}
	
	public String getApplicationUrl() {
		String url = prop.getProperty("baseUrl");
		return url;
	}
	
	public String getUsername() {
		String userName = prop.getProperty("username");
		return userName;
	}
	
	public String getPassword() {
		String passWord = prop.getProperty("password");
		return passWord;
	}
}
