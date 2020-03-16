package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CarRentalPage {

	
	@FindBy(xpath="//span[@class='xpb__link__text']")
	private WebElement carRentalsLink;
	
	@FindBy(xpath="//input[@id=\"ss_origin\"]")
	private WebElement pickupWebElement;
	
	@FindBy(xpath="//label[@for=\"return-location-different\"]")
	private WebElement returnRadioButton;
	
	@FindBy(xpath="//input[@id=\"ss\"]")
	private  WebElement dropoffWebElement;
	
	@FindBy(xpath="//span[@class=\"bui-checkbox__label\"]")
	private WebElement driverAgeCheckBox;
	
	@FindBy(xpath="//input[@id=\"driverAgeInput\"]")
	private WebElement driverAgeText;
	
	@FindBy(xpath="//button[@class=\"sb-searchbox__button \"]")
	private WebElement searchWebElement;
	
	@FindBy(xpath="//div[@class=\"xp__dates-inner\"]")
	private WebElement openCalender;
	
	@FindBy(xpath="//div[@data-mode=\"checkin\"]//button")
	private WebElement checkInDate;

	private WebDriver driver;
	
	private String url="https://www.booking.com";
	
	public CarRentalPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void openPage() {
		driver.get(url);
		carRentalsLink.click();
	}
	
	public void setData(String from,String to,String DriversAge) {
		if(from.equalsIgnoreCase(to))
			setPickUp(from);
		else {
			setPickUp(from);
			gotoDifferntPlace();
			setDropOff(to);
		   }
		int age=Integer.parseInt(DriversAge);
		if(age<30||age>66)
			setDriverAge(Integer.toString(age));
	}
	

	public void setPickUp(String place) {
		pickupWebElement.sendKeys(place);
	}

	public void gotoDifferntPlace() {
		returnRadioButton.click();
	}

	public void setDropOff(String place) {
	    dropoffWebElement.sendKeys(place);
	}
	
	public void setDriverAge(String age) {
	    driverAgeCheckBox.click();
		driverAgeText.sendKeys(age);
	}
		
	public void setDate() {
     	driver.findElement(By.xpath("//div[@data-mode=\"checkin\"]//button")).click();
     	
	}
	
	public void search() {
		searchWebElement.click();
	}

}
