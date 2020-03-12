package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.epam.utilites.Page;

public class StaysPage extends Page {

	private By cityNameWebElement = By.xpath("//input[@id=\"ss\"]");
	private By dateSearchBox = By.xpath("//span[@class=\"sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb\"]");
	private By personSearchBox = By.xpath("//span[@class=\"xp__guests__count\"]");
	private By searchWebElement = By.xpath("//button[@type=\"submit\"]");
	private String url = "http://booking.com";

	public StaysPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void openPage() {
		System.out.println("OPENING THIS PAGE!!!!!!!!!!!!!!!!!!!!!");
		openPage(url);
	}

	public void setData(String cityName, String checkInDate, String checkOutDate, int adultsCount,int childrenCount,int roomCount) {
		setCityName(cityName);
		setDate(checkInDate, checkOutDate);
		setNumberofAdults(adultsCount);
		setNumberofChildrens(childrenCount);
		setNumberofRooms(roomCount);
	}

	public void setCityName(String cityName) {
		findElement(cityNameWebElement);
		sendKeys(cityName);
	}

	public void setDate(String checkInDate, String checkOutDate) {
		findElement(dateSearchBox);click();
		moveUntilFound(By.xpath("//td[@data-date=\"" + checkInDate + "\"]"));
		moveUntilFound(By.xpath("//td[@data-date=\"" + checkOutDate + "\"]"));
	}

	public void moveUntilFound(By selector) {
		WebDriver webDriver = getDriver();
		while (webDriver.findElements(selector).size() <= 0) {
			findElement(By.xpath("//div[@data-bui-ref=\"calendar-next\"]"));
			click();
		}
		findElement(selector);
		click();
	}

	public void setNumberofAdults(int adultsCount) {
		findElement(personSearchBox);click();
		findElement(By.xpath("//button[@aria-label=\"Increase number of Adults\"]"));
		if (adultsCount != 1)
			for (int i = 1; i < adultsCount; i++)
				click();
	}

	public void setNumberofChildrens(int childrensCount) {
		findElement(By.xpath("//button[@aria-label=\"Increase number of Children\"]"));
		for (int i = 1; i < childrensCount; i++)
			click();
	}
	
	
	public void setNumberofRooms(int roomsCount) {
		findElement(By.xpath("//button[@aria-label=\"Increase number of Rooms\"]"));
		for (int i = 1; i < roomsCount; i++)
			click();
	}
	
	public void search() {
		findElement(searchWebElement);
		click();
	}

}
