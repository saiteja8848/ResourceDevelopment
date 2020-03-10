package com.epam.utilites;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheet {

	private String excelSheetName;
	private String excelFilePath;
	private String currentPath;
	private XSSFWorkbook workBook;
	private XSSFSheet workSheet;

	public ReadExcelSheet(String excelFilePath, String excelSheetName) {
		this.excelFilePath = excelFilePath;
		this.excelSheetName = excelSheetName;

	}

	public void intialization() throws IOException {
		currentPath = System.getProperty("user.dir");
		workBook = new XSSFWorkbook(currentPath + excelFilePath);
		workSheet = workBook.getSheet(excelSheetName);
		String cellValue = workSheet.getRow(0).getCell(0).getStringCellValue();

	}

}
