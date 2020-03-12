package com.epam.seleniumproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppTest {
	public static void main(String args[]) throws IOException {

		
		String current=System.getProperty("user.dir");
		//XSSFWorkbook x = new XSSFWorkbook("C:\\Users\\User\\Desktop\\seleniumproject\\src\\test\\resources\\TestData\\TestDataInput.xlsx");
		XSSFWorkbook x = new XSSFWorkbook(current+"/src/test/resources/TestData/TestDataInput.xlsx");
        XSSFSheet s= x.getSheet("Sheet1");        
        String cellvalue= s.getRow(1).getCell(0).getStringCellValue();
        System.out.println(cellvalue);
        System.out.println(s.getPhysicalNumberOfRows());
		
       // Logger logger =LogManager.getLogger(pratice.class);
	}
}
