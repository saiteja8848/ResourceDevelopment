package com.epam.CalculatorTesting;
import org.testng.annotations.DataProvider;

public class DemoDataProvider{
	
	@DataProvider(name="sumValues")
	public static Object[][] getSumValues(){
		return new Object[][] {
			{1L, 2L, 3L},
			{1.2d, 2.3d, 3.5d}
		};
	}
}