package com.epam.testcontroller;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.epam.utilites.ReadConfigProperties;

public class TestController {

	private ReadConfigProperties readUtilites;
	private String ConfigurationFilePath;
	protected WebDriver webDriver;

	@BeforeClass
	public void setUp() throws IOException {
		ConfigurationFilePath = "src/test/resources/properties/config.properties";
		readUtilites = new ReadConfigProperties(ConfigurationFilePath);
		webDriver = readUtilites.getBrowser();

	}

	@AfterClass
	public void tearDown() {
		webDriver.quit();
	}

}
