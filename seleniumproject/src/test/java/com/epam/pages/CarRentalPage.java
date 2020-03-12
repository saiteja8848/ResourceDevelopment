package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.epam.utilites.Page;

public class CarRentalPage extends Page {
	
	
	private By pickupWebElement=By.xpath("//input[@id=\"ss_origin\"]");
	private By returnRadioButton=By.xpath("//label[@for=\"return-location-different\"]");
	private By dropoffWebElement=By.xpath("//input[@id=\"ss\"]");
	private By driverAgeCheckBox=By.xpath("//span[@class=\"bui-checkbox__label\"]");
	private By driverAgeText=By.xpath("//input[@id=\"driverAgeInput\"]");
	private By searchWebElement=By.xpath("//button[@class=\"sb-searchbox__button \"]");
	private By openCalender=By.xpath("//div[@class=\"xp__dates-inner\"]");
	private String url="http://www.booking.com";
	
	public CarRentalPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void setDate(String pickUp,String dropoff,String checkInDate,String checkOutDate,int driverAge) {
		
	}
		
}
