package com.epam.model;

import java.util.List;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.services.Ecommerce;


public class Subcategory implements Ecommerce
{
	 private static Logger logger = LogManager.getLogger(Subcategory.class);
	 int subcategoryId;
	 String subcategoryName;
	 List<Product> products= new ArrayList<>();
	 
	 public Subcategory() {}
	 
	public Subcategory(int subcategoryId, String subcategoryName) {
		this.subcategoryId = subcategoryId;
		this.subcategoryName = subcategoryName;
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
		logger.info("{}{}.{}","\n",subcategoryId,subcategoryName);
	}
	 
}
