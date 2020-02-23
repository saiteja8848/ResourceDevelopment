package com.epam.CalculatorTesting;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.tat.module4.Calculator;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class CalculatorAppTesting {
	private static Calculator calculator;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Testing Calculator Application\n");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Completed Testing Application");
	}
	
}


