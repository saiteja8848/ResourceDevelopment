package com.epam.utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadConfigProperties {

	private Properties properties;
	private FileInputStream fileInputStream;
	private String driverType;
	private String driverPath;

	public ReadConfigProperties(String configurationFile) throws IOException {
		fileInputStream = new FileInputStream(configurationFile);
		properties = new Properties();
		properties.load(fileInputStream);
		driverType = properties.getProperty("driverType");
		driverPath = properties.getProperty("driverPath");
	}

	public WebDriver getBrowser() {
		return BrowserFactory.getDriver(driverType, driverPath);
	}

}

class BrowserFactory {

	public static WebDriver getDriver(String driverType, String driverPath) {

		switch (driverType) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", driverPath);
			return new FirefoxDriver();
		case "ie":
			System.setProperty("webdriver.ie.driver",driverPath);
			return  new InternetExplorerDriver();
		default:
			System.setProperty("webdriver.chrome.driver", driverPath);
			return new ChromeDriver();

		}

	}

}