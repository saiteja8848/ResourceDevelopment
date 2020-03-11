package com.epam.utilites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {
	private WebDriver webDriver;
	private WebElement webElement;

	public Page(WebDriver webDriver) {
		this.webDriver=webDriver;
	}
	
	public void openPage(String url) {
		webDriver.get(url);
	}
	
	public void findElement(By selector) {
		webElement = webDriver.findElement(selector);
	}

	public void sendKeys(String value) {
		webElement.sendKeys(value);
	}

	public void click() {
		webElement.click();
	}

	public void clear() {
		webElement.clear();
	}

	public void implicitWait(long time) {
		webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.MILLISECONDS);
	}
	
	public WebDriver getDriver() {
		return webDriver;
	}
	
	
	public void closePage() {
		webDriver.close();
	}
	
}
