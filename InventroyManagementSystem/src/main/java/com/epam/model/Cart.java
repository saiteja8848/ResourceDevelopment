package com.epam.model;


public class Cart {

	private Product cart_products=null;
	private int original_quantity;

	public Product getCart_products() {
		return cart_products;
	}

	public void setCart_products(Product p) {
		cart_products = p;
	}

	public int getOriginal_quantity() {
		return original_quantity;
	}

	public void setOriginal_quantity(int original_quantity) {
		this.original_quantity = original_quantity;
	}
	

	
	
	
	
}
