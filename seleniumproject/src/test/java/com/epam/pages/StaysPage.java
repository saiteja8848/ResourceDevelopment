package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class StaysPage {

	@FindBy(xpath = "//input[@id=\"ss\"]")
	private WebElement cityNameWebElement;

	@FindBy(xpath = "//span[@class=\"sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb\"]")
	private WebElement dateSearchBox;

	@FindBy(xpath = "//span[@class=\"xp__guests__count\"]")
	private WebElement personSearchBox;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement searchWebElement;

	private WebDriver driver;
	
	private String url="https://www.booking.com";

	public StaysPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setData(String cityName, String checkInDate, String checkOutDate, int adultsCount, int childrenCount,int roomCount) {
		setCityName(cityName);
		setDate(checkInDate, checkOutDate);
		setNumberofAdults(adultsCount);
		setNumberofChildrens(childrenCount);
		setNumberofRooms(roomCount);
	}
   
	public void openPage() {
		driver.get(url);
	}
	
	
	public void setCityName(String cityName) {
		cityNameWebElement.sendKeys(cityName);

	}

	public void setDate(String checkInDate, String checkOutDate) {
		dateSearchBox.click();
		moveUntilFound(By.xpath("//td[@data-date=\"" + checkInDate + "\"]"));
		moveUntilFound(By.xpath("//td[@data-date=\"" + checkOutDate + "\"]"));
	}

	public void moveUntilFound(By selector) {
		while (driver.findElements(selector).size() <= 0) {
			driver.findElement(By.xpath("//div[@data-bui-ref=\"calendar-next\"]")).click();
		}
		driver.findElement(selector).click();
	}

	public void setNumberofAdults(int adultsCount) {
		personSearchBox.click();
		if (adultsCount != 1)
			for (int i = 1; i < adultsCount; i++)
				driver.findElement(By.xpath("//button[@aria-label=\"Increase number of Adults\"]")).click();
	}

	public void setNumberofChildrens(int childrensCount) {
		for (int i = 1; i < childrensCount; i++)
			driver.findElement(By.xpath("//button[@aria-label=\"Increase number of Children\"]")).click();
	}

	public void setNumberofRooms(int roomsCount) {
		for (int i = 1; i < roomsCount; i++)
			driver.findElement(By.xpath("//button[@aria-label=\"Increase number of Rooms\"]")).click();
	}

	public void search() {
		searchWebElement.click();
	}

}
