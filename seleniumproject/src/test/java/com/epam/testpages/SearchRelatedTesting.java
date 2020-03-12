package com.epam.testpages;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.epam.pages.StaysPage;
import com.epam.testcontroller.TestController;


@Listeners(com.epam.utilites.TestListener.class)
public class SearchRelatedTesting extends TestController {
	private StaysPage staysPage;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		staysPage = new StaysPage(webDriver);
	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "staysTestData")
	public void staysPageTest(Object[] data) {	
		staysPage.openPage();
		String place = (String) data[0];
		String x = (String) data[1];
		String y = (String) data[2];
		staysPage.setData(place, x, y, 10, 10, 20);
		staysPage.search();
	
	}
	
	
	@AfterMethod
	public void afterMethod() {
		staysPage.closePage();
	}

}
