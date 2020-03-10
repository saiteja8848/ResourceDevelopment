package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.epam.utilites.Page;

public class StaysPage extends Page {

	private By cityNameWebElement = By.xpath("//input[@id=\"ss\"]");
	private By dateSearchBox=By.xpath("//span[@class=\"sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb\"]");
	private By searchWebElement = By.xpath("//button[@type=\"submit\"]");
	private String url = "http://booking.com";
	

	public StaysPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void openPage() {
		openPage(url);
	}

	public void setCityName(String cityName) {
		findElement(cityNameWebElement);
		sendKeys(cityName);
	}

	public void setDate(String checkInDate,String checkOutDate) {
		findElement(dateSearchBox);click();
		 By checkInDateXPath = By.xpath("//td[@data-date=\""+ checkInDate +"\"]");
		 By checkOutDateXPath = By.xpath("//td[@data-date=\""+ checkOutDate +"\"]");
		findElement(checkInDateXPath);click();
		findElement(checkOutDateXPath);click();
		
	}
	
	public void search() {
		findElement(searchWebElement);
		click();
	}

}
