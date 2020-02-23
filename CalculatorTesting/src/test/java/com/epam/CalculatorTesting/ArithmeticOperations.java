package com.epam.CalculatorTesting;

import org.testng.annotations.Test;
import com.epam.tat.module4.Calculator;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass;


public class ArithmeticOperations {
	
	public static Calculator calculator;

	@BeforeClass(groups= {"arithmetic"})
	public void setUp() {
		calculator = new Calculator();
	}

	@Test(dataProviderClass= DemoDataProvider.class, dataProvider="sumValues",  groups= {"arithmetic"})
	public static void additionTest(Number a, Number b, Number result) {
		if(a instanceof Long)
			assertEquals(calculator.sum((Long)a, (Long)b),result);
		else
			assertEquals(calculator.sum((Double)a, (Double)b),result);
	}
		
}
