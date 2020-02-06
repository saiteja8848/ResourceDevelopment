package com.epam.model;

public class Product 
{
	private String name;
	private int price;
	private int quantity;
	private int maincategoryId;
	private int subcategoryId;
	private int productId;
	
	public Product() {}
	public Product(Product copy) {
		name = copy.name;
		price = copy.price;
		quantity = copy.quantity;
	     maincategoryId = copy.maincategoryId;
		subcategoryId = copy.subcategoryId;
		productId = copy.productId;
		
	}
	
	public Product( int maincategoryId, int subcategoryId, int productId,String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.maincategoryId = maincategoryId;
		this.subcategoryId = subcategoryId;
		this.productId = productId;
	}
	public int getmaincategoryId() {
		return maincategoryId;
	}
	public void setmaincategoryId(int maincategoryId) {
		this.maincategoryId = maincategoryId;
	}
	public int getsubcategoryId() {
		return subcategoryId;
	}
	public void setsubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
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
	public int getproductId() {
		return productId;
	}
	public void setproductId(int productId) {
		this.productId = productId;
	}
	
	

}
