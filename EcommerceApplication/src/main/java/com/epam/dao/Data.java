package com.epam.dao;

import java.util.ArrayList;
import java.util.List;
import com.epam.model.*;
import com.epam.Services.*;

class PrepareData {
	public Category category = new Category();
	public List<Subcategory> subcategorys = new ArrayList<Subcategory>();

	void setCategory(int categoryId, String categoryName) {
		category.setCategoryId(categoryId);
		category.setCategoryName(categoryName);
	}

	void setSubcategorys(String[] subcategorysList, String[] productsList,int[] quantity,int[] price) {
		int count = 0;
		int j = 0;
		for (int i = 0; i <= 2; i++) {
			Subcategory subcategory = new Subcategory((i + 1), subcategorysList[i]);
			count = 1;
			while (count != 3) {
				subcategory.getProducts().add(new Product(count, productsList[j],quantity[j],price[j]));
				j++;
				count++;
			}
			subcategorys.add(subcategory);
		}
		category.setSubcategorys(subcategorys);
	}

	public Category getCategory() {
		return category;
	}
}



class Composite implements ecommerce {
	private List<ecommerce> ecommerceData = new ArrayList<ecommerce>();

	public void showDetails() {
		for (ecommerce e : ecommerceData)
			e.showDetails();
	}

	public void addDetails(ecommerce anyImplementationclass) {
		ecommerceData.add(anyImplementationclass);
	}

	public Category getDetails(int categoryOption) {
		return (Category) ecommerceData.get(categoryOption);
	}

}



public class Data {
	private Composite composite = new Composite();
	private PrepareData preparedata1 = new PrepareData();
	private PrepareData preparedata2 = new PrepareData();

	public void setData() {
		preparedata1.setCategory(1, "electronics");
		String[] subcategorylist1 = { "mobiles", "Laptops", "Televisons" };
		String[] productslist1 = { "samsung", "realme", "dell", "Hp", "sony", "oneplus" };
		int[] quantitylist1 = {4,5,6,1,2,3};
		int[] pricelist1 = {10000,21000,5000,50000,45000,60000};
		preparedata1.setSubcategorys(subcategorylist1, productslist1,quantitylist1,pricelist1);
		composite.addDetails(preparedata1.getCategory());

		preparedata2.setCategory(2, "Fashion");
		String[] subcategorylist2 = { "mens", "Womens", "Kids" };
		String[] productslist2 = { "mens-1", "mens-2", "women-1", "women-2", "kid-1", "kid-2" };
		int[] quantitylist2 = {4,5,6,1,2,3};
		int[] pricelist2 = {1000,2100,5000,5000,4500,6000};
		preparedata2.setSubcategorys(subcategorylist2, productslist2,quantitylist2,pricelist2);
		composite.addDetails(preparedata2.getCategory());
	}

	public void printCategorysData() {
		composite.showDetails();
	}

	public void printSubCategorysData(int categoryOption) {
		Category category = composite.getDetails(categoryOption);
		List<Subcategory> sc = category.getSubcategorys();
		for (Subcategory e : sc)
			e.showDetails();
	}

	public void printProductsData(int categoryOption, int subcategoryOption) {
		Category category = composite.getDetails(categoryOption);
		List<Product> p = category.getSubcategorys().get(subcategoryOption).getProducts();
		for (Product e : p)
			e.showDetails();
	}
   public Category get(int categoryOption) {
	   return composite.getDetails(categoryOption);
   }
	
}

