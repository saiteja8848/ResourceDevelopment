package com.epam.dao;

import com.epam.model.*;
import java.util.List;
import java.util.ArrayList;

public class Details {
	private List<Category> categorysList = new ArrayList<>();
	private List<SubCategory> subcategorysList = new ArrayList<>();
	private List<Product> productsList = new ArrayList<>();
	private List<Cart> cartitemsList = new ArrayList<>();
	private List<Cart> cartitemslistUpdate = new ArrayList<>();

	public void setCategorys() {
		Category electronics = new Category(1, "Electronics");
		Category fashion = new Category(2, "Fashion");
		categorysList.add(electronics);
		categorysList.add(fashion);
	}

	public List<Category> getCategorys() {
		return categorysList;
	}

	public void setsubCategories() {
		subcategorysList.add(new SubCategory(1, 1, "Mobile"));
		subcategorysList.add(new SubCategory(1, 2, "Televisions"));
		subcategorysList.add(new SubCategory(1, 3, "Laptops"));
		subcategorysList.add(new SubCategory(2, 1, "Mens"));
		subcategorysList.add(new SubCategory(2, 2, "Womens"));
		subcategorysList.add(new SubCategory(2, 3, "Kids"));
	}

	public List<SubCategory> findsubCategories() {
		return subcategorysList;
	}

	public void setProducts() {
		productsList.add(new Product(1, 1, 1, "Samsung", 21000, 4));
		productsList.add(new Product(1, 1, 2, "Iphone", 50000, 5));
		productsList.add(new Product(1, 1, 3, "realme", 12000, 3));
		productsList.add(new Product(1, 2, 1, "ONIDA", 20000, 6));
		productsList.add(new Product(1, 2, 2, "SONY", 60000, 5));
		productsList.add(new Product(1, 2, 3, "SAMSUNG", 75000, 6));
		productsList.add(new Product(1, 3, 1, "Apple", 20000, 6));
		productsList.add(new Product(1, 3, 2, "Dell", 60000, 5));
		productsList.add(new Product(1, 3, 3, "Hp", 75000, 6));
		productsList.add(new Product(2, 1, 1, "levis", 5000, 10));
		productsList.add(new Product(2, 1, 2, "denim", 1500, 10));
		productsList.add(new Product(2, 1, 3, "raymond", 2500, 10));
		productsList.add(new Product(2, 2, 1, "Sarees", 1800, 14));
		productsList.add(new Product(2, 2, 2, "causal", 1800, 4));
		productsList.add(new Product(2, 2, 3, "formal", 2800, 4));
		productsList.add(new Product(2, 3, 1, "Kids-1", 1300, 3));
		productsList.add(new Product(2, 3, 2, "kids-2", 1800, 4));
		productsList.add(new Product(2, 3, 3, "kids-3", 1000, 4));
	}

	public List<Product> getProducts() {
		return productsList;
	}

	
	public List<Cart> getCartProducts() {
		return cartitemsList;
	}

	public List<Cart> getCartUpdate() {
		return cartitemslistUpdate;
	}

}
