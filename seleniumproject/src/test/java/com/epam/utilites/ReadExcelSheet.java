package com.epam.utilites;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheet {

	private XSSFWorkbook workBook;
	private XSSFSheet workSheet;
	private DataFormatter formatter;
	private List<List<String>> data;
	private String value;
	private List<String> Sdata;

	

	public void intialization(String excelFilePath,String excelSheetName) throws IOException {
		workBook = new XSSFWorkbook(excelFilePath);
		workSheet = workBook.getSheet(excelSheetName);
		formatter = new DataFormatter();
		loadData();
	}

	public void loadData() {
		data = new ArrayList<List<String>>();
		for (int i = 1; i < workSheet.getLastRowNum(); i++) {
			Sdata = new ArrayList<String>();
			for (int j = 0; j < workSheet.getRow(i).getLastCellNum(); j++) {
				value = formatter.formatCellValue(workSheet.getRow(i).getCell(j));
				Sdata.add(value);
			}
			data.add(Sdata);
		}
	}

	public Object[][] getData() {
		return data.stream().map(List::toArray).toArray(Object[][]::new);
	}

}
