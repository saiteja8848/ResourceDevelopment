package com.epam.model;

public class Product {
	private String name;
	private int price;
	private int quantity;
	private int maincategory_id;
	private int subcategory_id;
	private int product_id;
	
	public int getMaincategory_id() {
		return maincategory_id;
	}
	public void setMaincategory_id(int maincategory_id) {
		this.maincategory_id = maincategory_id;
	}
	public int getSubcategory_id() {
		return subcategory_id;
	}
	public void setSubcategory_id(int subcategory_id) {
		this.subcategory_id = subcategory_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	

}
