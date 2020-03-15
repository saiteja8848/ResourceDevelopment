package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.epam.utilites.Page;

public class CarRentalPage extends Page {

	private By pickupWebElement = By.xpath("//input[@id=\"ss_origin\"]");
	
	private By returnRadioButton = By.xpath("//label[@for=\"return-location-different\"]");
	private By dropoffWebElement = By.xpath("//input[@id=\"ss\"]");
	private By driverAgeCheckBox = By.xpath("//span[@class=\"bui-checkbox__label\"]");
	private By driverAgeText = By.xpath("//input[@id=\"driverAgeInput\"]");
	private By searchWebElement = By.xpath("//button[@class=\"sb-searchbox__button \"]");
	private By openCalender = By.xpath("//div[@class=\"xp__dates-inner\"]");
	private String url = "http://www.booking.com";

	public CarRentalPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void open() {
		openPage(url);
		getDriver().findElement(By.xpath("//span[@class='xpb__link__text']")).click();
	}

	public void setPickUp(String place) {
		findElement(pickupWebElement);
		sendKeys(place);
		System.out.println(place);
	}

	public void gotoDifferntPlace() {
		findElement(returnRadioButton);
		click();
	}

	public void setDropOff(String place) {
		findElement(dropoffWebElement);
		sendKeys(place);
	}
	
	public void setDriverAge(String age) {
		findElement(driverAgeCheckBox);click();
		findElement(driverAgeText);
		sendKeys(age);
	}
	
	
	public void search() {
		findElement(searchWebElement);
		click();
	}

}
