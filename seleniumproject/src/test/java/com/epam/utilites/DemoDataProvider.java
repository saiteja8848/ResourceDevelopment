package com.epam.utilites;

import java.util.List;

public class DemoDataProvider {

	public static void main(String[] args) throws Exception {
		ReadExcelSheet readExcelSheet = new ReadExcelSheet();
		readExcelSheet.intialization("src/test/resources/TestData/searchtestdata.xlsx", "sheet1");
		readExcelSheet.loadData();
		Object[][] data = readExcelSheet.getData();

		System.out.println(data.length);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.println(data[i][j] + "  ");
			}
			System.out.println();
		}

	}
}