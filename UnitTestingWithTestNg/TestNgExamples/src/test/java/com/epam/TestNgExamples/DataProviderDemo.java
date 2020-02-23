package com.epam.TestNgExamples;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderDemo {
  @Test(dataProvider = "x")
  public void f(Integer n, String s) {
	  System.out.println("hello "+s);
  }

  @DataProvider(name="x")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },};
  }

}
