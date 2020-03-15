package com.epam.testpages;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.epam.pages.AirPortTaxisPage;
import com.epam.pages.CarRentalPage;
import com.epam.pages.StaysPage;
import com.epam.testcontroller.TestController;


@Listeners(com.epam.utilites.TestListener.class)
public class SearchRelatedTesting extends TestController {
	private StaysPage staysPage;
    private CarRentalPage c;
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		//staysPage = new StaysPage(webDriver);
		// c = new CarRentalPage(webDriver);
		webDriver.get("https://www.booking.com");
	}

	@Test(enabled=false,priority=1,dataProviderClass = TestDataProvider.class, dataProvider = "staysTestData")
	public void staysPageTest(Object[] data) {	
		staysPage.openPage();
		String place = (String) data[0];
		String x = (String) data[1];
		String y = (String) data[2];
		staysPage.setData(place, x, y, 10, 10, 20);
		staysPage.search();
	
	}
	
	
	@Test(enabled=false)
	public void carRentals() throws InterruptedException {
		c.open();
		Thread.sleep(2000);
		c.setPickUp("hyderabad");
		c.gotoDifferntPlace();
		c.setDropOff("delhi");
		c.setDriverAge("70");
		c.search();
	}

	@Test
	public void airportTaxis() {
		
		AirPortTaxisPage a = new AirPortTaxisPage(webDriver);
		//PageFactory.initElements(webDriver,a.getClass());
		a.open();
		a.search();
		}
	
	

}
