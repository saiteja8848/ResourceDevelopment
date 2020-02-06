package com.epam.model;

import com.epam.Services.*;
public class Product implements ecommerce
{
	int productId;
	String productName;
	public Product(int productId, String productName) {
		this.productId = productId;
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void showDetails() {
		System.out.println(productId+"."+productName);
	}
}
