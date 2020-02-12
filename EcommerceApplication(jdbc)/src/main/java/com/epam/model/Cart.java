package com.epam.model;

public class Cart {
	int categoryId;
	int subcategoryId;
	int quantity;
	Product product;
	Product originalProduct;
	public Product getOriginalProduct() {
		return originalProduct;
	}

	public void setOriginalProduct(Product originalProduct) {
		this.originalProduct = originalProduct;
	}

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

	public Cart(int categoryId, int subcategoryId) {
		this.categoryId = categoryId;
		this.subcategoryId = subcategoryId;

	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
