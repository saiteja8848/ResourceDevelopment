package com.epam.dao;

import java.util.ArrayList;
import java.util.List;
import com.epam.model.*;
import com.epam.Services.*;

public class Data implements ecommerce {
	List<ecommerce> ecommerceData = new ArrayList<ecommerce>();

	public Data() {
		addValue(new Category(1, "Electronics", getSubcategoryList(1)));
		addValue(new Category(2, "Fashion", getSubcategoryList(2)));
		showDetails();
	}

	List<Subcategory> getSubcategoryList(int v) {
		List<Subcategory> list = new ArrayList<Subcategory>();
		if (v == 1) {
			list.add(new Subcategory(1, "Mobiles", getProductList(1)));
			list.add(new Subcategory(2, "Laptops", getProductList(2)));
			list.add(new Subcategory(3, "Televisions", getProductList(3)));
		} else {
			list.add(new Subcategory(1, "Mens", getProductList(4)));
			list.add(new Subcategory(2, "Womens", getProductList(5)));
			list.add(new Subcategory(3, "Kids", getProductList(6)));
		}
		return list;
	}

	List<Product> getProductList(int v) {
		List<Product> list = new ArrayList<Product>();
		if (v == 1) {
			list.add(new Product(1, "samsung"));
			list.add(new Product(2, "iphone"));
			list.add(new Product(3, "realme"));
		} else if (v == 2) {
			list.add(new Product(1, "DELL"));
			list.add(new Product(2, "HP"));
			list.add(new Product(3, "MAC"));
		} else if (v == 3) {
			list.add(new Product(1, "LG"));
			list.add(new Product(2, "SONY"));
			list.add(new Product(3, "ONIDA"));
		}
		return list;
	}

	public void showDetails() {
		for (ecommerce value : ecommerceData)
			value.showDetails();
	}

	public void addValue(ecommerce anyType) {
		ecommerceData.add(anyType);
	}

	public void printSubCategorys(int categoryOption) {
		Category category = (Category) ecommerceData.get(categoryOption);
		List<Subcategory> subcategory = category.getSubcategorys();
		for (int index = 0; index < subcategory.size(); index++)
			subcategory.get(index).showDetails();
	}

	public void printProducts(int categoryOption, int subcategoryOption) {
		Category category = (Category) ecommerceData.get(categoryOption);
		List<Product> product = category.getSubcategorys().get(subcategoryOption).getProducts();
		for (int index = 0; index < product.size(); index++)
			product.get(index).showDetails();

	}

}
