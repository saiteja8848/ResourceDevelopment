package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage {
	
	
	
	  @FindBy( xpath="//a[@data-ga-track=\"click|Product Expansion|flights|kayak (index)\"]")
	  private WebElement FlightPageLink;
	  
	  @FindBy(xpath="//input[@placeholder=\"From where?\"]") 
	  private WebElement arrivalPlace;
	  
	  @FindBy(xpath="//input[contains(@id,\"-origin-nearbyCheck\")]") 
	  private WebElement arrivalNearby;
	  
	  @FindBy(xpath="//input[@placeholder=\"To where?\"]") 
	  private WebElement destinationPlace;
	  
	  @FindBy(xpath="//*[@aria-label=\"Departure date input\"]") 
	  private WebElement arrivalDate;
	  
	  @FindBy(xpath="//*[contains(@id,\"fields\")]/div[@class=\"col-travelers col-field\"]/div[1]") 
	  private WebElement adults;
	  
	  @FindBy(xpath="//div[contains(@aria-labelledby,\"adultsLabel\")]//button[@title=\"Increment\"]")
	  private WebElement xpathOfAdults;
	  
	  @FindBy(xpath="//div[contains(@aria-labelledby,\"youthLabel\")]//button[@title=\"Increment\"]")
	  private WebElement xpathOfYouth;
	  
	  @FindBy(xpath="//div[contains(@aria-labelledby,\"seatInfantLabel\")]//button[@title=\"Increment\"]")
	  private WebElement xpathOfSeatInfant;
	  
	  @FindBy(xpath="//div[contains(@aria-labelledby,\"childLabel\")]//button[@title=\"Increment\"]")
	  private WebElement xpathOfChild;
	  
	  @FindBy(xpath="//div[contains(@aria-labelledby,\"lapInfantLabel\")]//button[@title=\"Increment\"]")
	  private WebElement xpathOfLapInfant;
	  
	  @FindBy(xpath="//div[@class=\"fieldBlock buttonBlock\"]//button[@type='submit']")
	  private WebElement searchWebElement;
	  
	  @FindBy(xpath="//div[@aria-label=\"Next month\"]") 
	  private WebElement nextMonth;
	  
	  @FindBy(xpath="//input[@value=\"oneway\"]") 
	  private WebElement oneWay;
	  
	/*
	 * @FindBy(xpath="//input[@value=\"multicity\"]") private By
	 * xpathOfCabinClass=By.xpath("//span[@role=\"radiogroup\"]//child::label");
	 * 
	 * @FindBy(xpath="//div//span[text()=\"Add another flight\"]") private
	 * WebElement xpathOfAddFlight;
	 */
	
	  private String url="http://www.booking.com";
	  
	  private WebDriver driver;
	  public FlightsPage(WebDriver driver) {
		  this.driver= driver;
		  PageFactory.initElements(driver,this);
	  }
	  
	public void openPage() {
	    driver.get(url);
	    FlightPageLink.click();	
	}
	
	public void setFrom(String place) {	
		arrivalPlace.sendKeys(place);
		
	}
	
	public void setTo(String place) {
		destinationPlace.sendKeys(place);
	}
	
	public void Date() {
		arrivalDate.click();
	}
	
	public void search() {
		searchWebElement.click(); 
	}
	
	
}
