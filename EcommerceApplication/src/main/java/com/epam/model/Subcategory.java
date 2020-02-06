package com.epam.model;

import java.util.List;
import com.epam.Services.*;

public class Subcategory implements ecommerce
{
	 int subcategoryId;
	 String subcategoryName;
	 List<Product> products;
	 
	 
	public Subcategory(int subcategoryId, String subcategoryName, List<Product> products) {
		this.subcategoryId = subcategoryId;
		this.subcategoryName = subcategoryName;
		this.products = products;
	}
	public int getSubcategoryId() {
		return subcategoryId;
	}
	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}
	public String getSubcategoryName() {
		return subcategoryName;
	}
	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void showDetails() {
		System.out.println(subcategoryId+"."+subcategoryName);
	}
	 
}
