package com.epam.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AirPortTaxisPage {

	@FindBy(xpath = "//a[4]/span[2]")
	private WebElement airportPageLink;

	@FindBy(xpath = "//label[@class='rw-radio rw-return-radio__affirmative']//span[@class='rw-radio__label']")
	private WebElement returnButton;

	@FindBy(xpath = "//input[@id=\"pickupLocation\"]")
	private WebElement pickup;

	@FindBy(xpath = "//input[@id=\"dropoffLocation\"]")
	private WebElement dropoff;

	@FindBy(xpath = "//button[@data-test=\"pickup-date\"]")
	private WebElement pickupdate;
	
	@FindBy(xpath="//button[@data-test=\"pickup-time\"]")
    private WebElement pickuptime;

	@FindBy(xpath="//select[@id='pickupHour']")
	private WebElement pickupHour;
	
    @FindBy(xpath="//select[@id=\"pickupMinute\"]")
    private WebElement pickupMinute;
	
    @FindBy(xpath="//button[@class=\"rw-time-picker__confirm\"]")
    private WebElement confirmbutton;
    
    
    @FindBy(xpath="//select[@id='passengers']")
    private WebElement personsCount;
    
    @FindBy(xpath="//div[@class='gb-u-display-none gb-u-display-block@l gb-u-mb-']//button[@name='searchButton']")
    private WebElement searchelement;
    
    
    private Select select;
    
    private String url="https://www.booking.com";
	
	
	  public AirPortTaxisPage(WebDriver driver) { 
		  PageFactory.initElements(driver, this); 
		  }
	 
	public void open() {	
		airportPageLink.click();
	}

	public void clickReturn() {
		returnButton.click();
	}

	public void setPickUp(String from) {
		pickup.sendKeys(from);
	}

	public void setDropoff(String to) {
		dropoff.sendKeys(to);
	}

	public void setPickUpdate(String date) {
       pickupdate.click();
	}
	
	public void setPickUpTime(String hours,String minutes) {
		pickuptime.click();
		select = new Select(pickupHour);
		select.selectByValue(hours);
	    select = new Select(pickupMinute);
		select.selectByValue(minutes);
		confirmbutton.click();
	}
	
	public void peopleCount(String count) {
		select = new Select(personsCount);
		select.selectByValue(count);
	}
	
    public void search() {
     searchelement.click();	
    }
	
}


