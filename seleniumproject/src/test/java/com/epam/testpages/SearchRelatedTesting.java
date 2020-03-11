package com.epam.testpages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.pages.StaysPage;
import com.epam.testcontroller.TestController;

public class StaysTestPage extends TestController {
	private StaysPage staysPage;

	@BeforeMethod
	public void beforeMethod() {
		staysPage = new StaysPage(webDriver);
	}

	@Test
	public void staysTest() {
		staysPage.openPage();
		staysPage.setData("hyderabad","2020-03-20","2020-04-10",10,5,5);
		staysPage.search();
	}
	
	
}
