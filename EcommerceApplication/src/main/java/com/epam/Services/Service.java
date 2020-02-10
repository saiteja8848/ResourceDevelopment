package com.epam.services;

public interface Service {

public void showCategories();
public void showSubCategorysById(int categoryOption);
public void showProductsById(int categoryOption, int subcategoryOption);
public void showcartProducts();
public void addproductToCart(int categoryOption, int subcategoryOption, int productOption, int quantity);
public void billing();
	
}
