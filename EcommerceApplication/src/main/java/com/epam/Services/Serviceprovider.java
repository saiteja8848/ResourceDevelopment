package com.epam.Services;

import com.epam.dao.*;

public class Serviceprovider {
	Data data;

	public void loadData() {
		data = new Data();
	}

	public void printSubCategorysById(int categoryOption) {
		data.printSubCategorys(categoryOption-1);
	}

	public void printProductsById(int categoryOption, int subcategoryOption) {
		data.printProducts(categoryOption-1, subcategoryOption-1);
	}

}
