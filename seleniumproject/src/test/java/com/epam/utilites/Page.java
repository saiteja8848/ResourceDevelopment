package com.epam.utilites;

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

}
