package com.epam.testpages;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.epam.pages.AirPortTaxisPage;
import com.epam.pages.CarRentalPage;
import com.epam.pages.FlightsPage;
import com.epam.pages.StaysPage;
import com.epam.testcontroller.TestController;
import com.epam.utilites.ReadExcelSheet;


@Listeners(com.epam.utilites.TestListener.class)
public class SearchRelatedTesting extends TestController {
	private StaysPage staysPage;
    private CarRentalPage carRentalPage;
    private AirPortTaxisPage airportTaxisPage;
    private FlightsPage flightsPage;
	

	@Test(enabled=true,dataProviderClass=TestDataProvider.class,dataProvider="staysTestData")
	public void staysPageTest(Object[] data) {
		  staysPage= new StaysPage(webDriver); staysPage.openPage();
		  staysPage.setData("hyderabad","2020-03-25","2020-04-20",10, 10, 20);
		  staysPage.search();
	}
	
	
	
	  @Test(enabled=false) public void carRentals() throws InterruptedException {
	  carRentalPage = new CarRentalPage(webDriver); 
	  carRentalPage.openPage(); 
	  carRentalPage.setData("hyderabad","delhi","20"); 
	  carRentalPage.setDate(); 
	  // carRentalPage.search();
	  }
	  
	  @Test(enabled=false) 
	  public void airportTaxis() {
		  airportTaxisPage = new  AirPortTaxisPage(webDriver);
		  airportTaxisPage.open();
	  airportTaxisPage.search();
	  }
	  
	  @Test(enabled=true) 
	  public void flightsPage() { 
		  flightsPage = new FlightsPage(webDriver);
		  flightsPage.openPage();
	      flightsPage.setFrom("hyderabad");
	      flightsPage.setFrom("delhi");
	  }
	 
	
	

}

