package com.epam.testpages;

import java.io.IOException;
import org.testng.annotations.DataProvider;

import com.epam.utilites.ReadExcelSheet;



public class TestDataProvider {
	
	

	@DataProvider(name="staysTestData")
	public static  Object[][] staysTestData() throws IOException{
		  ReadExcelSheet readExcelSheet = new  ReadExcelSheet();
		  readExcelSheet.intialization("src/test/resources/TestData/searchtestdata.xlsx","sheet1"); 
		  Object[][] object =readExcelSheet.getData();			 
		
		  return object;
	}
	
	

	
	
}
